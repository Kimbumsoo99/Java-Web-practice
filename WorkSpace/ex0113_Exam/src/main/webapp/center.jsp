<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center</title>
<style type="text/css">
.body{
	width: 500px;
}
.board{
text-align: center;
}
#board-title {
	margin-top: 30px;
	text-align: center;
}

#gno {
	width: 5em;
	-webkit-appearance: none;
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
	<div class="body">
		<div class="board">
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
		</div>
		<c:if test="${not empty userId}">
			<div class="reg">
				<form action="board" method="post">
					글번호 : <input type="number" name="gno" id="gno" /><br/><br/> 제목 : <input
						type="text" name="subject" /><br /><br/> 내용 : <input type="text"
						name="content" /><br /><br/> <input type="submit" value="등록하기" />
				</form>
			</div>
	</div>
	</c:if>




</body>
</html>