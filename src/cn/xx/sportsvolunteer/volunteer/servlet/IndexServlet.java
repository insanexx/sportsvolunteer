package cn.xx.sportsvolunteer.volunteer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xx.sportsvolunteer.beans.Game;
import cn.xx.sportsvolunteer.beans.Volunteer;
import cn.xx.sportsvolunteer.dao.GameDao;
import cn.xx.sportsvolunteer.dao.impl.GameDaoImpl;

@WebServlet("/volunteer/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameDao gameDao = new GameDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Volunteer v = (Volunteer) request.getSession().getAttribute("volunteer");
		if(v==null) {
			request.setAttribute("message", "您未登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		String volunteerid = v.getId();
		List<Game> gameList = gameDao.getList(0, 1000,volunteerid);
		request.getSession().setAttribute("gameList", gameList);
		request.getRequestDispatcher("/jsp/volunteer/index.jsp").forward(request, response);
//		response.sendRedirect(request.getServletContext().getContextPath()+"/jsp/volunteer/index.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
