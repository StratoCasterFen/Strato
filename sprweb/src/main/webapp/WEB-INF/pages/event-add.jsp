<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="layout/header.jsp"%>

			
<h1>Add event:</h1>
	
		<form action="list" method="post">
		    Input event name : 
		    <input name="name" type="text"><br>
		    Input description:
		    <input name="description" type="text"><br>
		    Input event type :
		    <input name="eventType" type="text"><br>
		    Input event date :
		    <input name="eventDate" type="date"><br>
		    Select Criminal
			<select name="idCriminal">
								<c:forEach items="${criminalList}" var="criminal">
									<option value=${criminal.id}>${criminal.criminalName} ${criminal.criminalSurname}</option>
								</c:forEach>
			</select><br>
		    <input type="submit" value="Add">
		    <input name="command" type="hidden" value="add">
		</form>
		${message}
</body>
</html>