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
   // �ڹٹ���
   String name="dd";
   int age=20;
   
   System.out.println("�� ���  ��µɱ�???"); //�ܼ�
   
   //���
   out.println("�̸� = " + name + "<br>");
   out.println("age = " + 20);
   
   
%>
<hr>
<h3> �ű��ϰ� ��� �ִ�!!</h3>
<%
    String [] arr = {"���","����","����","����","���Ա�"};
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

<%!
   String addr;
%>

</body>
</html>








