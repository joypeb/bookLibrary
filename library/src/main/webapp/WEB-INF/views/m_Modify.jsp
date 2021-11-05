<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring_회원수정</title>
</head>
<body>
<form action="m_modify" method="POST" enctype="multipart/form-data">
	<table>
		<caption>회원수정</caption>
		<tr>
			<th>아이디</th>
			<td>${modify.MId}<input type="hidden" name="MId" value="${modify.MId}">
			<input type="hidden" name="page" value="${page}"></td>
		</tr>		
		<tr>
			<th>패스워드</th>
			<td><input type="password" name="MPw"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="MName" placeholder="${modify.MName}"></td>
		</tr>		
		<tr>
			<th>생년월일</th>
			<td><input type="date" name="MBirth"></td>
		</tr>
		
		<tr>
			<th>성별</th>
			<td><input type="date" name="MGender"></td>
		</tr>
		
		
		<tr>
			<th>연락처</th>
			<td><input type="text" name="MPhone" placeholder="${modify.MPhone}"></td>
		</tr>		
			
		<tr>
			<th>이메일</th>
			<td><input type="email" name="MEmail" placeholder="${modify.MEmail}"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="MAddr" placeholder="${modify.MAddr}"></td>
		</tr>
		
		<tr>
			<th>프로필사진</th>
			<td><input type="file" name="MProfile"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
</form>
</body>
</html>