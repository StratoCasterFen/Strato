<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ARM Police station</title>



</head>
	<body>
		<h>Application Log in:</h>
		<hr>		
		<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/signin.html">
		    Input for username:<br>
		    <input name="j_username" type="text" id="j_username"><br>
		    Input for password:<br>
		    <input name="j_password" type="password" id="j_password"><br>
		    <input type="submit" value="Authorization">
		    <input name="command" type="hidden" value="home">
		</form:form>
		<a href="${pageContext.request.contextPath}/user/create.html">Create a new user</a><br/>
		<c:out value="${errorAuth}"/><br>
	</body>
</html>

<%-- <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
	<h2>Create a free Spitter account</h2>
	<sf:form method="POST" modelAttribute="spitter">
		<!-- Связать форму -->
		<fieldset>
			<!-- с атрибутом модели -->
			<table cellspacing="0">
				<tr>
					<th><label for="user_full_name">Full name:</label></th>
					<td><sf:input path="fullName" size="15" id="user_full_name" /></td>
				</tr>
				<tr>
					<th><label for="user_screen_name">Username:</label></th>
					<td><sf:input path="username" size="15" maxlength="15"
							id="user_screen_name" /> <!-- Поле имени пользователя --> 
							<small
						id="username_msg">No spaces, please.</small></td>
				</tr>
				<tr>
					<th><label for="user_password">Password:</label></th>
					<td><sf:password path="password" size="30" showPassword="true"
							id="user_password" /> <!-- Поле пароля --> <small>6
							characters or more (be tricky!)</small></td>
				</tr>
				<tr>
					<th><label for="user_email">Email Address:</label></th>
					<td><sf:input path="email" size="30" id="user_email" /> <!-- Поле электронной почты -->
						<small>In case you forget something</small></td>
				</tr>
				<tr>
					<th></th>
					<td><sf:checkbox path="updateByEmail"
							id="user_send_email_newsletter" /> <!-- Признак необходимости -->
						353 <label for="user_send_email_newsletter"> <!-- присылать уведомления -->
							Send me email updates!
					</label> <!-- об изменениях --></td>
				</tr>
			</table>
		</fieldset>
	</sf:form>
</div> --%>
