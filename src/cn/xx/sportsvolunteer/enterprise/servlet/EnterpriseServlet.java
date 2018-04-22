package cn.xx.sportsvolunteer.enterprise.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xx.sportsvolunteer.beans.Enterprise;
import cn.xx.sportsvolunteer.beans.Game;
import cn.xx.sportsvolunteer.beans.Volunteer;
import cn.xx.sportsvolunteer.dao.EnterpriseDao;
import cn.xx.sportsvolunteer.dao.GameDao;
import cn.xx.sportsvolunteer.dao.VolunteerDao;
import cn.xx.sportsvolunteer.dao.impl.EnterpriseDaoImpl;
import cn.xx.sportsvolunteer.dao.impl.GameDaoImpl;
import cn.xx.sportsvolunteer.dao.impl.VolunteerDaoImpl;
import cn.xx.sportsvolunteer.utils.PasswordJM;

@WebServlet("/enterprise/EnterpriseServlet")
public class EnterpriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnterpriseDao enDao = new EnterpriseDaoImpl();
	private VolunteerDao vDao = new VolunteerDaoImpl();
	private GameDao gDao = new GameDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		} else if("register".equals(method)) {
			register(request,response);
			return;
		}
		//检查企业登陆状态
		Enterprise enterprise = (Enterprise) request.getSession().getAttribute("enterprise");
		if(enterprise==null) {
			request.setAttribute("message", "您未登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		switch (method) {
		case "logout":
			logout(request,response);
			break;
		case "listvolunteer":
			listvolunteer(request,response);
			break;
		default:
			break;
		}
	}

	private void listvolunteer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gameid = request.getParameter("gameid");
		List<Volunteer> list = vDao.getVolunteersByGame(gameid);
		request.setAttribute("list", list);
		Game game = gDao.getById(gameid);
		request.setAttribute("game", game);
		request.getRequestDispatcher("/jsp/enterprise/listgamevolunteer.jsp").forward(request, response);
		return;
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enterprise en = createEnterprise(request);
		String errorMessage = null;
		errorMessage = validate(en);
		if(errorMessage==null) {
			en.setPassword(PasswordJM.getJMPWD(en.getPassword()));
			enDao.add(en);
			//跳转登陆页面
			request.setAttribute("message", "注册成功");
			request.setAttribute("en", en);
			request.getRequestDispatcher("/jsp/enterprise/login.jsp").forward(request, response);
			return;
		}else {
			//回显数据到注册页面
			request.setAttribute("message", "注册失败:"+errorMessage);
			request.setAttribute("en", en);
			request.getRequestDispatcher("/jsp/enterprise/register.jsp").forward(request, response);
			return;
		}
	}

	private String validate(Enterprise en) {
		if(en.getPassword()==null||en.getPassword().trim().equals("")||en.getPassword2()==null||en.getPassword2().trim().equals("")) {
			return "密码不能为空";
		}
		if(!en.getPassword().equals(en.getPassword2())) {
			return "两次密码不一样";
		}
		if(en.getUsername()==null||en.getUsername().trim().equals("")) {
			return "用户名不能为空";
		}
		if(en.getUsername().length()>15) {
			return "用户名字数限制在15字以内";
		}
		if(en.getEnterpriseName()==null||en.getEnterpriseName().trim().equals("")) {
			return "企业名不能为空";
		}
		if(en.getEnterpriseName()!=null&&en.getEnterpriseName().length()>50) {
			return "企业名字数限制在50字以内";
		}
		return null;
	}

	private Enterprise createEnterprise(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String enterpriseName = request.getParameter("enterpriseName");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String business = request.getParameter("business");
		Enterprise en = new Enterprise(username,password,password2,enterpriseName,address,phonenumber,business);
		return en;
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("enterprise");
		response.sendRedirect(request.getContextPath()+"/jsp/enterprise/login.jsp");
		return;
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null||username.trim().equals("")) {
			request.setAttribute("message", "请输入用户名");
			request.getRequestDispatcher("/jsp/enterprise/login.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().equals("")) {
			request.setAttribute("message", "请输入密码");
			request.getRequestDispatcher("/jsp/enterprise/login.jsp").forward(request, response);
			return;
		}
		Enterprise enterprise = enDao.getByUsernameAndPassword(username,PasswordJM.getJMPWD(password));
		if(enterprise==null) {
			request.setAttribute("message", "用户名或者密码输入错误");
			request.getRequestDispatcher("/jsp/enterprise/login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("enterprise", enterprise);
		response.sendRedirect(request.getContextPath()+"/enterprise/IndexServlet");
//		response.sendRedirect(request.getContextPath()+"/enterprise/GameServlet?method=index");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
