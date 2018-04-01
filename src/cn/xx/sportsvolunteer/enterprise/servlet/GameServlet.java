package cn.xx.sportsvolunteer.enterprise.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xx.sportsvolunteer.beans.Enterprise;
import cn.xx.sportsvolunteer.beans.Game;
import cn.xx.sportsvolunteer.dao.GameDao;
import cn.xx.sportsvolunteer.dao.impl.GameDaoImpl;
import cn.xx.sportsvolunteer.utils.IdGenerator;

@WebServlet("/enterprise/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameDao gameDao = new GameDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//检查管理员登陆状态
		Enterprise enterprise = (Enterprise) request.getSession().getAttribute("enterprise");
		if(enterprise==null) {
			request.setAttribute("message", "您未登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		String method = request.getParameter("method");
		if (method == null || method.trim().equals("")) {
			return;
		}
		switch (method) {
		case "addgame":
			addgame(request,response);
			break;
		case "deletegame":
			deletegame(request,response);
			break;
		case "index":
			index(request,response);
			break;
		default:
			break;
		}
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enterprise en = (Enterprise) request.getSession().getAttribute("enterprise");
		List<Game> gameList = gameDao.getListByEnterprise(0, 1000,en.getId());
		request.getSession().setAttribute("gameList", gameList);
//		request.getRequestDispatcher("/jsp/enterprise/index.jsp").forward(request, response);
		response.sendRedirect(request.getServletContext().getContextPath()+"/jsp/enterprise/index.jsp");
		return;
	}

	private void deletegame(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String id = request.getParameter("id");
			gameDao.delete(id);
			index(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "删除失败");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
	}

	private void addgame(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			Game game = null;
			game = createGame(request);
			gameDao.add(game);
			index(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "发布失败");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
	}

	private Game createGame(HttpServletRequest request) {
		Enterprise en = (Enterprise) request.getSession().getAttribute("enterprise");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String jobdescription = request.getParameter("jobdescription");
		String begintime_str = request.getParameter("begintime");
		String endtime_str = request.getParameter("endtime");
		String address = request.getParameter("address");
		String salary_str = request.getParameter("salary");
		String personcount_str = request.getParameter("personcount");
		//
		String id = IdGenerator.createId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		Date begintime = null;
		Date endtime = null;
		try {
			begintime = sdf.parse(begintime_str);
			endtime = sdf.parse(endtime_str);
		} catch (ParseException e) {
			sdf = new SimpleDateFormat("yyyy-mm-dd");
			try {
				begintime = sdf.parse(begintime_str);
				endtime = sdf.parse(endtime_str);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		double salary = Double.parseDouble(salary_str);
		int enterpriseid = en.getId();
		int personcount = Integer.parseInt(personcount_str);
		Game game = new Game(id, name, description, jobdescription, begintime, endtime, address, salary, enterpriseid, personcount);
		return game;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
