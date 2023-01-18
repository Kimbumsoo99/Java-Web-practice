<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=request.getParameter("userName")%> 님 로그인 성공!!</h1>
<hr>
<h1>${param.userName}님 로그인 성공!!</h1>

</body>
</html>