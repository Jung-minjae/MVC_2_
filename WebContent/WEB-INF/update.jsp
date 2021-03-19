<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<c:set var="root" value="${pageContext.request.contextPath}" />
<html>

<head>
<meta charset="UTF-8">
<!-- 화면 최적화 -->
<!-- <meta name="viewport" content="width-device-width" , initial-scale="1"> -->
<!-- 루트 폴더에 부트스트랩을 참조하는 링크 -->

<link rel="stylesheet" href="css/bootstrap.css">
<title>글쓰기 게시판</title>

</head>
<Style>

* {
    margin: 0;
    padding: 0;
}

body {
  
    width: 100%;

}

ul,
li {
    list-style: none;
}

a {
    text-decoration: none;
}
hr{
    border: none;
    margin-bottom: 40px;
    clear: both;

}

.inner {
    width: 1200px;
    max-width: 1200px;
    margin: auto;
}

.header {
    background-color: lightblue;
    height: 100px;
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
.header_line a:hover{
    color:black;
}

.inner .menu .main {
    margin-top: 20px;
    height: 100px;
}

.inner .menu .main>li {
    float: left;
    width: calc(100%/ 4);
    text-align: center;
    font-size: large;
}

.inner .menu .main .sub {
    position: relative;
    display: none;
}

.inner .menu .main .sub>li {
    font-size: medium;
    margin: 5px 0;
}

.inner .menu .main>li:hover>a {
    background-color: wheat;
}

.inner .menu .main>li:hover .sub {
    display: block;
}
.dropmenu {
    border: none;
    border: 0px;
    padding: 0px;
    font: "sans-serif";
    font-size: 18px;
    display: flex;
    justify-content: space-around;
    align-items: center;
    background-color: lightcoral;

}


.dropmenu>ul {
    text-align: center;
    background-color: lightcoral;
    height: 100px;
    list-style: none;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 1px 1px;

}

.dropmenu>ul>li {

    float: left;
    padding: 0px;
    position: relative;
}

.dropmenu li a {

    color: #fff;
    display: block;
    line-height: 100px;
    margin: 0px;
    padding: 0px 25px;
    text-align: center;
    text-decoration: none;
}

.dropmenu li a:hover,
.dropmenu ul li:hover a {
    background: rgba(248, 168, 248, 0.938);
    color: #FFFFFF;
    text-decoration: none;
}

.dropmenu li ul {
    background: rgba(248, 168, 248, 0.938);
    display: none;
    height: auto;
    border: 0px;
    position: absolute;
    width: 100%;
    z-index: 50;
    /*top:1em;
/*left:0;*/
}

.dropmenu li:hover ul {
    display: block;
}

.dropmenu li li {
    background: rgba(248, 168, 248, 0.938);;
    display: block;
    float: none;
    margin: 0px;
    padding: 25px;
    /* width:70px; */
}

.dropmenu li:hover li a {
    background: none;
}

.dropmenu li ul a {
    display: block;
    height: 80px;
    font-size: 14px;
    margin: 0px;
    padding: 0px 0px 0px 0px;
    text-align: center;
    line-height: 80px;
}

.dropmenu li ul a:hover,
.dropmenu li ul li:hover a {
    background-color: rgb(241, 68, 68);
    border: 0px;
    color: #ffffff;
    text-decoration: none;
}

.dropmenu p {
    clear: left;
}

.board{
  
    width: 100%;
}
.left{
 
    float: left;
    width: 500px;
    border: 1px solid black;
    height: 600px;
}
.right{
   
    float: right;
    width: 500px;
    border: 1px solid black;
    height: 600px;
}
.right{
   
    float: right;
    width: 500px;
    border: 1px solid black;
    height: 600px;
}
.write_btn {
	text-align: right;
}

.container {
	margin-top: 30px
}
</Style>

<body>
   <header class="header">
        <div class="inner">
            <a href="index">
                <h2>메인화면</h2>
               
            </a>
            <div class="header_line">
            <c:if test="${not empty sessionScope.id}">
         	
        	${sessionScope.id}님 반갑습니다
                <a href="logout">로그아웃 </a>
          
              </c:if>
             
  			  <c:if test="${empty sessionScope.id}">
  			   <div>
  				<a href="join">회원가입 </a> <span style="color: white;">|</span>
                <a href="login">로그인 </a>
            </div>
             </c:if>
              </div>
             
   
           
          
        </div>
        
    </header>
    <hr>
	<nav>
		<div class="inner">
			<h3 style="text-align: center; padding-left: 20px;">글 수정</h3>
		</div>
	</nav>

	<!-- 게시판 글쓰기 양식 영역 시작 -->
	<div class="container inner">
		<div class="row">
			<form method="post">
				<input type="hidden" name="contentID" value="${contentID}">
				
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">게시판
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="hidden" value="${sessionScope.id}"
								name="userid"> <input type="text" class="form-control"
								placeholder="글 제목" name="title" maxlength="50"
								style="width: 1200px; height: 30px"></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 내용" name="content" maxlength="2048"
								style="height: 500px; width: 1200px;"></input></td>
						</tr>
					</tbody>
				</table>
				<!-- 글쓰기 버튼  -->
				<input type="submit" class="write_btn" style="float: right;"
					value="글쓰기">
			</form>
		</div>
	</div>
	<!-- 게시판 글쓰기 양식 영역 끝 -->

	<!-- 부트스트랩 참조 영역 -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>

</html>