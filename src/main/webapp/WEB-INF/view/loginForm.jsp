<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#id').focus();
		
		$('#id').blur(function() {
			if($('#id').val() == '') {
				alert('ID를 입력하세요');
				//$('#id').text('0');
			} 
		});
	
		$('#pw').blur(function() {
			if($('#pw').val() == '') {
				alert('비밀번호를 입력하세요');
				//$('#pw').text('0');
			}
		});
	});
</script>

</head>
<body>
	<!-- request.getContextPath()는 EL은 ${pageContext.request.contextPath} 표현 -->
	<h2>login</h2>
	<form action = "${pageContext.request.contextPath}/LoginActionController" method = "post">
		<table border = "1">
			<tr>
				<td>ID</td>
				<td>
					<input type = "text" id = "id" name = "memberId">
				</td>
			</tr>
			<tr>
				<td>PW</td>
				<td>
					<input type = "password" id = "pw" name = "memberPw"> 
				</td>
			</tr>
		</table>
		<button type = "submit">login</button>
	</form>
</body>
</html>