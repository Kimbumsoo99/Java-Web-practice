<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping</title>

<link rel="StyleSheet" 
href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<script 
src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>

</head>
<body>
<div class="navbar navbar-default" >
  <div class="navbar-header" >
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="${path}/index.jsp">메인화면</a>
  </div>
  
  <div class="navbar-collapse collapse navbar-responsive-collapse">
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/front">상품게시판</a></li>
     </ul>
     
     <!-- 로그인 되면 sessionScope에 loginUser 저장되어있다! -->
      <ul class="nav navbar-nav navbar-right">
     <c:choose>
      <c:when test="${not empty loginUser}">
	     	<li class="active"><a href="${path}/user/login.jsp">마이페이지</a></li>
	      	<li><a href="${path}/front?key=user&methodName=logout" class="btn btn-danger">로그아웃</a></li>	     
      </c:when>
      <c:otherwise>
      	    <li class="active"><a href="${path}/user/login.jsp">로그인</a></li>
	      	<li><a href="${path}/user/join.jsp" class="btn btn-danger">회원가입</a></li>
      </c:otherwise>
     </c:choose>
     </ul>

  </div>
</div>



