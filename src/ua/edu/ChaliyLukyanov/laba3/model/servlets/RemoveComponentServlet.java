package ua.edu.ChaliyLukyanov.laba3.model.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.ComponentDAO;


public class RemoveComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		try {
			model.removeComponent(Integer.parseInt(request.getParameter("id_component")));
			response.sendRedirect(request.getContextPath() + "/remove_component.jsp?ok");
		} catch (ShopException e) {
			response.sendRedirect(request.getContextPath()+ "/remove_component.jsp?error=" + e.getMessage());
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()
					+ "/remove_component.jsp?error=NumberFormat");
		}
	}

}
