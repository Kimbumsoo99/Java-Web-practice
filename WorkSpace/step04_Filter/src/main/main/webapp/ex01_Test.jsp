<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//자바문법
	String name="김범수";
	int age=25;
	
	//출력
	out.print("이름 = "+name+"<br>");
	out.print("age = " + age);
%>
<hr>
<h3> 신기하고 재미 있다!!</h3>
<%
	String[] arr = {"컴공","자바스크립트","자바","파이썬","씨언어"};
%>
<fieldset>
	<legend>취미선택</legend>
	<%
		for(String h : arr){
			%> 
			<input type="checkbox" name="hobby" value="<%=h%>"><%=h%>
			<%
		}
	%>
</fieldset>
</body>
</html>