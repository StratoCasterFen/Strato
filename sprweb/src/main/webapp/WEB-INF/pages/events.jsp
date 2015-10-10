<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page session="false"%>
<%@ include file="layout/header.jsp"%>
<!doctype html>
<html lang="ru">
<head>
<meta charset="utf-8">
<title>Вход</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet"
    href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
</head>
<body>
<sec:authorize access="!isAuthenticated()">
<jsp:forward page="/WEB-INF/pages/login.jsp"></jsp:forward>
</sec:authorize>
	<div id="admin-section">
		<h3>Event list</h3>
		<table border=1>
			<thead>
				<th><%-- <fmt:message key="events.eventName" /> --%>Date</th>
				<th><%-- <fmt:message key="EventList.eventDescription"/> --%>Event</th>
				<th><%-- <fmt:message key="eventsDto.eventDate" /> --%>Description</th>
				<th>Action</th>
				<!-- <th>User</th> -->
			</thead>

			<c:forEach var="event" items="${eventList}">
				<tr>
					<td>${event.eventDate}</td>
					<td>${event.eventName}</td>
					<td>${event.description}</td>
					<td><a
						href="${pageContext.request.contextPath}/event/edit/${event.id}">Edit</a><br />
						<a
						href="${pageContext.request.contextPath}/event/delete/${event.id}.html">Delete</a><br />
					</td>
				</tr>
			</c:forEach>
			
		</table>
		<br>
		<p>
			<a class="btn btn-lg btn-danger" href="<c:url value="/logout" />"
				role="button">Выйти</a>
		</p>
	</div>

</body>
</html>