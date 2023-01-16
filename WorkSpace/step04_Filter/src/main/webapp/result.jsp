<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>전송된 이름 : <%= request.getParameter("userName")%></h3> / ${param.userName}
	<%System.out.println("result.jsp 문서입니다."); %>
</body>
</html>