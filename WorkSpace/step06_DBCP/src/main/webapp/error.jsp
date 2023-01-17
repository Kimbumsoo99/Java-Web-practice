<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		//alert("${errMsg}");
		//history.back();
	</script>
	<h3>
		Message : "${errMsg}" <br>
		<input type="button" value="뒤로가기" onclick="history.back()">
		<a href="javascript:history.back()">뒤로가기</a>
		<a href="${pageContext.request.contextPath}/index.jsp">메인으로</a>
	</h3>
</body>
</html>