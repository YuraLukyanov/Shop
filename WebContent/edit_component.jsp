<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Beauty</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*,ua.edu.ChaliyLukyanov.laba3.model.DAO.*,java.util.List"%>
<%@ page errorPage="error.jsp"%>

<body>

	<div id="container">

		<%@ include file="header.jsp"%>

		<div id="main_content">

			<div class="content">

				<h2 align="center">Component:</h2>
				<%
					int id = Integer.parseInt(request.getParameter("id"));
					ComponentDAO compomentDAO = (ComponentDAO)request.getAttribute(Application.COMPONENT_DAO);
					Component component = compomentDAO.getComponentByID(id);
					if (component != null) {
				%>
					<form method="post" action="editcomponent">
						<ul>
							<li><b>Title: </b><br/><textarea cols="50" rows="2" name="title"> <%=component.getTitle() %></textarea></li>
							<li><b>Description: </b><br/><textarea cols="50" rows="5" name="description"><%=component.getDescription() %></textarea></li>
							<li><b>Producer: </b><br/><textarea cols="50" rows="2" name="producer"><%=component.getProducer() %></textarea></li>
							<li><b>Price: </b><br/><textarea cols="50" rows="1" name="price"><%=component.getPrice() %></textarea></li>
						</ul>
						<p align="center"><button type="submit" value="<%=component.getId() %>" name="id_component">save</button></p>
					</form>
				<% 
					} 
				%>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>

</html>
