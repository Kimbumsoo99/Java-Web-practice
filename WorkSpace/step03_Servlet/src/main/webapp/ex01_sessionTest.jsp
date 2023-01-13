<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>HttpSession - session 알아보기</h1>
  <%
  	//HttpSession - jsp에서 이미 만들어서 session이름으로 제공
  	session.setMaxInactiveInterval(30);
  	session.setAttribute("message", "즐거운 금요일");	
  	session.setAttribute("hobbys", Arrays.asList("등산","수영","낚시"));
  %>
 session.isNew() = <%=session.isNew()%><br>
  session.getMaxInactiveInterval() = <%=session.getMaxInactiveInterval()%><br>
 session.getId() = <%=session.getId()%><br>
 session.getLastAccessedTime() = <%=session.getLastAccessedTime() %><br>
 session.getCreationTime() = <%=session.getCreationTime()%><br>
 
 <h3>세션의 저장된 정보</h3>
 메시지 : <%=session.getAttribute("message") %><p>
 취미 : <%=session.getAttribute("hobbys") %> 
   <a href="ex01_result.jsp">이동</a>
   <h3>EL 표기 저장된 정보 확인</h3>
메시지 : ${sessionScope.message}/ ${message}<p>
취미 : ${sessionScope.hobbys} / ${hobbys}<p>
</body>
</html>