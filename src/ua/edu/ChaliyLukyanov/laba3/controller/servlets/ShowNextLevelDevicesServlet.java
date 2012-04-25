package ua.edu.ChaliyLukyanov.laba3.controller.servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.edu.ChaliyLukyanov.laba3.model.Application;
import ua.edu.ChaliyLukyanov.laba3.model.Component;
import ua.edu.ChaliyLukyanov.laba3.model.Device;
import ua.edu.ChaliyLukyanov.laba3.model.NoSuchDeviceException;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.ComponentDAO;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.DeviceDAO;

public class ShowNextLevelDevicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("Shoplogger");

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeviceDAO deviceModel = (DeviceDAO) request.getAttribute(Application.DEVICE_DAO);
		ComponentDAO componentModel = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			if (id != 0) {
				List<Device> devices = deviceModel.getNextLevelsDeviceByID(id);
				request.setAttribute("devices", devices);
				
				LinkedList<Device> prev_devices = (LinkedList<Device>) deviceModel.getPrevLevelsDeviceByID(id);
				request.setAttribute("prev_devices", prev_devices);
				
				request.setAttribute("this_device", deviceModel.getDeviceByID(id));
				
				Component component = componentModel.getComponentByID(deviceModel.getDeviceByID(Integer.parseInt(request.getParameter("id"))).getIdComponent());
				request.setAttribute("component", component);
			} else {
				List<Device> devices = deviceModel.getFirstLevelsDeviceByID(id);
				request.setAttribute("devices", devices);
				request.setAttribute("prev_devices", null);
				request.setAttribute("this_device", null);
				request.setAttribute("component", null);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/show_devices.jsp");
			dispatcher.forward(request, response);
		}  catch (NumberFormatException e) {
			logger.error(e);
			throw new NumberFormatException("Incorrect value " + e.getMessage());
		}  catch (ShopException e){
			logger.error(e);
			throw new ShopException(e.getMessage());
		}  catch (NoSuchDeviceException e){
			logger.error(e);
			throw new NoSuchDeviceException(e.getMessage());
		}
	}
}
