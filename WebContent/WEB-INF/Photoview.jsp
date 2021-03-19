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
    header{
        background-color: black
        ;
        height: 100px;
        color: wheat;
      
    }
</style>
<title>Insert title here</title>
</head>
<body>
   <header>
    
     <a href ="index">  <h1 style="padding: 20px;">배너</h1></a> 
   </header>
	<table border="1">
		<tr>
			<td rowspan=3><img src="${root}/${p.path}"></td>
			<td>${p.pname}</td>
		</tr>
		<tr>
			<td>${p.regdate}</td>
	</table>
	<br>
	<br>
	<c:if test="${count!=0}">
		<table border="1">
			<c:forEach var="c" items="${c}">
				<tr>
					<td>${c.userID}</td>
					<td>${c.regdate}</td>
				</tr>
				<tr>
					<td>${c.comment}</td>
					<td>${c.score}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test ="${count==0}">
	<h3>댓글을 입력해주세요</h3></c:if>	
	
	<form action="" method="post">
		<div class="comment">
			<input type="text" name="comment" /> <span> 
			<select name ="s">
			<option ${(param.s== "5" )?"selected":""} value="5">5점</option>
			<option ${(param.s== "4" )?"selected":""} value="5">4점</option>
			<option ${(param.s== "3" )?"selected":""} value="5">3점</option>
			<option ${(param.s== "2" )?"selected":""} value="5">2점</option>
			<option ${(param.s== "1" )?"selected":""} value="5">1점</option>
			
			</select>
				</span>
			
			</div>
			<div><input type="submit" value="글쓰기" /></div>
		
		

	</form>
</body>
</html>