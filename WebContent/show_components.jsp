<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Components</title>
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
				<form action="filtercomponent" method="get">
					<table>
						<tr>
							<td><h4>Sort</h4></td>
							<td><h4>Producer</h4></td>
							<td><h4>Price</h4></td>
						</tr>
						<tr>
							<td>
								<select name="sortBy">
									<option value="none"></option>
									<option value="title">by title</option>
									<option value="producer">by producer</option>
									<option value="price">by price</option>
								</select>
							</td>
							<td>
								<select name="producer">
										<option value="none" title="producer"></option>
										<c:forEach items="${producers}" var="producer">
											<option value="${producer}" title="producer">${producer}</option>
										</c:forEach>
								</select>
							</td>
							<td>
								<select name="priceOrder">
										<option value="none" title="price"></option>
										<option value=">=">&gt=</option>
										<option value="<=">&lt=</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<select name="sortOrder">
									<option value="asc">Asc</option>
									<option value="desc">Desc</option>
								</select>
							</td>
							<td></td>
							<td><input type="text" name="priceValue" maxlength="10" size="4"></td>
						</tr>
					</table>
					<p align="center"><button type="submit">Filter!</button></p>
				</form>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>

</html>
