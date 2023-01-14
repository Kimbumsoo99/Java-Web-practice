<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>top</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

#top {
	border: solid 1px black;
	width: 1200px;
	height: 100px;
	text-align: center;
}

.top-banner {
	display: inline-flex;
	justify-content: center;
	align-items: center;
	text-decoration: none;
	font-size: 24px;
	font-weight: bold;
	padding: 30px 50px;
	color: blue;
}
</style>
</head>
<body>
	<div id=top>
		<a href="#" class="top-banner">게시판</a> <a href="#" class="top-banner">MyPage</a>
		<a href="#" class="top-banner">Q&A</a>
	</div>
</body>
</html>