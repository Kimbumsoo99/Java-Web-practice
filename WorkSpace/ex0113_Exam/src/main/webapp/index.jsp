<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style type="text/css">
.main {
	float: left;
}

#left {
	border: solid 1px black;
	width: 300px;
	height: 500px;
	font-size: 0;
}

#center {
	width: 900px;
	height: 500px;
	text-align: center;
	font-size: 0;
	border: solid 1px black;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="top.jsp"></jsp:include>
	</header>

	<main>
		<div id="left" class="main">
			<iframe width="300" height="500" src="left.jsp" id="left"></iframe>
		</div>
		<div id="center" class="main">
			<iframe width="900" height="500" src="center.jsp"></iframe>
		</div>
	</main>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>
