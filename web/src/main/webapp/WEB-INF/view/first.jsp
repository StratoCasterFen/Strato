<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="webkeys"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Criminal events</title>
</head>
<body>
  	<c:out value="hello: ${username}"/><br>
  	<table border=1>
		<tr>
			<td><a href="events?command=ADD_EVENT"><fmt:message key="href.addEvent"/></a></td>
			<td><a href="events?command=VIEW_EVENTS"><fmt:message key="href.viewEvents"/></a></td>
			<td><a href="events?command=ADD_CRIMINAL"><fmt:message key="href.addCriminal"/></a></td>
			<td><a href="events?command=VIEW_CRIMINAL"><fmt:message key="href.viewCriminals"/></a></td>
		</tr>
	</table>
    
	
  <h1>Event list</h1>
  <table border=1>
	<thead>
    <th><fmt:message key="EventList.eventName"/></th>
    <th><fmt:message key="EventList.eventDescription"/></th>
    <th><fmt:message key="EventList.eventDate"/></th>
    </thead>

    <c:forEach items="${crimEvents}" var="crimEvents">
        <tr>
            <td>${crimEvents.EventName}</td>
            <td>${crimEvents.EventDescription}</td>
            <td>${crimEvents.EventDate}</td>
        </tr>
    </c:forEach>
	</table>
  
</body>
</html>