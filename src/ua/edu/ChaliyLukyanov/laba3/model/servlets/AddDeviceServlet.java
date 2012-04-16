package ua.edu.ChaliyLukyanov.laba3.model.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.Device;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.DeviceDAO;


public class AddDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeviceDAO model = (DeviceDAO) request.getAttribute(Application.DEVICE_DAO);
		try {
			model.addDevice(new Device(0, Integer.parseInt(request.getParameter("id_prev_device")), 
										Integer.parseInt(request.getParameter("id_component")),
										request.getParameter("title")));
			response.sendRedirect(request.getContextPath() + "/add_device.jsp?ok");
			
		} catch (ShopException e) {
			Application.sendErrorRedirect(request,response,"/servlet_error.jsp",e.getMessage());
		} catch (NumberFormatException e) {
			Application.sendErrorRedirect(request,response,"/servlet_error.jsp",e.getMessage());
		}
	}

}
