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
				<form action="test"  multiple name="sel[]" method="get">
					<p>
						<select name = "lol">
							<option value="che">Chebyrashka</option>
							<option value="gena">Krokodil</option>
							<option value = "sh">Shapa</option>
							<option value="lara">Larisa</option>
						</select>
					</p>
					<p>
						<input type="submit" value="Send">
					</p>
				</form>
			</div>

			<%@ include file="menu.jsp"%>

			<div id="clear"></div>

		</div>
		<%@ include file="footer.jsp"%>

	</div>
</body>

</html>