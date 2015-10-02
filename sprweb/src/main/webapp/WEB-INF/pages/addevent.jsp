<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp"%>
<h1>Add event:</h1>
	
		<form action="events" method="post">
		    Input for event name : 
		    <input name="name" type="text"><br>
		    Input for description:
		    <input name="description" type="text"><br>
		    Input for event type :
		    <input name="eventType" type="text"><br>
		    Input for event date :
		    <input name="eventDate" type="date"><br>
		    <input type="submit" value="Add">
		    <input name="command" type="hidden" value="ADD_EVENT">
		</form>
</body>
</html>