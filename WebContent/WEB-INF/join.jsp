<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<c:set var="root" value="${pageContext.request.contextPath}" />
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>회원가입 창</title>

<style>
* {
	margin: 0 auto;
}

hr {
	clear: both;
	border: none;
}

.inner {
	width: 1000px;
}

.inner {
	width: 1200px;
	max-width: 1200px;
	margin: auto;
}

.header {
	background-color: lightblue;
	height: 50px;
}

.header .inner h2 {
	color: white;
	float: left;
	padding-top: 10px;
}

.header .inner h2:hover {
	color: blue;
}

.header_line {
	display: block;
	float: right;
	padding-top: 10px;
}

.header_line a {
	color: white;
}

.header_line a:hover {
	color: black;
}

ul li {
	text-decoration: none;
}

a {
	text-decoration: none;
}

table {
	border: 1px solid black;
	line-height: 40px;
	margin-bottom: 20px;
	background-color: lightseagreen;
	color: white;
}

th {
	padding: 10px;
	text-align: left;
}

td>input {
	height: 29px;
}

.last>input {
	width: 29%;
	height: 50px;
	color: white;
}

.last>a>input {
	width: 29%;
	height: 50px;
	color: white;
}

.last>input:first-child {
	background-color: red;
}

.last>a>input:first-child {
	background-color: blue;
}

.last>input:hover {
	background-color: green;
}

.last>a>input:hover {
	background-color: green;
	.
	pp
	>input{
	height
	:
	12px
}
</style>

</head>

<body>
${root}

	<header class="header">
		<div class="inner">
			<a href="index">
				<h2>배너</h2>

			</a> <a href="login" class="header_line">로그인 </a>
		</div>



	</header>
	<div style="text-align: center; margin-bottom: 30px;">
		<h1>회원가입창</h1>
	</div>
	<form action="join" name ="join" method="post">
		<table>

			<tr>
				<th>아이디</th>
				<td><input type="text" placeholder="ID를 입력하세요" name="userID"
					maxlength="20" required></td>

				<td><button type="button" onclick="idCheck(join,'${root}');">아이디 중복</button></td>


			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" placeholder="비밀번호 입력"
					name="userPass" id="pwd1" required></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" placeholder="비밀번호를 다시 입력하세요"
					id="pwd2"></td>
				<td>
					<div class="alert alert-success" id="alert-success"
						style="color: rgb(82, 253, 76);">비밀번호가 일치합니다.</div>
					<div class="alert alert-danger" id="alert-danger"
						style="color: red;">비밀번호가 일치하지 않습니다.</div>
				</td>




			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" placeholder="이름을 입력하세요" name="userName"
					maxlength="20" required></td>
			<tr>
				<th>휴대전화</th>
				<td><input type="tel" placeholder="휴대전화를 입력하세요"
					name="userPhone" maxlength="20"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td class="pp"><input type="radio" name="userGender" value="남성"
					checked> 남성 <input type="radio" name="userGender"
					value="여성"> 여성</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="tel" placeholder="이메일을 입력하세요" name="userEmail">
					<span>@</span>
				<td><input id="textEmail" placeholder="이메일을 선택하세요."> <select
					id="select" name="userEmail2">
						<option value="" disabled selected>E-Mail 선택</option>
						<option value="naver.com" id="naver.com">naver.com</option>
						<option value="hanmail.net" id="hanmail.net">hanmail.net</option>
						<option value="gmail.com" id="gmail.com">gmail.com</option>
						<option value="nate.com" id="nate.com">nate.com</option>
						<option value="select" id="select">직접 입력하기</option>
				</select></td>
			</tr>

		</table>

		<hr>
		<div class="inner last" style="text-align: center;">
			<input type="submit" value="회원가입"> <a href="index"><input
				type="button" name="취소" value="돌아가기"> </a>
		</div>
	</form>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
        $(function () {
            $("#alert-success").hide();
            $("#alert-danger").hide();
            $("input").keyup(function () {
                var pwd1 = $("#pwd1").val();
                var pwd2 = $("#pwd2").val();
                if (pwd1 != "" || pwd2 != "") {
                    if (pwd1 == pwd2) {
                        $("#alert-success").show();
                        $("#alert-danger").hide();
                        $("#submit").removeAttr("disabled");
                    } else {
                        $("#alert-success").hide();
                        $("#alert-danger").show();
                        $("#submit").attr("disabled", "disabled");
                    }
                }
            });
        });
    </script>

<script type="text/javascript" src="${root}/js/user/joinUp.js" defer></script>

</body>


</html>