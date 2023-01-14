<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>left</title>
</head>
<body>
	<form name="f" action="login" method="post">
	  ID : <input type="text" name="userId" /><br/>
	  PWD : <input type="password" name="userPwd" /><br/>
	 <input type="submit" value="로그인" />
	 <input type="submit" value="취소" />
</form>
</body>
</html>