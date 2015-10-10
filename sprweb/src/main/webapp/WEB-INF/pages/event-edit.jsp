<%@ include file="layout/header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit event page</title>
</head>
<body>
<h1>Edit event page</h1>
<form:form method="POST" commandName="event" action="${pageContext.request.contextPath}/event/edit/${event.id}.html" >
<table>
<tbody>
<tr>
<td>Event name:</td>
<td><form:input path="eventName" /></td>
<td><form:errors path="eventName" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Description:</td>
<td><form:input path="description" /></td>
<td><form:errors path="description" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input type="submit" value="Create" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/events">main page</a>
</body>
</html>