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
  <!-- jsp문서에서는 ServletContext를 미리 만들어서
       application이라는 이름을 제공한다. -->
  <h3>ServeletContext - application</h3>
  <%
    //ServletContext영역에 정보를 저장
    application.setAttribute("addr","경기도 안양시 성결대");
    application.setAttribute("menus", Arrays.asList("짬뽕","짜장","탕수육","깐풍기"));
  %>
<h3>ServletContext에 저장된 정보 확인</h3>
주소 : <%=application.getAttribute("addr") %><p>
메뉴 : <%=application.getAttribute("menus") %><p>

<h3>EL ServletContext에 저장된 정보 확인</h3>
주소 : ${applicationScope.addr} / ${addr}<p>
메뉴 : ${applicationScope.menus} / ${menus}<p>
<a href="ex01_result.jsp">이동하자</a>
</body>
</html>