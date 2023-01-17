<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border: 5px dobule red
}

th, td {
	padding: 5px;
	border: 1px solid pink;
	text-align: center
}

a {
	text-decoration: none
}
</style>
<script type="text/javascript">
	//호이스팅 개념!!
	function searchInfo(){
		//keyFiled와 keyWord에 값이 있는지 체크한다.
		if(document.search.keyField.value=="3"){
			alert("검색필드를 선택해주세요.");
			document.search.keyField.focus();
			return;
		}
		if(document.search.keyWord.value==""){
			alert("검색단어를 입력하세요.");
			document.search.keyWord.focus();
			return;
		}
		//여기까지 오면 전송한다.
		document.search.submit(); //폼 전송
	}
</script>
</head>

<body>
	<div style="text-align: center;">
		<h1>[ 회원 정보 LIST ]</h1>
		<table cellspacing="0">
			<tr>
				<th colspan="9" style="text-align: right"><a
					href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp; <a
					href="index.jsp">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;</th>
			</tr>
			<tr bgColor="pink">
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
				<th>연락처</th>
				<th>가입일</th>
				<th>삭제</th>
			</tr>
			<c:choose>
				<c:when test="${empty member}">
					<tr>
						<th colspan="9"><b>검색된 정보가 없습니다.</b></th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${member}" var="member" varStatus="state">
						<tr>
							<td>${state.count}</td>
							<td><a href="detail?id=${member.id}">${member.id}</a></td>
							<td>${member.pwd}</td>
							<td>${member.name}</td>
							<td>${member.age}</td>
							<td>${member.addr}</td>
							<td>${member.phone}</td>
							<td>${member.joinDate}</td>
							<td><input type="button" value="삭제" onclick="location.href='delete?id=${member.id}'"></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</table>
		<p>
		<form name="search" action="searchBy" method="post">
			<select name="keyField">
				<!-- <option value="0">--선택--</option>
				<option value="id">아이디</option>
				<option value="name">이름</option>
				<option value="addr">주소</option> -->
				<option value="3">--선택--</option>
				<option value="0">아이디</option>
				<option value="1">이름</option>
				<option value="2">주소</option>
			</select> <input type="text" name="keyWord" /> 
			<input type="button" value="검색" onclick="searchInfo()"/>

		</form>
	</div>
</body>
</html>




