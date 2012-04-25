
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Devices</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*,ua.edu.ChaliyLukyanov.laba3.model.DAO.*,java.util.List"%>
<%@ page errorPage="error.jsp" %>	

<body>
	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">
				<c:choose>
					<c:when test="${prev_devices != null && this_device != null }">
						<br/><a href="shownextleveldevices?id=0">Devices > </a>
						<c:forEach items="${prev_devices}" var="dev">
							<a href="shownextleveldevices?id=${dev.id}">${dev.title} > </a>
						</c:forEach>
						${this_device.title}
						<h2 align="center">${this_device.title}</h2>
						<c:if test="${component != null }">
							<ul>
								<li><b>Title: </b>${component.title}</li>
								<li><b>Description: </b>${component.description}</li>
								<li><b>Producer: </b>${component.producer}</li>
								<li><b>Price: </b>${component.price}</li>
							</ul>
						</c:if>
						<c:if test="${!empty devices}">
							<h3 align="center">Include:</h3>
						</c:if>
					</c:when>
					<c:otherwise>
						<br/> Devices
						<h2 align="center">Devices:</h2>
					</c:otherwise>
				</c:choose>
				<c:forEach items="${devices}" var="dev" >
					<a href="shownextleveldevices?id=${dev.id}">${dev.title}</a> <br/>
				</c:forEach>

			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>
</body>

</html>
