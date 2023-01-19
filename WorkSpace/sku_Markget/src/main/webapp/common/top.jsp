<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JunggoDang</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><h1>🤞중고당</h1></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>	
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">메인화면 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/front">게시판</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${path}/user/login.jsp">Login</a>
      </li>
    </ul>
    <span class="navbar-text">
    <c:choose>
    	<c:when test="${not empty userId}">
    	  <ul >
	     	<li><a href="#">마이페이지</a></li>
	      	<li><a href="${pageContext.request.contextPath}/front?key=user&methodName=logout">로그아웃</a></li>
	      </ul>	
    	</c:when>
    	<c:otherwise>
    	  <ul >
	     	<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
	      	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/front?key=user&methodName=logout">회원가입</a></li>
	      </ul>	
    	</c:otherwise>
    </c:choose>
    </span>
  </div>
</nav>


<div >
  <div >
   
     
     <!-- 로그인 되면 sessionScope에 loginUser 저장되어있다! -->
     <c:if test="${not empty userId}">
	     <ul >
	     	<li><a href="#">${loginUser.userId}</a></li>
	      	<li><a href="${pageContext.request.contextPath}/front?key=user&methodName=logout">Logout</a></li>
	     </ul>
     </c:if>
  </div>
</div>