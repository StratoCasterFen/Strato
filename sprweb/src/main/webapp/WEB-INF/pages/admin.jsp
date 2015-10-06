<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page session="false"%>
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
        <h3>Поздравляем, вы на закрытой странице!</h3>
<!--         <a class="btn btn-primary" href="/j_spring_security_logout">Выход</a> -->

		<div class="jumbotron" style="margin-top: 20px;">
			<sec:authorize access="isAuthenticated()">
				<p>
					Ваш логин:
					<sec:authentication property="principal.username" />
				</p>
			</sec:authorize>	
				<p>
					<a class="btn btn-lg btn-danger" href="<c:url value="/logout" />"
						role="button">Выйти</a>
				</p>

		</div>


	</div>
</body>
</html>