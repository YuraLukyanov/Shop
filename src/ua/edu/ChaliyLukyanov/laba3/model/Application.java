package ua.edu.ChaliyLukyanov.laba3.model;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import ua.edu.ChaliyLukyanov.laba3.model.DAO.*;

public class Application implements ServletRequestListener {

	public static final String DEVICE_DAO = "shop/Device";
	public static final String COMPONENT_DAO = "shop/Component";

	public void requestDestroyed(ServletRequestEvent event) {

	}

	public void requestInitialized(ServletRequestEvent event) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DeviceDAO device = factory.getDeviceDAO();
		ComponentDAO component = factory.getComponentDAO();
		event.getServletRequest().setAttribute(DEVICE_DAO, device);
		event.getServletRequest().setAttribute(COMPONENT_DAO, component);
	}
}
