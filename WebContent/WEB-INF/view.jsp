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

<style>
* {
	margin: 0 auto
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
</style>
<title>Insert title here</title>
</head>
<body>
	<header class="header">
		<div class="inner">
			<a href="#">
				<h2>메인화면</h2>

			</a>
			<div class="header_line">
				<c:if test="${not empty sessionScope.id}">
         	
        	${sessionScope.id}님 반갑습니다　
                <a href="logout">로그아웃 </a>

				</c:if>

				<c:if test="${empty sessionScope.id}">
					<div>
						<a href="join">회원가입 </a> <span style="color: white;">|</span> <a
							href="login">로그인 </a>
					</div>
				</c:if>
			</div>




		</div>

	</header>
	<c:forEach var="dl" items="${detail_list}" varStatus="t">
		<table border="1">

			<tr>
				<td>${dl.contentID}</td>
				<td>${dl.title}</td>
				<td>${dl.userID}</td>
				<td>${dl.content}</td>
				<td>${dl.date}</td>
			</tr>

		</table>
		<!-- 	<br> -->
		<!-- 	<br> -->
		<a href="border">목록</a>

		<c:if test="${dl.userID == sessionScope.id}">
			<a href="update?contentID=${dl.contentID}">수정</a>
			<a href="delete?contentID=${dl.contentID}">삭제</a>
		</c:if>
	</c:forEach>
</body>
</html>