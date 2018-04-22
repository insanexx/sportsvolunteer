package cn.xx.sportsvolunteer.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xx.sportsvolunteer.beans.Enterprise;
import cn.xx.sportsvolunteer.beans.Game;
import cn.xx.sportsvolunteer.beans.Manager;
import cn.xx.sportsvolunteer.beans.Volunteer;
import cn.xx.sportsvolunteer.dao.EnterpriseDao;
import cn.xx.sportsvolunteer.dao.GameDao;
import cn.xx.sportsvolunteer.dao.ManagerDao;
import cn.xx.sportsvolunteer.dao.VolunteerDao;
import cn.xx.sportsvolunteer.dao.impl.EnterpriseDaoImpl;
import cn.xx.sportsvolunteer.dao.impl.GameDaoImpl;
import cn.xx.sportsvolunteer.dao.impl.ManagerDaoImpl;
import cn.xx.sportsvolunteer.dao.impl.VolunteerDaoImpl;
import cn.xx.sportsvolunteer.utils.PasswordJM;

@WebServlet("/manager/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerDao mDao = new ManagerDaoImpl();
	private VolunteerDao vDao = new VolunteerDaoImpl();
	private EnterpriseDao eDao = new EnterpriseDaoImpl();
	private GameDao gDao = new GameDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method = request.getParameter("method");
		if (method == null || method.trim().equals("")) {
			return;
		}
		if("login".equals(method)) {
			login(request,response);
			return;
		}
		//检查管理员登陆状态
		Manager m = (Manager) request.getSession().getAttribute("manager");
		if(m==null) {
			request.setAttribute("message", "您未登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		switch (method) {
		case "logout":
			logout(request,response);
			break;
		case "enterpriselist":
			enterpriselist(request,response);
			break;
		case "listgamevolunteer":
			listgamevolunteer(request,response);
			break;
		case "volunteerlist":
			volunteerlist(request,response);
			break;
		default:
			break;
		}
	}
	
	private void listgamevolunteer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gameid = request.getParameter("gameid");
		Game game = gDao.getById(gameid);
		List<Volunteer> list = vDao.getVolunteersByGame(gameid);
		request.setAttribute("list", list);
		request.setAttribute("game", game);
		request.getRequestDispatcher("/jsp/manager/listgamevolunteer.jsp").forward(request, response);
		return;
	}

	private void enterpriselist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Enterprise> list = eDao.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/manager/enterpriselist.jsp").forward(request, response);
		return;
	}

	private void volunteerlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Volunteer> list = vDao.getList(0, 9999);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/manager/volunteerlist.jsp").forward(request, response);
		return;
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
		Manager manager = mDao.getByUsernameAndPassword(username,PasswordJM.getJMPWD(password));
		if(manager==null) {
			request.setAttribute("message", "用户名或者密码输入错误");
			request.getRequestDispatcher("/jsp/manager/login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("manager", manager);
		response.sendRedirect(request.getContextPath()+"/manager/IndexServlet");
//		response.sendRedirect(request.getContextPath()+"/manager/GameServlet?method=index");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
