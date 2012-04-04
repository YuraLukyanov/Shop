package ua.edu.ChaliyLukyanov.laba3.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.sql.DataSource;


public class Application implements ServletRequestListener {

	public static final String DEVICE_DAO = "shop/Device";
	public static final String COMPONENT_DAO = "shop/Component";
	Connection conn = null;

	public void requestDestroyed(ServletRequestEvent event) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void requestInitialized(ServletRequestEvent event) {
		try {
			Context cont = (Context) new InitialContext()
					.lookup("java:comp/env");
			Locale.setDefault(Locale.ENGLISH);
			DataSource ds = (DataSource) cont.lookup("jdbc/shop");
			conn = ds.getConnection();
			DAOFactory factory = DAOFactory.getDAOFactory(conn);
			DeviceDAO device = factory.getDeviceDAO();
			ComponentDAO component = factory.getComponentDAO();
			event.getServletRequest().setAttribute(DEVICE_DAO, device);
			event.getServletRequest().setAttribute(COMPONENT_DAO, component);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
