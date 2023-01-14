<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center</title>
<style type="text/css">
#board-title {
	margin-top: 30px;
	text-align: center;
}

table {
	text-align: center;
	width: 400px;
	border: 3px double red;
	border-collapse: collapse;
}

th, td {
	padding: 3px;
	border: 1px black solid;
	text-align: center;
}
</style>
</head>
<body>
	<h2 id="board-title">Board LIST</h2>
	<table style="margin-left: auto; margin-right: auto">
		<tr>
			<th>no</th>
			<th>subject</th>
			<th>content</th>
		</tr>
		<c:forEach items="${applicationScope.boardList}" var="boardList"
			varStatus="state">
			<tr>
				<td>${boardList.gno}</td>
				<td>${boardList.subject}</td>
				<td>${boardList.content}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>