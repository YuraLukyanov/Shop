package ua.edu.ChaliyLukyanov.laba3.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDevicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DeviceDAO model = (DeviceDAO) request.getAttribute(Application.DEVICE_DAO);
		List<Device> list = null;
		try {
			list = model.getAllDevices();
			System.out.println("get ok");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (list != null) {
			request.setAttribute("devices", list);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/show_devices.jsp");
			dispatcher.forward(request, response);
		}
	}
}
