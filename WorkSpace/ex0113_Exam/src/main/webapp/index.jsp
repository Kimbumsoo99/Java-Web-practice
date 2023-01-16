<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style type="text/css">
header{ width: 800px; height: 50px ; background-color: skyblue;}
section{width: 800px;height: 400px;}
article{float : left;}
#left{width: 300px; height: 400px;  }
#center{width: 500px; height: 400px;  }
footer{width: 800px;height: 50px;clear: both; background-color: skyblue;}

a {
	text-decoration: none;
}

.topDiv {
	text-align: right; 
	height: 100%;
}
iframe{
 border: 0px;
 width : 100%;
 height: 400px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="top.jsp"></jsp:include>
	</header>

	<section>
		<article id="left"><iframe src="left.jsp" name="left"></iframe></article>
		<article id="center"><iframe src="center.jsp" name="center"></iframe></article>
	</section>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>

</body>
</html>
