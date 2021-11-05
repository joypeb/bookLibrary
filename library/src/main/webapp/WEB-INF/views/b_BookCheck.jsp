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
    <title>대여 확인</title>
</head>
<body>
    <h1>${sessionScope.loginId}님의 도서 대여</h1>
    <form action="b_BookReturn" method="POST">
    	<input type='checkbox' name='bookReturnAll' value='selectall' onclick='selectAll(this)'/><span>모두선택</span><br/>
    	<c:forEach var="list" items="${bookCheckList}" varStatus="status">
		<img src="resources/bookprofile/${list.KProfileName}" width="100px">
		<span>${list.KName}</span>
		<input type="checkbox" value="${list.KNo}" name="bookReturn">
		<input type="hidden" value="${sessionScope.loginId}">
		</c:forEach>
		<button type="submit">반납</button>
	</form>
    
</body>
<script>
	function selectAll(selectAll)  {
	  const checkboxes
	     = document.querySelectorAll('input[type="checkbox"]');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked
	  })
	}
</script>
</html>