<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
</head>
<body>
	<form action="m_join" method="POST" enctype="multipart/form-data">
		<input type="text" placeholder="아이디" name="MId"><br />
		
		<input type="password" placeholder="비밀번호" name="MPw"><br />
		
		<input type="text" placeholder="이름" name="MName"><br />
		
		<input type="text" placeholder="년" name="year">
		<select name="month">
			<option selected>Month</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select>
		<input type="text" placeholder="일" name="day"><br />
		
		<input type="tel" placeholder="전화번호" name="MPhone"><br />
		
		<select name="MGender">
			<option selected>성별</option>
			<option value="man">남</option>
			<option value="woman">여</option>
		</select>
		
		<input type="email" placeholder="이메일" name="MEmail">
		
		<input type="text" id="sample6_postcode" class=" form-control form-control-lg nav_input_register register_addr" placeholder="우편번호" name="addr1">
		<button type="button" class="btn btn-secondary register_addr" style="width:100%; height:45px;" onclick="Postcode()">우편번호 찾기</button>
		<input type="text" class=" form-control form-control-lg nav_input_register register_addr" id="sample6_address" placeholder="주소" name="addr2">
		<input type="text" class=" form-control form-control-lg nav_input_register register_addr" id="sample6_detailAddress" placeholder="상세주소" name="addr3">
		
		<div>프로필사진</div>
		<input type="file" name="MProfile">
		
		<button type="submit">회원가입</button>
	</form>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function Postcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
               
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}
</script>
</html>