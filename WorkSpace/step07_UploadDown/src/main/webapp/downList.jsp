<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  a{text-decoration: none;}
</style>
</head>
<body>
${requestScope.fileNames}
<h1> 다운로드 가능한 항목 </h1>
<ul>
  <c:forEach items="${fileNames}" var="fileName">
     <ol><a href="downLoad?fileName=${fileName}">${fileName}</a></ol>
  </c:forEach>
</ul>

<hr color="red">
<%
    String [] fnames = (String [] )request.getAttribute("fileNames");
   // out.println("fnames = " + fnames);
    
    for(String fname : fnames){
    	String convertEncName = URLEncoder.encode(fname, "UTF-8");
       %>
         <a href="downLoad?fileName=<%=convertEncName%>"><%=fname%></a> <p>
       <% 	
    }

%>

<hr color="red">
<h3> Map으로 가져오기 </h3>
<c:forEach items="${fileMap}" var="map">
   <a href="downLoad?fileName=${map.value}">${map.key}</a> <br>
</c:forEach>

</body>
</html>








