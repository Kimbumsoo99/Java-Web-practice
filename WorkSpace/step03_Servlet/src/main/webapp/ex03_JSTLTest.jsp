<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 문법</h1>
	<c:if test="${param.id != null}">
		<h3 style="color: red;">${param.id}님환영합니다.</h3>
	</c:if>

	<!-- id가 있으면 id 출력. 없으면 guest 출력 -->

	<c:choose>
		<c:when test="${not empty param.id}">
			<h3 style="border: dashed 5px blue;">${param.id}님반가워요~~</h3>
		</c:when>
		<c:otherwise>
			<h3 style="background: red; color: white">Guest님 반가워요~~</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<a href="forEach">게시물 조회</a>
</body>
</html>