package cn.xx.sportsvolunteer.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xx.sportsvolunteer.beans.Manager;
import cn.xx.sportsvolunteer.dao.ManagerDao;
import cn.xx.sportsvolunteer.dao.impl.ManagerDaoImpl;
import cn.xx.sportsvolunteer.utils.MD5Util;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/manager/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private ManagerDao mdao = new ManagerDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method = request.getParameter("method");
		if (method == null || method.trim().equals("")) {
			return;
		}
		switch (method) {
		case "login":
			login(request,response);
			break;
		case "logout":
			logout(request,response);
			break;
		default:
			break;
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("manager");
		response.sendRedirect(request.getContextPath()+"/jsp/manager/login.jsp");
		return;
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null||username.trim().equals("")) {
			request.setAttribute("message", "请输入用户名");
			request.getRequestDispatcher("/jsp/manager/login.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().equals("")) {
			request.setAttribute("message", "请输入密码");
			request.getRequestDispatcher("/jsp/manager/login.jsp").forward(request, response);
			return;
		}
		System.out.println(username);
		System.out.println(password);
		Manager manager = mdao.getByUsernameAndPassword(username,MD5Util.getMD5(password));
		if(manager==null) {
			request.setAttribute("message", "用户名或者密码输入错误");
			request.getRequestDispatcher("/jsp/manager/login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("manager", manager);
		response.sendRedirect(request.getContextPath()+"/GameServlet?method=index");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
