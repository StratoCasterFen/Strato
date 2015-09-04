<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ARM Police station</title>
	</head>
	<body>
		<p>Application Log in:</p>
		<hr>		
<!-- 		<form action="j_security_check" method="post"> -->
		<form action="events" method="post">
		    Input for username:<br>
		    <input name="j_username" type="text"><br>
		    Input for password:<br>
		    <input name="j_password" type="password"><br>
		    <input type="submit" value="Authorization!">
		    <input name="command" type="hidden" value="SIGNIN">
		</form>
		<c:out value="${errorAuth}"/><br>
	</body>
</html>