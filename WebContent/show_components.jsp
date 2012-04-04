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
				<h2 align = "center">Components:</h2>
				<%
					List<Component> list = (List<Component>) request.getAttribute("components");
					if (list != null) {
				%>
				<table border="1" cellpadding="10" align="center">
					<thead>
						<tr>
							<td>Title</td>
							<td>Description</td>
							<td>Producer</td>
							<td>Weight</td>
							<td>Price</td>
						</tr>
					</thead>
					<tbody>
						<%
							for (Component comp : list) {
						%>
						<tr>
							<td><%=comp.getTitle() %></td>
							<td><%=comp.getDescription() %></td>
							<td><%=comp.getProducer()%></td>
							<td><%=comp.getWeight()%></td>
							<td><%=comp.getPrice()%></td>
						</tr>
						<%
							}
						}
						%>
					</tbody>
				</table>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>

</html>
