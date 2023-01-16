<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>~.jsp 이동</h3>
	<form action="${pageContext.request.contextPath}/result.jsp" method="post">
		이름 : <input type="text" name="userName">
		<input type="submit" value="전송">
	</form>
	
	<hr color="red">
	
	<h3>Servlet 이동</h3>
	<form action="${pageContext.request.contextPath}/encoding" method="post">
		이름 : <input type="text" name="userName">
		<input type="submit" value="전송">
	</form>
	
</body>
</html>