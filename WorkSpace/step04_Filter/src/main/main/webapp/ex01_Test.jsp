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
	//�ڹٹ���
	String name="�����";
	int age=25;
	
	//���
	out.print("�̸� = "+name+"<br>");
	out.print("age = " + age);
%>
<hr>
<h3> �ű��ϰ� ��� �ִ�!!</h3>
<%
	String[] arr = {"�İ�","�ڹٽ�ũ��Ʈ","�ڹ�","���̽�","�����"};
%>
<fieldset>
	<legend>��̼���</legend>
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