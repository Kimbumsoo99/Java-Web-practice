
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="${path}/css/style.css">
<style>
@import url("https://fonts.googleapis.com/css?family=Roboto:400,300");

body {
	color: #2c3e50;
	font-family: 'Roboto', sans-serif;
	font-weight: 400;
}

h1 {
	text-align: center;
	font-size: 2.5rem;
	font-weight: 300;
}

.pagination-container {
	margin: 100px auto;
	text-align: center;
}

.pagination {
	position: relative;
}

.pagination a {
	position: relative;
	display: inline-block;
	color: #2c3e50;
	text-decoration: none;
	font-size: 1.2rem;
	padding: 8px 16px 10px;
}

.pagination a:before {
	z-index: -1;
	position: absolute;
	height: 100%;
	width: 100%;
	content: "";
	top: 0;
	left: 0;
	background-color: #2c3e50;
	border-radius: 24px;
	-webkit-transform: scale(0);
	transform: scale(0);
	transition: all 0.2s;
}

.pagination a:hover, .pagination a .pagination-active {
	color: #fff;
}

.pagination a:hover:before, .pagination a .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination .pagination-active {
	color: #fff;
}

.pagination .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination-newer {
	margin-right: 50px;
}

.pagination-older {
	margin-left: 50px;
}

img {
	width: 200px;
	height: 350px
}

table td {
	text-align: center;
}
tr{
	height: 50px;
}
img{width:200px; height:350px}
</style>

<jsp:include page="../common/header.jsp"/>



<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<caption><h2 align="center">상품(Electronic) LIST</h2></caption>
	<colgroup>
		<col width="8%"/>
		<col width="30%"/>
		<col width="16%"/>
		<col width="16%"/>
		<col width="7%"/>
		<col width="14%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:13pt;">글번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:13pt;">상품이름</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:13pt;">가격</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:13pt;">날짜</span></b></font></p>
        </td>
        
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:13pt;">첨부파일</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:13pt;">작성자</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:13pt;">조 회 수</span></b></font></p>
        </td>
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:12pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="elecDto" varStatus="state">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:12pt;">
		            ${state.count}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:12pt;">
					<a href="${path}/front?key=elec&methodName=selectByModelNum&modelNum=${elecDto.modelNum}&pageNo=${pageNo}">
					  ${elecDto.modelName}
					</a>
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:12pt;">
		            <fmt:formatNumber value="${elecDto.price}"/></span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:12pt;">
		            ${elecDto.writeday}</span></p>
		        </td>
		        <c:choose>
		         <c:when test="${empty elecDto.fname}">
		          <td bgcolor="">
		            <p align="center"><span style="font-size:12pt;">
		            ❌ </span></p>
		          </td>
		         </c:when>
		         <c:otherwise>
		          <td bgcolor="">
		            <p align="center"><span style="font-size:12pt;">
		            ⭕ </span></p>
		          </td>
		         </c:otherwise>
		        </c:choose>
		         
		         <td bgcolor="">
		            <p align="center"><span style="font-size:12pt;">
		            ${elecDto.writeUser}님</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:12pt;">
		            ${elecDto.readnum}</span></p>
		        </td>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>
<c:if test="${not empty sessionScope.loginUser}">
  <span style="font-size:12pt;">&lt;<a href="${path}/elec/write.jsp">글쓰기</a>&gt;</span>
</c:if>
</div>
<hr color="red">
<jsp:include page="../common/footer.jsp"/>






























