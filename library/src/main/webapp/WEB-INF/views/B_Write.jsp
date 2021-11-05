<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성하기</title>
</head>
<body>
	<form action="B_write" method="post" enctype="multipart/form-data">
		<table>
			<caption>게시글 작성하기</caption>
			<tr>
				<th>작성자</th>
				<td>${sessionScope.loginId}</td>
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
				<td colspan="2"><input type="hidden" name="BWriter"
					value="${sessionScope.loginId}"> <input type="submit"
					value="등록"></td>
			</tr>

		</table>

	</form>
</body>
</html>