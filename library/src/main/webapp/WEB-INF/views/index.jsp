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
    <title>메인화면</title>
</head>
<body>
	<h1>${sessionScope.loginId}님 환영합니다.</h1>
    <a href="m_joinForm">회원가입</a>
    <a href="m_loginForm">로그인</a>
    <a href="m_logout">로그아웃</a>
    <a href="m_view?MId=${sessionScope.loginId}">회원 정보</a>
    <a href="m_modiForm?MId=${sessionScope.loginId}">회원 수정,삭제</a>
    <button onclick="location.href='S_reservForm?MId=${sessionScope.loginId}'">열람실 좌석예약</button>
	<button onclick="location.href='B_list?MId=${sessionScope.loginId}'">게시글 목록</button>
	<button onclick="location.href='B_writeForm?MId=${sessionScope.loginId}'">게시글 작성</button>
    <a href="b_BookList">도서 대여</a>
    <a href="b_bookCheck?MId=${sessionScope.loginId}">도서대여확인</a>
</body>
<script type="text/javascript" src="resources/js/jquery3.6.0.js"></script>
<script>
//해당 시간대의 이용시간이 종료하면 자동으로 DB 값을 다시 "empty"로 변경
$(document).ready(function(){
	var now = new Date();
	var hours = now.getHours();
	
	if(hours >= 13){
		$.ajax({
			type : "POST",
			url : "S_mTimeOver",
			data : { "hours" : hours },
			dataType : "text",
			async : false,
			success : function(data) {
			},
			error : function() {
				alert("현재 시간 새로고침 실패");
			}
		});
	} else if(hours >= 17){
		$.ajax({
			type : "POST",
			url : "S_aTimeOver",
			data : { "hours" : hours },
			dataType : "text",
			async : false,
			success : function(data) {
			},
			error : function() {
				alert("현재 시간 새로고침 실패");
			}
		});
	} else if(hours >= 21){
		$.ajax({
			type : "POST",
			url : "S_eTimeOver",
			data : { "hours" : hours },
			dataType : "text",
			async : false,
			success : function(data) {
			},
			error : function() {
				alert("현재 시간 새로고침 실패");
			}
		});
	}
	
});
</script>
</html>