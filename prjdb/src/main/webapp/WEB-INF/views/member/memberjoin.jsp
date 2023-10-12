<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<jsp:include page="../menu/header.jsp"/>
<h1>회원가입</h1></div>
<div>
	<form id="frm" action="memberjoin.do" onsubmit="return formCheck()" method="post">
	<div>
		<table border="1">
			<tr>
				<th width="150">아이디 * </th>
				<td width="300">
					<input type="text" id="memberId" name="memberId" required="required">&nbsp;&nbsp;
					<button type="button" id="idCheck" value="No" onclick="memberIdCheck()">중복체크</button>
				</td>
			</tr>
			<tr>
				<th width="150">패스워드 * </th>
				<td>
					<input type="password" id="memberPassword" name="memberPassword" required="required">
				</td>
			</tr>
			<tr>
				<th width="150">패스워드확인 * </th>
				<td>
					<input type="password" id="checkPassword" name="checkPassword" required="required">
				</td>
			</tr>
			<tr>
				<th width="150">이름 * </th>
				<td>
					<input type="text" id="memberName" name="memberName">
				</td>
			</tr>
			<tr>
				<th width="150">전화번호</th>
				<td>
					<input type="tel" id="memberTel" name="memberTel">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"> * 표시 항목은 필수 입력 정보입니다.</td>
			</tr>
		</table>
		</div><br>
		<div>
			<input type="submit" value="회원가입">&nbsp;&nbsp;
			<input type="reset" value="취 소">
		</div>
	</form>
</div>
<script type="text/javascript">
	function formCheck(){
		let form = document.getElementById("frm");
		
		if(form.idCheck.value == 'No'){
			alert("아이디 중복체크를 하세요");
			return false;
		}
		
		if(form.memberPassword.value != form.checkPassword.value){
			alert("입력한 패스워드가 일치하지 않습니다.");
			form.memberPassword.value="";
			form.checkPassword.value="";
			form.memberPassword.focus();
			return false;
		}
		
		return true;
	}
	
	function memberIdCheck(){//aJax사용
		let url = "ajaxmembercheck.do";
		let payload = document.getElementById("memberId").value;
		
		url = url+"?memberId="+payload;
		console.log(url);
		
		fetch(url) //get방식
			.then(response => response.text()) //결과를 text로 받겠다. 돌려받는 call back method
			.then(text => membercheck(text)); //text를 membercheck메소드에서 처리, 처리하는 call back method
	}
	
	function membercheck(str){
		if(str == 'Yes'){
			alert("사용가능한 아이디 입니다.");
			document.getElementById("idCheck").value = "Yes";
			document.getElementById("idCheck").disabled = true;
		}else{
			alert("이미 사용하는 아이디 입니다.");
			document.getElementById("memberId").value="";
			document.getElementById("memberId").focus();
		}
	}
</script>
</body>
</html>