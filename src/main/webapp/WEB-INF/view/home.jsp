<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!--String loginMember = (String)(request.getAttribute("loginMember"));-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${loginMember}</h3>
	<div>
		<a href = "${pageContext.request.contextPath}/LogoutController">
			<button type = button>logout</button>
		</a>
	</div>
</body>
</html>