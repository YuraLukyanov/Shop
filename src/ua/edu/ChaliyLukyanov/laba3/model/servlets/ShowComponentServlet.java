package ua.edu.ChaliyLukyanov.laba3.model.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.Component;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.ComponentDAO;



public class ShowComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		try {
			Component component = model.getComponentByID(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("component", component);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/show_component.jsp");
			dispatcher.forward(request, response);
		} catch (ShopException e) {
			throw new RuntimeException(e);
		}
	}

}
