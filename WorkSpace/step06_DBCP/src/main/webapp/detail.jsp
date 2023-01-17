<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {border: 5px groove pink; width:500px}
  td,th{border:1px black solid ;  padding:10px}

  input{border:solid 1px gray}
  
</style>
</head>
<body>
<h1 style="text-align: center">${member.name} 회원 상세보기</h1>
<table cellspacing="0" align="center">
  <tr>
	<td width="100px">ID</td>
	<td width="400px">${member.id}</td>
  </tr>
  <tr>
	<td>PWD</td>
	<td>${member.pwd}</td>
  </tr>
  <tr>
	<td>NAME</td>
	<td>${member.name }</td>
  </tr>
  <tr>
	<td>age</td>
	<td>${member.age }</td>
  </tr>
  <tr>
	<td>Phone</td>
	<td>${member.phone }</td>
  </tr>
  <tr>
	<td>Addr</td>
	<td>${member.addr }</td>
  </tr>
    <tr>
	<td>JoinDate</td>
	<td>${member.joinDate}</td>
  </tr>
  <tr>
	<td colspan="2" style="text-align: center;background-color: pink">
	<input type="button" value="메인" onclick="location.href='index.jsp'"/>
	</td>
	
  </tr>
  </table> 
</body>
</html>