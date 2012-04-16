package ua.edu.ChaliyLukyanov.laba3.model.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.Component;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.ComponentDAO;


public class ShowComponentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		try {
			List<Component> components = model.getAllComponents();
			List<String> producers = model.getDistinctProducers();
			request.setAttribute("components", components);
			request.setAttribute("producers", producers);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/show_components.jsp");
			dispatcher.forward(request, response);
		} catch (ShopException e) {
			Application.sendErrorRedirect(request,response,"/servlet_error.jsp",e.getMessage());
		} catch (NumberFormatException e) {
			Application.sendErrorRedirect(request,response,"/servlet_error.jsp",e.getMessage());
		}
	}
}
