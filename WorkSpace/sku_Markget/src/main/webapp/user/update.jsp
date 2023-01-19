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
<h1 style="text-align: center">${loginUser.name} 회원 수정</h1>
<form method="post" action="${pageContext.request.contextPath}/front">
<input type="hidden" name="key" value="user"/>
<input type="hidden" name="methodName" value="update"/>
<input type="hidden" name="userId" value="${loginUser.userId}"/>
<input type="hidden" name="userId" value="${loginUser.pwd}"/>

<table cellspacing="0" align="center">
  <tr>
	<td width="100px">ID</td>
	<td width="400px">${loginUser.userId}</td>
  </tr>
  <tr>
	<td>PWD</td>
	<td>${loginUser.pwd}</td>
  </tr>
  <tr>
	<td>NAME</td>
	<td><input type="text" name="name" value="${loginUser.name}"/></td>
  </tr>
  <tr>
	<td>age</td>
	<td><input type="text" name="age" value="${loginUser.age}"/></td>
  </tr>
  <tr>
	<td>Phone</td>
	<td><input type="text" name="phone" value="${loginUser.phone}"/></td>
  </tr>
  <tr>
	<td>Addr</td>
	<td><input type="text" name="addr" value="${loginUser.addr}" size="50"/></td>

  <tr>
	<td colspan="2" style="text-align: center;background-color: pink">
	<input type="submit" value="수정 완료"/>
	<input type="button" value="수정 취소" onclick="history.back()"/>
	</td>
	
  </tr>
  </table> 
  <input type="hidden" name="id" value="${loginUser.userId}">
</form>
</body>
</html>