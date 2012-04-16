
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Beauty</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*,ua.edu.ChaliyLukyanov.laba3.model.DAO.*,java.util.*"%>
<%@ page errorPage="error.jsp" %>	

<body>
	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">
			
				<%
					LinkedList<Device> devices = (LinkedList<Device>) request.getAttribute("devices");
					LinkedList<Device> prev_devices = (LinkedList<Device>) request.getAttribute("prev_devices");
					Device prev_device = ((Device) request.getAttribute("prev_device"));
					
					if (devices != null) {
						if (prev_devices != null && prev_device != null) {
				%>
							<br/><a href="shownextleveldevices?id=0">Devices</a>
				<%
							Iterator<Device> iter = prev_devices.descendingIterator();
							while (iter.hasNext()) {
								Device device = iter.next();
				%>
								 <a href="shownextleveldevices?id=<%=device.getId() %>"><%=device.getTitle() %></a>
				<% 
							}
				%>
							<%=prev_device.getTitle() %>
							<h2 align = "center"><%=prev_device.getTitle() %> </h2>
				<%
						} else {
				%>
							<br/> Devices
							<h2 align = "center">Devices:</h2>
				<% 
						}
						Component component = (Component) request.getAttribute("component");
						if (component != null) {
				%>
						<ul>
							<li><b>Title: </b><%=component.getTitle() %></li>
							<li><b>Description: </b><%=component.getDescription() %></li>
							<li><b>Producer: </b><%=component.getProducer() %></li>
							<li><b>Price: </b><%=component.getPrice() %></li>
						</ul>
						<h3 align = "center">Includes:</h3>
				<%
						}
						for (Device dev : devices) {
				%>
							<a href="shownextleveldevices?id=<%=dev.getId() %>"><%=dev.getTitle() %></a> <br/>
				<% 
						}
					}
				%>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>
</body>

</html>
