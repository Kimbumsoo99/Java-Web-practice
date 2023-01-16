<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center</title>
<style type="text/css">
	table{width: 300px; border: double pink 2px;border-collapse: collapse; }
	th,td{text-align: center; border: solid black 1px;}
</style>
</head>
<body>
	<h2>Board LIST</h2>
	<table>
		<tr>
			<th>no</th>
			<th>subject</th>
			<th>content</th>
		</tr>
		<!-- 기본 데이터 출력 -->
		<c:forEach items="${boardList}" var="board">
		<tr>
		  <td>${board.gno}</td>
		  <td>${board.subject}</td>
		  <td>${board.content}</td>
		</tr>
		</c:forEach>
	</table>

	<!-- 인증된 경우 게시물 등록 기능 -->
	<c:if test="${not empty userId}">
		<form action="${pageContext.request.contextPath}/board" method="post">
			글번호 : <input type="number" name="gno" id="gno" /><br/>
			제목 : <input type="text" name="subject" /><br/>
			내용 : <input type="text" name="content" /><br/>
			<input type="submit" value="등록하기" />
		</form>
	</c:if>
</body>
</html>