<%-- <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="webkeys"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Criminal events</title>
</head> --%>
<body>
<%@ include file="header.jsp"%>
	 <h1>Event list</h1>
  <table border=1>
	<thead>
    <th><fmt:message key="EventList.eventName"/></th>
<%--     <th><fmt:message key="EventList.eventDescription"/></th> --%>
    <th><fmt:message key="EventList.eventDate"/></th>
    </thead>

    <c:forEach items="${crimEvents}" var="crimEvents">
        <tr>
            <td>${crimEvents.eventName}</td>
<%--             <td>${crimEvents.description}</td> --%>
            <td>${crimEvents.eventDate}</td> 
        </tr>
    </c:forEach>
	</table>
	<p><html:link page="/addevent.do">add</html:link>
	</p>	
</body>
</html>