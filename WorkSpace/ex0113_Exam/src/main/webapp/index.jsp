<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style type="text/css">
*{
margin: 0px;
}
header{ width: 800px; height: 50px ; background-color: skyblue; border: solid 1px black;}
section{width: 800px;height: 400px;}
article{float : left;border: solid 1px black;}
#left{width: 298px; height: 400px; background-color: orange;  }
#center{width: 499px; height: 400px;  }
footer{width: 800px;height: 50px;clear: both; background-color: skyblue;border: solid 1px black;}

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
