<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
</head>
<body>
	
	
	<c:forEach var="list" items="${bookList}">
	<span>${list.KNo}</span>
	<span>${list.KName}</span>
	<form action="b_bookRent" method="POST">
		<input type="hidden" name="KCheckin" value="${sessionScope.loginId}">
		<input type="hidden" name="KNo" value="${list.KNo}">
		<c:choose>
			<c:when test="${list.KCheckin eq null}">
				<button type="submit">대여</button>
			</c:when>
			<c:otherwise>
				<span>대여 불가</span>
			</c:otherwise>
		</c:choose>
	</form>
	</c:forEach>
</body>
</html>