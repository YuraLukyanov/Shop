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


public class EditComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Component component = model.getComponentByID(id);
			request.setAttribute("component", component);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_component.jsp");
			dispatcher.forward(request, response);			
		} catch (ShopException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			e.printStackTrace();			
		}
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		try {
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String producer = request.getParameter("producer");
			Double price = Double.valueOf(request.getParameter("price"));
			int id = Integer.valueOf(request.getParameter("id_component"));
			model.updateComponent(new Component(id, title, description, producer, 0, null, price));
			response.sendRedirect(request.getContextPath() + "/showcomponent?id=" + id);
		} catch (ShopException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			e.printStackTrace();
		}
	}

}
