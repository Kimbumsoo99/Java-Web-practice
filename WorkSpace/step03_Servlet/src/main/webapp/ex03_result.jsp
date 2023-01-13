<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 800px;
	border: 3px double red;
}

th, td {
	padding: 3px;
	border: 1px pink solid;
	text-align: center;
}
</style>
</head>
<body>
	<h1>BOARD LIST</h1>
	<!--  \${requestScope.boardList} = ${boardList} -->
	<table>
		<tr>
			<th>순서</th>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
		</tr>
		<c:forEach items="${requestScope.boardList}" var="board"
			varStatus="state">
			<tr>
				<td>${state.count}</td>
				<td>${board.bno}</td>
				<td>${board.writer}</td>
				<td>${board.subject}</td>
				<td>${board.content}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>