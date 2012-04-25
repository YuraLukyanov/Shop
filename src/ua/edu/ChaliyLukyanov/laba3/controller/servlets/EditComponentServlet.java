package ua.edu.ChaliyLukyanov.laba3.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.Component;
import ua.edu.ChaliyLukyanov.laba3.model.NoSuchComponentException;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.ComponentDAO;


public class EditComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("Shoplogger");
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Component component = model.getComponentByID(id);
			request.setAttribute("component", component);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/edit_component.jsp");
			dispatcher.forward(request, response);			
		} catch (ShopException e) {
			logger.error(e);
			throw new ShopException(e.getMessage());
		} catch (NoSuchComponentException e){
			logger.error(e);
			throw new NoSuchComponentException(e.getMessage());
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
			logger.info("Component " + id + " updates");
			response.sendRedirect(request.getContextPath() + "/showcomponent?id=" + id);
		} catch (ShopException e) {
			logger.error(e);
			throw new ShopException(e.getMessage());
		}
	}

}
