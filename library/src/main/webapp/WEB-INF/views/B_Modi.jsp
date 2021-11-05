<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_Modi</title>
</head>
<body>
	<form action="B_modi" method="post" enctype="multipart/form-data">
	<table>
		<caption>게시글 수정하기</caption>
		<tr>
			<th>글 번호</th>
			<td>${modi.BNo}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${modi.BWriter}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="BTitle" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="20" cols="40" name="BContent"></textarea></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="BProfile" /></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="hidden" name="BNo" value="${modi.BNo}" >
			<input type="hidden" name="BWriter" value="${modi.BWriter}" >
			<input type="hidden" name="BDate" value="${modi.BDate}" >
			<input type="submit" value="등록">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>