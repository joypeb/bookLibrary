<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="joypeb">
    <title>로그인</title>
</head>
<body>
   	<form action="m_login" method="POST">
   		<input type="text" placeholder="id" name="MId"><br/>
   		<input type="password" placeholder="pw" name="MPw"><br/>
   		<button type="submit">로그인</button>
   	</form>
</body>
<script>

</script>
</html>