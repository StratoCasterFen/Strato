<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ARM Police station</title>

<script type='text/javascript'>
	function validate() {

		var x = document.forms["loginform"]["j_username"].value;
		var y = document.forms["loginform"]["j_password"].value;
		alert(x);

		if (x.length == 0) {
			document.getElementById('usernamef').innerHTML = '*данное поле обязательно для заполнения';
			return false;
		}

		if (y.length == 0) {
			document.getElementById('passwordf').innerHTML = '*данное поле обязательно для заполнения';
			return false;
		}

		//   at=y.indexOf("@");
		//   dot=y.indexOf(".");

		/*  if (at<1 || dot <1){
		    document.getElementById('emailf').innerHTML='*email введен не верно';
		    return false;
		 } */
	}
</script>

</head>
	<body>
		<h>Application Log in:</h>
		<hr>		
<!-- 		<form name="loginform" id="loginform" action="j_security_check" method="post"> --> 
 		<form action="events" method="post" onsubmit="return validate()"> 
		    Input for username:<br>
		    <input name="j_username" type="text" id="j_username"><br>
		    Input for password:<br>
		    <input name="j_password" type="password" id="j_password"><br>
		    <input type="submit" value="Authorization">
		    <input name="command" type="hidden" value="SIGNIN">
		</form>

		<c:out value="${errorAuth}"/><br>
	</body>
</html>