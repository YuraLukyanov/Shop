<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Beauty</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">

				<form name="input" action="addcomponent" method="post">
					<table width="100%" cellspacing="0" cellpadding="4">
						<tr>
							<td align="right" width="100">Title</td>
							<td><input type="text" name="title" maxlength="50" size="50" value = "${param.title}"></td>
						</tr>
						<tr>
							<td align="right">Description</td>
							<td><input type="text" name="desc" maxlength="1000"	size="50" value = "${param.desc}"></td>
						</tr>
						<tr>
							<td align="right">Producer</td>
							<td><input type="text" name="producer" maxlength="50" size="50" value = "${param.prod}"></td>
						</tr>
						<tr>
							<td align="right">Img(link)</td>
							<td><input type="text" name="img" maxlength="50" size="50" value = "${param.img}"></td>
						</tr>
						<tr>
							<td align="right">Price</td>
							<td><input type="text" name="price" maxlength="50" size="10" value = "${param.pr}"></td>
						</tr>
						<tr>
							<td align="right">Weight</td>
							<td><input type="text" name="weight" maxlength="10"	size="10" value = "${param.w}"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Add component"></td>
						</tr>
					</table>
				</form>
				<c:if test="${!empty param.error}">
					<h2>${param.error}</h2>
				</c:if>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>

</html>


















