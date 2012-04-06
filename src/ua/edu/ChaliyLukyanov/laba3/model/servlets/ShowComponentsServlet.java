package ua.edu.ChaliyLukyanov.laba3.model.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.Component;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.ComponentDAO;

/**
 * Servlet implementation class ShowComponentsServlet
 */
public class ShowComponentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		List<Component> list = null;
		try {
			list = model.getAllComponents();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (list != null) {
			request.setAttribute("components", list);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/show_components.jsp");
			dispatcher.forward(request, response);
		}
	}
}
