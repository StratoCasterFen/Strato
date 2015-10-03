<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>New User page</title>
</head>
<body>
<h1>New User page</h1>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/create.html" >
<table>
<tbody>
<tr>
<td>User name:</td>
<td><form:input path="userName" /></td>
<td><form:errors path="userName" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Pasword:</td>
<td><form:input path="password" /></td>
<td><form:errors path="password" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input type="submit" value="Create" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>