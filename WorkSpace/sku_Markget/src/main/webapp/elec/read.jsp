<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<jsp:include page="../common/header.jsp"/>
<HEAD>
<link rel="stylesheet" href="css/style.css">
<style type="text/css">
#reply-delete {
	background: white;
	border: white;
	text-align: right;
}
#reply-delete:hover {
	background: silver;
}
</style>
<SCRIPT language=javascript>
function sendUpdate(){
	document.requestForm.methodName.value ="updateForm";
	document.requestForm.submit();
}

function sendDelete(){
	const isDelete = confirm("삭제하시겠습니까?");
	if(isDelete===true){
		const pwd = prompt("비밀번호를 입력해주세요");
		const loginPwd="${loginUser.pwd}"
		if(pwd==loginPwd){
			document.requestForm.methodName.value ="delete";
			document.requestForm.submit();
			return;
		}
		alert("비밀번호가 틀렸습니다");
	}else return;
	
}
function commentUser(){
	const userId="${loginUser.userId}"
	if(userId==="") {
		alert("로그인하고 댓글을 작성해주세요.");
		return;
	}
	document.commentForm.methodName.value="insert";
	document.commentForm.submit();
	
}
function commentDelete(replyContent,replyNum){
	document.commentForm.methodName.value="delete";
	document.commentForm.replyComment.value=replyContent;
	document.commentForm.replyNum.value=replyNum;
	document.commentForm.submit();
}
</script>
</HEAD>

<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
    <tr>
        <td width="1220" height="20" colspan="4" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>
             게시물 자세히보기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">모델번호 </span></b></p>
        </td>
        <td width="300" height="20">
        	<span style="font-size:9pt;"><b>${elec.modelNum}</b></span>
        </td>
        <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">작성자 </span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span style="font-size:9pt;"></span>${requestScope.elec.writeUser}</b></p>
		</td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">등록일 </span></b></p>
        </td>
        <td width="300" height="20">
        	<span style="font-size:9pt;"><b>${requestScope.elec.writeday}</b></span>
        </td>
        <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">조회수 </span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span style="font-size:9pt;"></span>${requestScope.elec.readnum}</b></p>
		</td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">모델이름 </span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${requestScope.elec.modelName}</b></span>
        </td>
    </tr>
    <tr>
		<td width="100" height="200" valign="top">
            <p align="right"><b><span style="font-size:9pt;">설명 </span></b></p>
        </td>
		<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td width="450" height="200" valign="top" colspan="3">
        <span style="font-size:9pt;"><b><pre>${requestScope.elec.description}</pre></b></span></td>
    </tr>
    
      <c:if test="${elec.fname!=null}">
       <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">다운로드 </span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>
        	<a href='${path}/downLoad?fname=${elec.fname}'>
    			${elec.fname} 
      		</a>
      		  ( <fmt:formatNumber value="${elec.fsize}"/> byte)
        </b></span>
        </td> 
    </tr>
    </c:if>

	<c:if test="${elec.writeUser eq loginUser.userId}">
    <form name="requestForm" method=post action="${path}/front">
    <tr>
        <td height="20" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<input type=hidden name="modelNum" value="${elec.modelNum}"/>
				<input type=hidden name="key" value="elec"/>
				<input type=hidden name="methodName"/>
				<input type=button value="수정하기" onClick="sendUpdate()">
				<input type=button value="삭제하기" onClick="sendDelete()">
			
		</td>
    </tr>
    </form>
			</c:if>
</table>
<hr>

<form name="commentForm" method=post action="${path}/front">
 <h4> 댓글정보 LIST </h4>
 <textarea name="replyContent" style="width: 100%" name="reply" cols="" rows="4" placeholder="댓글을 입력하세요.(200자이내)"></textarea>
 <input type="button" value="등록" style="width: 10%;height: 30px;border-radius: 10%;" onclick="commentUser()"/><p>
 <input type="hidden" name="key" value="reply"/>
 <input type="hidden" name="replyWriteUser" value="${loginUser.userId}"/>
 <input type="hidden" name="modelNum" value="${elec.modelNum}"/>

 
 <hr color="red">
 <c:choose>
   <c:when test="${empty elec.repliesList}">
        댓글정보가 없습니다.
   </c:when>
   <c:otherwise>

   
       <c:forEach items="${elec.repliesList}" var="reply">
			<table cellpadding="5" cellspacing="2" width="100%" border='0'>
				<tr>
					<td width="20%" height="30" colspan="3">
						<p align="right"  margin=0>
							<font color="black" size="3"><b>
							<c:if test="${reply.replyWriteUser eq elec.writeUser}">(작성자)</c:if>
									${reply.replyWriteUser} : </b></font>
						</p>
					</td>
					<td width="80%" height="40" colspan="1" rowspan="2">
						<p align="left">
							<font color="black" size="3"><b> &nbsp;&nbsp;
									${reply.replyContent} </b></font>
						</p>
						<div style="text-align: right;">
						<c:if test="${reply.replyWriteUser eq loginUser.userId}"><input id="reply-delete" type="button" value="❌" onclick="commentDelete('${reply.replyContent}','${reply.replyNum}')" ></c:if></div>
					</td>
				</tr>
				<tr>
					<td width="20%" height="5" colspan="3">
						<p align="right">
							<font color="gray" size="2px"><b> ${reply.replyRegdate}</b></font>
						</p>
					</td>
				</tr>
			</table>
          	<hr>
       </c:forEach>
   </c:otherwise>
 </c:choose>
<!-- ${reply.replyNum} / ${reply.replyContent} / ${reply.replyRegdate}<br> -->
<input type="hidden" name="methodName" value="">
<input type="hidden" name="replyComment" value="">
<input type="hidden" name="replyNum" value="">
</form>
<jsp:include page="../common/footer.jsp"/>






