<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove devices</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*,ua.edu.ChaliyLukyanov.laba3.model.DAO.*,java.util.List"%>
<body>
	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">
				<h2 align = "center">Devices:</h2>
				<form method="post" name="remove_devices" action="removedevices">
				<%
					DeviceDAO devices = (DeviceDAO) request.getAttribute(Application.DEVICE_DAO);
					List<Device> list = devices.getAllDevices();
					if (list != null) {
					for (Device dev : list) {
						%>
						<p style="padding-left:<%=30 * dev.getLevel() %>px;">
						<input type="checkbox" name="<%=dev.getId() %>" value="<%=dev.getId() %>"/> <%=dev.getTitle() %><br/>
						</p>
						
						<%
					}
				} 
				%>
				<p align="center"><button type="submit">Remove</button></p>
				</form>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>
</body>
</html>