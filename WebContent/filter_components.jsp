<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filter</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*,ua.edu.ChaliyLukyanov.laba3.model.DAO.*,java.util.List"%>
<%@ page errorPage="error.jsp"%>

<body>

	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">

				<h2 align="center">Components:</h2>
				<c:if test="${components != null}">
					<table border="1" cellpadding="10" align="center">
						<thead>
							<tr>
								<td>Title</td>
								<td>Producer</td>
								<td>Weight</td>
								<td>Price</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${components}" var="component">
								<tr>
									<td><a href="showcomponent?id=${component.id}">${component.title}</a></td>
									<td>${component.producer}</td>
									<td>${component.weight}</td>
									<td>${component.price}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<br/><br/>
				<h2 align = "center">Filtered by:</h2>
				<h3>Sorted by: <c:out value="${sortBy}" />, order:  <c:out value="${sortOrder}" /></h3>
				<h3>Show only: <c:out value="${show}" /></h3>
				<h3>Price filter: <c:out value="${sign}" /> <c:out value="${price}" /></h3>
				<h2 align = "center"><a href="${pageContext.request.contextPath}/showcomponents" class="menu_link">Back</a></h2>
			</div>
			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>

</html>
