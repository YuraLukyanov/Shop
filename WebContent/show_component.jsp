<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Component</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*,ua.edu.ChaliyLukyanov.laba3.model.DAO.*,java.util.List"%>
<%@ page errorPage="error.jsp" %>
	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">
				<c:if test="${!empty component}">
				<ul>
					<li><b>Title: </b>${component.title}</li>
					<li><b>Description: </b>${component.description}</li>
					<li><b>Producer: </b>${component.producer}</li>
					<li><b>Price: </b>${component.price}</li>
				</ul>
				<a href="${pageContext.request.contextPath}/editcomponent?id=${component.id}">edit</a>
				</c:if>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>
</html>