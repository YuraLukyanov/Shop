package ua.edu.ChaliyLukyanov.laba3.controller.servlets;

import java.io.IOException;

import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.*;


public class RemoveDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("Shoplogger");

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeviceDAO model = (DeviceDAO) request.getAttribute(Application.DEVICE_DAO);
		try {
			Enumeration<String> names = (Enumeration<String>)request.getParameterNames();
			while(names.hasMoreElements()) {
				int id = Integer.parseInt(names.nextElement());
				model.removeDevice(id);
				logger.info("Device " + id + " removes");
			}
			response.sendRedirect(request.getContextPath() + "/remove_device.jsp");
		} catch (ShopException e) {
			logger.error(e);
			throw new ShopException(e.getMessage());
		} catch (NumberFormatException e) {
			logger.error(e);
			throw new NumberFormatException(e.getMessage());
		}
	}
}
