<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="webkeys"/>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  	<c:out value="User: ${username}"/><br>
  	<table border=1>
		<tr>
			<td><a href="events?command=ADD_EVENT_PAGE"><fmt:message key="href.addEvent"/></a></td>
			<td><a href="events?command=VIEW_EVENTS"><fmt:message key="href.viewEvents"/></a></td>
			<td><a href="events?command=ADD_CRIMINAL_PAGE"><fmt:message key="href.addCriminal"/></a></td>
			<td><a href="events?command=VIEW_CRIMINALS"><fmt:message key="href.viewCriminals"/></a></td>
		</tr>
	</table>
	<hr>