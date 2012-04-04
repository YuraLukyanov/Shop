package ua.edu.ChaliyLukyanov.laba3.model;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddComponentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		
		try {
			
			String title = request.getParameter("title");
			String desc = request.getParameter("desc");
			String producer = request.getParameter("producer");
			String img = request.getParameter("img");

			double price = Double.parseDouble(request.getParameter("price"));
			double w = Double.parseDouble(request.getParameter("weight"));
			
			model.addComponent(new Component(0, title, desc, producer, w, img,price));
			
			response.sendRedirect(request.getContextPath()
					+ "/add_component.jsp?ok");
		} catch (SQLException e) {
			response.sendRedirect(request.getContextPath()
					+ "/add_component.jsp?error=SQL ERROR");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()
					+ "/add_component.jsp?error=NumberFormat");
		}

	}

}