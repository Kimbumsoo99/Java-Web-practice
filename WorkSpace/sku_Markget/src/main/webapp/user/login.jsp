<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp"/>
<div class="jumbotron">
	<h1>Login</h1>
	<p>Login, AOP/HttpSession</p>
	<p>
		<a class="btn btn-primary btn-lg" href="${path}/user/update.jsp">수정하기</a>
	</p>
</div>

<c:choose>
	<c:when test="${empty loginUser}">
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/front">
			<input type="hidden" name="key" value = "user" /> <!-- Controller를 찾는 정보 -->
			<input type="hidden" name="methodName" value = "login" />  <!-- 메소드이름 -->
			<fieldset>
				<legend>Login</legend>
				<div class="form-group">
					<label for="userId" class="col-lg-2 control-label">User Id</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="userId" name="userId"
							placeholder="userId">
					</div>
				</div>
				<div class="form-group">
					<label for="pwd" class="col-lg-2 control-label">Password</label>
					.<div class="col-lg-10">
						<input type="password" class="form-control" id="pwd" name="pwd"
							placeholder="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button class="btn btn-default">Cancel</button>
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>
			</fieldset>
		</form>
	</c:when>
	<c:otherwise>
			<legend>Login</legend>
			<blockquote>
				<p>My Shopping Mall!</p>

				<div class="alert alert-dismissible alert-warning">
					<p>
						<a href="#" class="alert-link">${loginName}님의 즐겨찾기 입니다.</a>
					</p>
					<p>
						<a href="#" class="alert-link">${loginName}님의 즐겨찾기 입니다.</a>
					</p>
					<p>
						<a href="#" class="alert-link">${loginName}님의 즐겨찾기 입니다.</a>
					</p>
					<p>
						<a href="#" class="alert-link">${loginName}님의 즐겨찾기 입니다.</a>
					</p>
				</div>
			</blockquote>
	</c:otherwise>
</c:choose>

<jsp:include page="../common/footer.jsp"/>

