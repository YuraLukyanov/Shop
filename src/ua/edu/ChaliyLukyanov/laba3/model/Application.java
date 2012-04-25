package ua.edu.ChaliyLukyanov.laba3.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

import ua.edu.ChaliyLukyanov.laba3.model.DAO.ComponentDAO;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.DAOFactory;
import ua.edu.ChaliyLukyanov.laba3.model.DAO.DeviceDAO;

public class Application implements ServletRequestListener, ServletContextListener {

	public static final String DEVICE_DAO = "shop_devices";
	public static final String COMPONENT_DAO = "shop_components";

	public void requestDestroyed(ServletRequestEvent event) {

	}

	public void requestInitialized(ServletRequestEvent event) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DeviceDAO device = factory.getDeviceDAO();
		ComponentDAO component = factory.getComponentDAO();
		event.getServletRequest().setAttribute(DEVICE_DAO, device);
		event.getServletRequest().setAttribute(COMPONENT_DAO, component);
	}

	
	public static void sendErrorRedirect(HttpServletRequest request, HttpServletResponse response, String errorPageURL, String error)
			throws ServletException, IOException {
		request.setAttribute("exception", error);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(errorPageURL);
		dispatcher.forward(request, response);
	}
	
	public void contextInitialized(ServletContextEvent e) 
	 { 
	     ServletContext ctx = e.getServletContext();
	    
	  String prefix =  ctx.getRealPath("/");     
	  String file = "WEB-INF"+System.getProperty("file.separator")+"classes"+System.getProperty("file.separator")+"log4j.properties";
	           
	     if(file != null) {
	       PropertyConfigurator.configure(prefix+file);
	       System.out.println("Log4J Logging started for application: " + prefix+file);
	     }
	     else
	     {
	      System.out.println("Log4J Is not configured for application Application: " + prefix+file);
	     } 
	        
	      
	 }
	 
	 public void contextDestroyed(ServletContextEvent event) 
	 {
	   
	 }
}
