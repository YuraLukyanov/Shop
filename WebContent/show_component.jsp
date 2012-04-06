<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Component</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*" %>
	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">
				<%
					Component component = (Component) request.getAttribute("component");
					if (component != null) {
				%>
				<ul>
					<li><b>Title: </b><%=component.getTitle() %></li>
					<li><b>Description: </b><%=component.getDescription() %></li>
					<li><b>Producer: </b><%=component.getProducer() %></li>
					<li><b>Price: </b><%=component.getPrice() %></li>
				</ul>
<!--  				<table border="1" cellpadding="10" align="center">
					<tr>
						<td>ID</td>
						<td>Producer</td>
						<td>Title</td>
						<td>Price</td>
					</tr>
					<tr>
						<td><%=component.getId()%></td>
						<td><%=component.getProducer() %></td>
						<td><%=component.getTitle() %></td>
						<td><%=component.getPrice() %></td>
					</tr>
					<%
					}
					%>
				</table> -->
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>
</html>