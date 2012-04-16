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
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*,ua.edu.ChaliyLukyanov.laba3.model.DAO.*,java.util.List"%>
<%@ page errorPage="error.jsp" %>
	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">
				<%
					int id = Integer.parseInt(request.getParameter("id"));
					ComponentDAO compomentDAO = (ComponentDAO)request.getAttribute(Application.COMPONENT_DAO);
					Component component = compomentDAO.getComponentByID(id);
					if (component != null) {
				%>
				<ul>
					<li><b>Title: </b><%=component.getTitle() %></li>
					<li><b>Description: </b><%=component.getDescription() %></li>
					<li><b>Producer: </b><%=component.getProducer() %></li>
					<li><b>Price: </b><%=component.getPrice() %></li>
				</ul>
				<% 
					}
				%>
				<a href="<%=request.getContextPath()%>/edit_component.jsp?id=<%=component.getId() %>">edit</a>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>
</html>