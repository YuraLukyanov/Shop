package ua.edu.ChaliyLukyanov.laba3.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.ComponentDAO;
import ua.edu.ChaliyLukyanov.laba3.model.Component;

public class ShowComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ComponentDAO compomentDAO = (ComponentDAO)request.getAttribute(Application.COMPONENT_DAO);
		try {
			Component component = compomentDAO.getComponentByID(id);
			request.setAttribute("component", component);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/show_component.jsp");
			dispatcher.forward(request, response);			
		} catch (ShopException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			e.printStackTrace();
		}
	}

}
