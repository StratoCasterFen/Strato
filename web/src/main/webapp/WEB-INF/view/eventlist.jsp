<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
	<title>Criminal events</title>
</head>
<body>
	<h1>Event list</h1>
	<html:errors />
	<table>
		<thead>
			<tr><c:forEach var="column"
				items="Event name, Description, date">
			<th><c:out value="${column}"/></th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${events}">
			<tr><td><c:out value="${eventname}"/></td>
			   <!--  <td><c:out value="${event.description}"/></td>
				<td><c:out value="${event.date}"/></td>
				<td><html:form action="orderItem">
				<input type="hidden" name="id" value="<c:out value=’${event.id}’/>"/>
				-->
				<html:text property="quantity"/>
				<html:submit />
				</html:form></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><html:link page="/addevent.do">add</html:link>
	</p>	
</body>
</html>