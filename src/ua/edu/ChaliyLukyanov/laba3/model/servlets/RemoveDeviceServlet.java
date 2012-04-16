package ua.edu.ChaliyLukyanov.laba3.model.servlets;

import java.io.IOException;

import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.*;


public class RemoveDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeviceDAO model = (DeviceDAO) request.getAttribute(Application.DEVICE_DAO);
		try {
			Enumeration<String> names = (Enumeration<String>)request.getParameterNames();
			while(names.hasMoreElements()) {
				model.removeDevice(Integer.parseInt(names.nextElement()));
			}
			response.sendRedirect(request.getContextPath() + "/remove_device.jsp?ok");
		} catch (ShopException e) {
			Application.sendErrorRedirect(request,response,"/servlet_error.jsp",e.getMessage());
		} catch (NumberFormatException e) {
			Application.sendErrorRedirect(request,response,"/servlet_error.jsp",e.getMessage());
		}
	}
}
