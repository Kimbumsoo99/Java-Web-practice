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

<form method="post" action="${path}/front">
<input type="hidden" name="key" value="user">
<input type="hidden" name="methodName" value="join">
<table cellspacing="0" align="center">
   <caption><h2> 회원가입 Form</h2></caption>
  <tr>
	<td width="100px">ID</td>
	<td width="400px"><input type="text" name="userId" /></td>
  </tr>
  <tr>
	<td>PWD</td>
	<td><input type="password" name="pwd" /></td>
  </tr>
  <tr>
	<td>NAME</td>
	<td><input type="text" name="name" /></td>
  </tr>
  <tr>
	<td>age</td>
	<td><input type="text" name="age" /></td>
  </tr>
  <tr>
	<td>Phone</td>
	<td><input type="text" name="phone" /></td>
  </tr>
  <tr>
	<td>Addr</td>
	<td><input type="text" name="addr"  size="50"/></td>
  </tr>
  <tr>
	<td colspan="2" style="text-align: center;background-color: pink">
	<input type="submit" value="가입" />
	<input type="button" value="취소" onclick="history.back()"/>
	</td>
	
  </tr>
  </table> 
</form>
</body>
</html>