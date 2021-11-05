<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<caption>게시글 정보보기</caption>
		<tr>
			<th>게시글 번호</th>
			<td>${view.BNo}</td>
		</tr>
		
		<tr>
			<th>작성자</th>
			<td>${view.BWriter}</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td>${view.BTitle}</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>${view.BContent}</td>
		</tr>
		
		<tr>
			<th>최종 작성 날짜</th>
			<td>${view.BDate}</td>
		</tr>
	
		<tr>
			<th>첨부파일</th>
			<td><img src="resources/BoardProfile/${view.BProfileName}" width="300px"/></td>
		</tr>
		
		<c:if test="${view.BWriter eq sessionScope.loginId}">
		<tr>
			<td colspan="2">
			<button onclick="location.href='B_modiForm?BNo=${view.BNo}&page=${paging.page}'">수정</button>
			<button onclick="location.href='B_delete?BNo=${view.BNo}&page=${paging.page}'">삭제</button>
			</td>
		</tr>
		</c:if>	
			
		<tr>
			<td colspan="2">
			<button onclick="location.href='B_list?page=${paging.page}'">뒤로가기</button>
			</td>
		</tr>
	</table>
</body>
</html>