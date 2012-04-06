<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<%@ page import="ua.edu.ChaliyLukyanov.laba3.model.*,ua.edu.ChaliyLukyanov.laba3.model.DAO.*,java.util.List"%>
<body>
	<div id="container">
		<%@ include file="header.jsp"%>
		<div id="main_content">
			<div class="content">
				
				<form action="removecomponent" method="post">
					<br/><b>Component: </b>
					<select name="id_component">
						<%
						ComponentDAO model = (ComponentDAO) request.getAttribute(Application.COMPONENT_DAO);
						List<Component> list = model.getAllComponents();
				
						if (list != null) {
							for (Component comp : list) {
						%>
						<option value="<%=comp.getId() %>" title="id"><%=comp.getTitle() %></option>
						<%
							}
						}
						%>
					</select><br/><br/>
					<p align="center"><button type="submit">Remove</button></p>
				</form>
				<%
					if (request.getParameter("error") != null) {
				%>
				<br />
				<br />
				<h2><%=request.getParameter("error")%></h2>
				<%
					} else if (request.getParameter("ok") != null) {
				%>
				<br />
				<br />
				<h2>Successful!</h2>
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