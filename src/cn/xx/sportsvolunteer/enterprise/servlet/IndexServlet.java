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
import cn.xx.sportsvolunteer.dao.GameDao;
import cn.xx.sportsvolunteer.dao.impl.GameDaoImpl;

@WebServlet("/enterprise/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameDao gameDao = new GameDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enterprise en = (Enterprise) request.getSession().getAttribute("enterprise");
		List<Game> gameList = gameDao.getListByEnterprise(0, 1000,en.getId());
		request.getSession().setAttribute("gameList", gameList);
		request.getRequestDispatcher("/jsp/enterprise/index.jsp").forward(request, response);
//		response.sendRedirect(request.getServletContext().getContextPath()+"/jsp/enterprise/index.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
