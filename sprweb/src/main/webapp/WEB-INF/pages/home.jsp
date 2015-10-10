<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3><c:out value="${message}"/></h3><br><br>
<%-- <h3>Региональные установки и Время</h3>
<c:out value="Locale from request: ${loc}"/><br>
<c:out value="Time from Servlet: ${calend.time}"/> --%>


<a href="${pageContext.request.contextPath}/">Home page</a>
