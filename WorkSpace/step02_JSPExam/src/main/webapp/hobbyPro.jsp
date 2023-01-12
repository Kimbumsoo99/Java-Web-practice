<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//post방식 한글 인코딩 설정
	request.setCharacterEncoding("UTF-8");

	//전송된 데이터 받기
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	//String hobby = request.getParameter("hobby");
	
	//하나의 이름으로 여러개의 값이 전송될때
	String[] hobbys = request.getParameterValues("hobby");
%>
	<h3>
	이름 : <%=name%><br>
	나이 : <%=age%><br>
	취미 : <%
		for(String h : hobbys){
			out.print(h+", ");
		}
	%>
	</h3>
</body>
</html>