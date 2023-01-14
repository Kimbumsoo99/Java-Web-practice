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
	<c:choose>
		<c:when test="${empty sessionScope.userId}">
			<form action="login" method="post">
				ID : <input type="text" name="userId" /><br /> PWD : <input
					type="password" name="userPwd" /><br /> <input type="submit"
					value="로그인" /> <input type="submit" value="취소" />
			</form>
			<script>
				//window.parent.location.reload();
				//window.parent.location.href = index.jsp;
			</script>
		</c:when>
		<c:otherwise>
			<p>${sessionScope.userId}님로그인중</p>
			<p>
				[접속시간 : ${sessionScope.date}<br />${time}]</p>
			<a href="logout">로그아웃</a>
		</c:otherwise>
	</c:choose>

</body>
</html>