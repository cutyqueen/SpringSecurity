<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> admin.jsp </h1>
	
	<sec:authentication property="principal"/>
	
	<sec:authorize access="isAuthenticated()">
	<h2><a href="/logout">로그아웃</a></h2>
	</sec:authorize>
	
</body>
</html>