<%@page import="sku.dto.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="sku.dao.TestDAO"%>
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
	TestDAO dao = new TestDAO();
	List<EmpDTO> list = dao.selectAll();
%>
결과 : <%=list%>
</body>
</html>