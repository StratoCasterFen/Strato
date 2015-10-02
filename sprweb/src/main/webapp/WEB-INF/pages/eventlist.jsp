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