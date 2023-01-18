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
   // 자바문법
   String name="dd";
   int age=20;
   
   System.out.println("난 어디에  출력될까???"); //콘솔
   
   //출력
   out.println("이름 = " + name + "<br>");
   out.println("age = " + 20);
   
   
%>
<hr>
<h3> 신기하고 재미 있다!!</h3>
<%
    String [] arr = {"등산","수영","낚시","골프","놀고먹기"};
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

<%!
   String addr;
%>

</body>
</html>








