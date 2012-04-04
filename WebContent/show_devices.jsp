<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Beauty</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*, java.util.List"%>

<body>

	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">
				<h2 align = "center">Devices:</h2>
				<%
					List<Device> list = (List<Device>) request.getAttribute("devices");
					if (list != null) {
				%>
				<table border="1" cellpadding="10" align="center">
					<tr>
						<td>ID</td>
						<td>ID Component</td>
						<td>ID Parent</td>
						<td>Title</td>
					</tr>
					<%
						for (Device w : list) {
					%>
					<tr>
						<td><%=w.getId()%></td>
						<td><%=w.getIdComponent() %></td>
						<td><%=w.getIdPrev() %></td>
						<td><a href="showcomponent?id=<%=w.getIdComponent() %>"><%=w.getTitle()%></a></td>
					</tr>
					<%
						}
					}
					%>
				</table>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>

</html>
