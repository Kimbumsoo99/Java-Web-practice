<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>확인하자</h3>
  <h3>세션의 저장된 정보</h3>
 메시지 : <%=session.getAttribute("message") %><p>
 취미 : <%=session.getAttribute("hobbys") %> 
 <h3>EL 세션의 저장된 정보 확인</h3>
메시지 : ${sessionScope.message}/ ${message}<p>
취미 : ${sessionScope.hobbys} / ${hobbys}<p>

   <h3>ServletContext에 저장된 정보 확인</h3>
주소 : <%=application.getAttribute("addr") %><p>
메뉴 : <%=application.getAttribute("menus") %><p>
 
<h3>EL ServletContext에 저장된 정보 확인</h3>
주소 : ${applicationScope.addr} / ${addr}<p>
메뉴 : ${applicationScope.menus} / ${menus}<p>
 
</body>
</html>