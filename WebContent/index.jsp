<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<h4>This is my test web site. I used simple Oracle database and
					some simple web pages.</h4>
				<h4>Use menu and look what I have done.</h4>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>
		<%@ include file="footer.jsp"%>

	</div>
</body>

</html>