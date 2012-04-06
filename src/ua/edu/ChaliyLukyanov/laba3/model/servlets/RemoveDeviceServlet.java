package ua.edu.ChaliyLukyanov.laba3.model.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.*;

/**
 * Servlet implementation class RemoveDeviceServlet
 */
public class RemoveDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveDeviceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeviceDAO model = (DeviceDAO) request.getAttribute(Application.DEVICE_DAO);
		try {
			Enumeration<String> names = (Enumeration<String>)request.getParameterNames();
			while(names.hasMoreElements()) {
				model.removeDevice(Integer.parseInt(names.nextElement()));
			}
			response.sendRedirect(request.getContextPath() + "/remove_device.jsp?ok");
		} catch (SQLException e) {
			response.sendRedirect(request.getContextPath()+ "/remove_device.jsp?error=SQL ERROR");
		}
	}

}
