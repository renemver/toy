<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
로그인
<script>
	function fn_btnSignupClick(){
		location.href ="${pageContext.request.contextPath}/login/signupForm";
     }    
	</script>
</head>
<body>
<div class="modal-header"><h5 class="modal-title" id="loginmodallabel">로그인</h5>
<button type="button" class="close" data-dismiss="modal" aria-labe="Close"><span aria-hidden="true">&times;</span></button>
<div class="modal-body">
<!-- login form {s} -->
<form:form class="form-signin" name="form1" id="form1" role="form" modelAttribute="userVO" action="loginCheck.do" method="post">
	<div class="text-center mb-4">
		<h1 class="h3 mb-3 font-weight-normal">Toy</h1>
	</div>
	
	<div class="form-label-group">
		<form:input path="enr_user_no" id="enr_user_no" name="enr_user_no" class="form-control" placeholder="사번" required="" autofocus="" />
		<label for="uid" class="sr-only">사번</label>
	</div>
	
	<div class="form-label-group">
		<form:password path="enr_user_pw" id="enr_user_pw" name="enr_user_pw" class="form-control" placeholder="비밀번호" required="" />
		<label for="pwd" class="sr-only">비밀번호</label>
	</div>
	<button type="submit" class="btn btn-sm btn-primary" >로그인</button>
	<button type="button" class="btn btn-sm btn-primary" href="#" onClick="fn_btnSignupClick()">가입</button>
	
</form:form>
</div><div class="modal-footer"></div>
</body></html>