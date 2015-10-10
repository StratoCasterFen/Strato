<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add criminal here</title>
</head>
<body>
<%@ include file="layout/header.jsp"%>
  			<sec:authorize access="isAuthenticated()">
				<p>
					You are:
					<sec:authentication property="principal.username" />
				</p>
			</sec:authorize>
<h1>Add criminal:</h1>
	
		<form action="events" method="post">
		    Input for name : 
		    <input name="name" type="text"><br>
		    Input for surname:
		    <input name="surname" type="text"><br>
		    Input for birthday:
		    <input name="birthday" type="text"><br>
		    <input type="submit" value="Add">
		    <input name="command" type="hidden" value="ADD_CRIMINAL">
		</form>
</body>
</html>