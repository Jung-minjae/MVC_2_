<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>로그인</title>
<style>
* {
	margin: 0 auto;
}

.inner {
	width: 1200px;
}

hr {
	border: none;
	clear: both;
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

#leftText {
	/*아이디, 비밀번호 글씨 부분*/
	width: 150px;
	height: 40px;
	display: flex;
	/*div를 float를 사용했기 때문에 정렬을 위해서 flex로 설정*/
	justify-content: left;
	/*horizontal left */
	align-items: center;
	/*상하 정렬*/
	font-size: 15px;
	/*글씨 사이즈*/
	font-weight: bold;
	margin-top: 20px;
	/*margin-top: 10px;*/
}

#inputText {
	/*텍스트 입력 부분*/
	width: 180px;
	height: 40px;
	/*border: 1px solid black;*/
	display: flex;
	font-size: 20px;
	justify-content: left;
	vertical-align: middle;
	margin: 20px;
}

#securityText {
	/*보안접속 부분*/
	align-items: center;
	font-size: 12px;
}

#main {
	/*기본 바탕 부분 div*/
	width: 700px;
	height: 100px;
	/*border: 1px solid red;*/
	display: flex;
	align-items: center;
	justify-content: center;
}

#mainLogo {
	/*로그인 타이틀*/
	width: 700px;
	height: 200px;
	/*border: 1px solid red;*/
	display: flex;
	align-items: center;
	justify-content: center;
}

#main2Left {
	/*로그인 div를 넣을 div*/
	width: 400px;
	height: 100%;
	/*border: 1px solid red;*/
	display: inline-block;
	vertical-align: middle;
}

#main2Right {
	/*로그인 버튼을 넣을 div*/
	width: 200px;
	height: 120px;
	/*border: 1px solid red;*/
	display: flex;
}

#loginTitle {
	color: lightblue;
	font-size: 40px;
	font-weight: bold;
}

#button {
	/*로그인 버튼*/
	width: 200px;
	height: 50px;
	text-align: center;
	background-color: lightblue;
	color: white;
	border: 1px solid lightblue;
	margin: 40px 0px;
}

#button:hover {
	/*로그인 버튼 오버*/
	background-color: white;
	color: #4E266D;
	cursor: pointer;
}

#bottomBtn {
	/*하단 버튼 3개*/
	margin-right: 10px;
	width: 140px;
	height: 30px;
	background-color: white;
	color: black;
	border: 1px solid lightblue;
}

#bottomBtn:hover {
	/*하단 버튼 오버*/
	width: 140px;
	height: 30px;
	background-color: lightblue;
	color: white;
	border: 1px solid lightblue;
	cursor: pointer;
}

#mainLine {
	width: 700px;
	height: 50px;
	border-bottom: 1px solid black;
}

#center {
	width: 100%;
	height: 100%;
	text-align: center;
	margin: auto;
	background-color:;
}

#contents {
	display: flex;
	justify-content: space-around;
}

.float_left {
	float: left;
}

.float_right {
	float: right;
}

.searching input {
	background: #eee;
	transition: all 0.5s;
}

.searching input:focus {
	outline: none;
}

footer {
	color: white;
	background-color: black;
	width: 100%;
	height: 117px;
	margin-top: 20px;
}

.cl {
	padding-top: 50px;
	float: right;
	margin-right: 20px;
}
</style>

</head>

<body>

	   <header class="header">
        <div class="inner">
            <a href="index">
                <h2>메인화면</h2>
               
            </a>
            <div class="header_line">          

              </div>
             
   
           
          
        </div>
        
    </header>

	<div id="mainLogo" class="inner">
		<span id="loginTitle"> 로그인 </span>
	</div>
	<form action="login" method="post">
		<content>
		<div id="contents">
			<div id="left"></div>
			<div id="center">
				<div id="main2Left">
					<div class="float_left">
						<div id="leftText">
							<span>아이디</span>
						</div>
					</div>
					<div id="inputText" class="searching">
						<input type="text" onfocus="this.value=''"
							placeholder="아이디를 입력하세요" name="userID">
					</div>
					<hr>
					<div class="float_left">
						<div id="leftText">
							<span>비밀번호</span>
						</div>
					</div>
					<div id="inputText" class="searching">
						<input type="password" onfocus="this.value=''"
							placeholder="비밀번호를 입력하세요" name="userPass">
					</div>


					<div id="main2Right">
						<input type="submit" id="button" value="로그인" />
					</div>

				</div>
				<div right></div>
			</div>

		</div>

		</content>
	</form>
	<div id="mainLine" style="clear: both;"inner"></div>
	<div id="main">
		<input id="bottomBtn" type="button" value="아이디 찾기" /> <input
			id="bottomBtn" type="button" value="비밀번호 찾기" /> <a href="join">
			<input id="bottomBtn" type="button" value="회원가입" />
		</a>
	</div>

</body>

</html>