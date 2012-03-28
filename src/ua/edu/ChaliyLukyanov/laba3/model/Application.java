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

	public static final String MODEL = "shop/MODEL";
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
			System.out.println(conn == null);
			conn = ds.getConnection();
			Shop model = new ShopJDBC(conn);
			event.getServletRequest().setAttribute(MODEL, model);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
