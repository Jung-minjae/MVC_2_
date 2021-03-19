<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- root 경로 -->
<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0 auto;
}

a {
	text-decoration: none;
}

.photo {
	display: flex;
	align-items: center;
	justify-content: center;
}

li {
	list-style-type: none;
}


body {
	width: 100%;
}

ul, li {
	list-style: none;
}

hr {
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

.dropmenu li a:hover, .dropmenu ul li:hover a {
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

.dropmenu li ul a:hover, .dropmenu li ul li:hover a {
	background-color: rgb(241, 68, 68);
	border: 0px;
	color: #ffffff;
	text-decoration: none;
}

.dropmenu p {
	clear: left;
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
                <h2>사진게시판</h2>
               
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
    <div>
	<ul class="photo">

		<c:forEach var="p" items="${plist}">
			<li><a href="Photoview?pid=${p.pid}"> <img
					src="${root}/${p.path}" />
			</a>
				<div>${p.pname}</div>
				<div>${p.regdate}</div></li>

		</c:forEach>
	</ul>

</div>
	<footer>
		<div class="cl">
			<p>만든이 : 정민재</p>
			<p>문의:010-abcd-efgh</p>
		</div>
	</footer>


</body>

</html>