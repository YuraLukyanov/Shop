package ua.edu.ChaliyLukyanov.laba3.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.Component;
import ua.edu.ChaliyLukyanov.laba3.model.NoSuchComponentException;
import ua.edu.ChaliyLukyanov.laba3.model.NoSuchDeviceException;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.ComponentDAO;

public class AddComponentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("Shoplogger");

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String producer = request.getParameter("producer");
		String img = request.getParameter("img");
		String price = request.getParameter("price");
		String weight = request.getParameter("weight");

		try {
			
			double pr = 0.0;
			double w = 0.0;
			if (!"".equals(price))
				pr = Double.parseDouble(price);

			if (!"".equals(weight))
				w = Double.parseDouble(weight);
			
			if ("".equals(title))
				throw new IllegalArgumentException("Title should be!");

			if ("".equals(desc))
				throw new IllegalArgumentException("Description should be!");
			
			if ("".equals(producer))
				throw new IllegalArgumentException("Producer should be!");

			if (pr < 0 || w < 0) {
				throw new NumberFormatException("Price and weight should be > 0");
			}

			model.addComponent(new Component(0, title, desc, producer, w, img,	pr));
			int id = model.getIdLastComponent();
			logger.info("Component adds");
			response.sendRedirect(request.getContextPath() + "/showcomponent?id=" + id);
		} catch (ShopException e) {
			logger.error(e);
			response.sendRedirect(request.getContextPath()
					+ "/add_component.jsp?title=" + title + "&desc=" + desc
					+ "&prod=" + producer + "&img=" + img + "&pr=" + price
					+ "&w=" + weight + "&error=" + e.getMessage());
		} catch (NumberFormatException e) {
			logger.error(e);
			response.sendRedirect(request.getContextPath()
					+ "/add_component.jsp?title=" + title + "&desc=" + desc
					+ "&prod=" + producer + "&img=" + img + "&pr=" + price
					+ "&w=" + weight + "&error=" + e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error(e);
			response.sendRedirect(request.getContextPath()
					+ "/add_component.jsp?title=" + title + "&desc=" + desc
					+ "&prod=" + producer + "&img=" + img + "&pr=" + price
					+ "&w=" + weight + "&error=" + e.getMessage());
		} catch (NoSuchComponentException e){
			logger.error(e);
			throw new NoSuchDeviceException(e.getMessage());
		} 
	}

}
