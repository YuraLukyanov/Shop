<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="menu">
		<div class="menu_title">Main menu</div>
		<ul>
			<li><a href="${pageContext.request.contextPath}/add_component.jsp"
				class="menu_link">Add component</a></li>
			<li><a href="${pageContext.request.contextPath}/add_device.jsp"
				class="menu_link">Add device</a></li>
			<li><a href="${pageContext.request.contextPath}/showcomponents"
				class="menu_link">Show Components</a></li>
			<li><a href="${pageContext.request.contextPath}/shownextleveldevices?id=0"
				class="menu_link">Show devices</a></li>
			<li><a href="${pageContext.request.contextPath}/remove_component.jsp"
				class="menu_link">Remove component</a></li>
			<li><a href="${pageContext.request.contextPath}/remove_device.jsp"
				class="menu_link">Remove devices</a></li>
		</ul>
	</div>
</body>
</html>