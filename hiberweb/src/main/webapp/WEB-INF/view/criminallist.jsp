<body>
<%@ include file="header.jsp"%>
	 <h1>criminal list</h1>
  <table border=1>
	<thead>
	<th><fmt:message key="CriminalList.id"/></th>
    <th><fmt:message key="CriminalList.Name"/></th>
    <th><fmt:message key="CriminalList.SurName"/></th> 
    <th><fmt:message key="CriminalList.Birthday"/></th>
    </thead>

    <c:forEach items="${criminals}" var="criminals">
        <tr>
        	<td>${criminals.id}</td>
            <td>${criminals.criminalName}</td>
            <td>${crimEvents.criminalSurname}</td> 
            <td>${crimEvents.birthday}</td> 
        </tr>
    </c:forEach>
	</table>
	<p><html:link page="first.jsp">main</html:link>
	</p>	
</body>
</html>