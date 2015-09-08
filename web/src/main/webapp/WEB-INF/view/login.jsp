<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ARM Police station</title>
	</head>
	<body>
		<h>Application Log in:</h>
		<hr>		
<!-- 		<form action="j_security_check" method="post"> -->
		<form action="events" method="post">
		    Input for username:<br>
		    <input name="username" type="text"><br>
		    Input for password:<br>
		    <input name="password" type="password"><br>
		    <input type="submit" value="Authorization">
		    <input name="command" type="hidden" value="SIGNIN">
		</form>
	
	<script>

		function showError(container, errorMessage) {
			container.className = 'error';
			var msgElem = document.createElement('span');
			msgElem.className = "error-message";
			msgElem.innerHTML = errorMessage;
			container.appendChild(msgElem);
		}

		function resetError(container) {
			container.className = '';
			if (container.lastChild.className == "error-message") {
				container.removeChild(container.lastChild);
			}
		}

		function validate(form) {
			var elems = form.elements;

			resetError(elems.username.parentNode);
			if (!elems.username.value) {
				showError(elems.username.parentNode, 'Input Name');
			}

			resetError(elems.password.parentNode);
			if (!elems.password.value) {
				showError(elems.password.parentNode, ' Input password');
			} 

		}
	</script>
		
		
		
		<c:out value="${errorAuth}"/><br>
	</body>
</html>