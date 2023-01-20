<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 50%;
	font-size: 20px;
}

td, th {
	border: 1px black solid;
	padding: 30px 10px;
}

.updateInput {
	font-size: 20px;
	border: solid 1px gray
}
</style>
</head>
<body>

<form method="post" action="${path}/front">
<input type="hidden" name="key" value="user">
<input type="hidden" name="methodName" value="join">
<table cellspacing="0" align="center">
   <caption><h2> 회원가입 Form</h2></caption>
   <tr>
	<td colspan="2" width="500px" style="text-align: center;background: skyblue">회원 정보</td>
</tr>
  <tr>
	<td width="100px">ID</td>
	<td width="400px"><input class="updateInput" type="text" name="userId" /></td>
  </tr>
  <tr>
	<td>PWD</td>
	<td><input class="updateInput" type="password" name="pwd" /></td>
  </tr>
  <tr>
	<td>NAME</td>
	<td><input class="updateInput" type="text" name="name" /></td>
  </tr>
  <tr>
	<td>age</td>
	<td><input class="updateInput" type="text" name="age" /></td>
  </tr>
  <tr>
	<td>Phone</td>
	<td><input class="updateInput" type="text" name="phone" /></td>
  </tr>
  <tr>
	<td>Addr</td>
	<td><input class="updateInput" type="text" name="addr"  size="50"/></td>
  </tr>
  <tr>
	<td colspan="2" style="text-align: center;background-color: skyblue">
	<input type="submit" value="가입" />
	<input type="button" value="취소" onclick="history.back()"/>
	</td>
	
  </tr>
  </table> 
</form>
</body>
</html>