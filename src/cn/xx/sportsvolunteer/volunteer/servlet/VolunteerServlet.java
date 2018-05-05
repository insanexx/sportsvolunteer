package cn.xx.sportsvolunteer.volunteer.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import cn.xx.sportsvolunteer.beans.Game;
import cn.xx.sportsvolunteer.beans.Volunteer;
import cn.xx.sportsvolunteer.dao.GameDao;
import cn.xx.sportsvolunteer.dao.VolunteerDao;
import cn.xx.sportsvolunteer.dao.impl.GameDaoImpl;
import cn.xx.sportsvolunteer.dao.impl.VolunteerDaoImpl;
import cn.xx.sportsvolunteer.utils.IdGenerator;
import cn.xx.sportsvolunteer.utils.PasswordJM;

@WebServlet("/volunteer/VolunteerServlet")
public class VolunteerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VolunteerDao volunteerDao = new VolunteerDaoImpl();
	private GameDao gameDao = new GameDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method = request.getParameter("method");
		if (method == null || method.trim().equals("")) {
			return;
		}
		if("register".equals(method)) {
			register(request,response);
			return;
		}else if("login".equals(method)) {
			login(request,response);
			return;
		}
		Volunteer v = (Volunteer) request.getSession().getAttribute("volunteer");
		if(v==null) {
			request.setAttribute("message", "您未登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		switch (method) {
		case "logout":
			logout(request,response);
			break;
		case "entergame":
			entergame(request,response);
			break;
		case "updatevolunteer":
			updatevolunteer(request,response);
			break;
		default:
			break;
		}
	}

	private void updatevolunteer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Volunteer v = createVolunteerforupdate(request);
		Volunteer v_db = volunteerDao.getById(v.getId());
		if(v.getPassword()==null) {
			v.setPassword(v_db.getPassword());
		}else {
			v.setPassword(PasswordJM.getJMPWD(v.getPassword()));
		}
		try {
			volunteerDao.update(v);
			request.getSession().setAttribute("volunteer", v);
			response.sendRedirect(request.getContextPath()+"/volunteer/IndexServlet");
			return;
		}catch(MySQLIntegrityConstraintViolationException e) {
			request.setAttribute("message", "修改失败:用户名已被注册");
			request.setAttribute("v", v);
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
	}

	//报名
	private void entergame(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			Volunteer v = (Volunteer) request.getSession().getAttribute("volunteer");
			String id = request.getParameter("id");
			Game game = gameDao.getById(id);
			if(game.getRestcount()<=0) {
				request.setAttribute("message", "人数已满，报名失败");
				request.getRequestDispatcher("/jsp/volunteer/index.jsp").forward(request, response);
				return;
			}
			if(volunteerDao.isEnterGame(game,v)) {
				request.setAttribute("message", "你已经报名过了，请勿重复报名");
				request.getRequestDispatcher("/jsp/volunteer/index.jsp").forward(request, response);
				return;
			}
			
			volunteerDao.entergame(game, v);
			request.setAttribute("message", "报名成功");
			response.sendRedirect(request.getContextPath()+"/volunteer/IndexServlet");
//			request.getRequestDispatcher("/jsp/volunteer/index.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "报名失败");
			request.getRequestDispatcher("/jsp/volunteer/index.jsp").forward(request, response);
			return;
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("volunteer");
		response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
		return;
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null||username.trim().equals("")) {
			request.setAttribute("message", "请输入用户名");
			request.getRequestDispatcher("/jsp/volunteer/login.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().equals("")) {
			request.setAttribute("message", "请输入密码");
			request.getRequestDispatcher("/jsp/volunteer/login.jsp").forward(request, response);
			return;
		}
		Volunteer volunteer = volunteerDao.getByUsernameAndPassword(username,PasswordJM.getJMPWD(password));
		if(volunteer==null) {
			request.setAttribute("message", "用户名或者密码输入错误");
			request.getRequestDispatcher("/jsp/volunteer/login.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("volunteer", volunteer);
		response.sendRedirect(request.getContextPath()+"/volunteer/IndexServlet");
		return;
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Volunteer v = createVolunteer(request);
		String errorMessage = null;
		errorMessage = validate(v);
		if(errorMessage==null) {
			v.setPassword(PasswordJM.getJMPWD(v.getPassword()));
			try {
				volunteerDao.add(v);
			}catch(MySQLIntegrityConstraintViolationException e) {
				errorMessage = "用户名已被注册";
				request.setAttribute("message", "注册失败:"+errorMessage);
				request.setAttribute("v", v);
				request.getRequestDispatcher("/jsp/volunteer/register.jsp").forward(request, response);
				return;
			}
			//跳转登陆页面
			request.setAttribute("message", "注册成功");
			request.setAttribute("v", v);
			request.getRequestDispatcher("/jsp/volunteer/login.jsp").forward(request, response);
			return;
		}else {
			//回显数据到注册页面
			request.setAttribute("message", "注册失败:"+errorMessage);
			request.setAttribute("v", v);
			request.getRequestDispatcher("/jsp/volunteer/register.jsp").forward(request, response);
			return;
		}
	}

	private String validate(Volunteer v) {
		if(v.getPassword()==null||v.getPassword().trim().equals("")||v.getPassword2()==null||v.getPassword2().trim().equals("")) {
			return "密码不能为空";
		}
		if(!v.getPassword().equals(v.getPassword2())) {
			return "两次密码不一样";
		}
		if(v.getUsername()==null||v.getUsername().trim().equals("")) {
			return "用户名不能为空";
		}
		if(v.getUsername().length()>15) {
			return "用户名字数限制在15字以内";
		}
		if(v.getAddress()==null||v.getAddress().trim().equals("")) {
			return "地址不能为空";
		}
		if(v.getAddress().length()>100) {
			return "地址限制在100字以内";
		}
		if(v.getIdcardnumber()==null||v.getIdcardnumber().trim().equals("")) {
			return "身份证号不能为空";
		}
		if(v.getIdcardnumber().length()>20) {
			return "身份证号限制在20字以内";
		}
		if(v.getPhonenumber()==null||v.getPhonenumber().trim().equals("")) {
			return "手机号不能为空";
		}
		if(v.getPhonenumber().length()>20) {
			return "手机号限制在20位以内";
		}
//		if(v.getSpecialskill()==null||v.getSpecialskill().trim().equals("")) {
//			return "特长不能为空";
//		}
		if(v.getSpecialskill()!=null&&v.getSpecialskill().length()>100) {
			return "特长限制在100字以内";
		}
		return null;
	}

	private Volunteer createVolunteer(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String idcardnumber = request.getParameter("idcardnumber");
		String phonenumber = request.getParameter("phonenumber");
		String specialskill = request.getParameter("specialskill");
		int age = 0;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		}catch (NumberFormatException e) {
		}
		Date registertime = new Date();
		String id = IdGenerator.createId();
		Volunteer v = new Volunteer(id, age, username, password, password2, gender, address, idcardnumber, phonenumber, specialskill, registertime);
		return v;
	}
	
	private Volunteer createVolunteerforupdate(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String idcardnumber = request.getParameter("idcardnumber");
		String phonenumber = request.getParameter("phonenumber");
		String specialskill = request.getParameter("specialskill");
		int age = 0;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		}catch (NumberFormatException e) {
		}
		String id = request.getParameter("id");
		Volunteer v = new Volunteer(id, age, username, password, null, gender, address, idcardnumber, phonenumber, specialskill, null);
		return v;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
