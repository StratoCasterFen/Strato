<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ARM Police station</title>
	</head>
	<body>
		Enter login and password:
		<FORM ACTION="events" method=”POST”>
			<INPUT TYPE=text NAME=user VALUE="Admin">
			<INPUT TYPE=password NAME=pass>
			<INPUT TYPE="submit" value="SignIn" />
			<INPUT name="command" type="hidden" value="SIGNIN">
		</FORM>	
	</body>
</html>