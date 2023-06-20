<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- login form {s} -->
<form:form class="form-signin" name="form" id="form" role="form" modelAttribute="userVO" method="post" action="${pageContext.request.contextPath}/list">
	<div class="text-center mb-4">
		<h1 class="h3 mb-3 font-weight-normal">Toy</h1>
	</div>
	
	<div class="form-label-group">
		<form:input path="enr_user_no" id="enr_user_no" class="form-control" placeholder="User ID" required="" autofocus="" />
		<label for="uid" class="sr-only">사번</label>
	</div>
	
	<div class="form-label-group">
		<form:password path="enr_user_pw" id="enr_user_pw" class="form-control" placeholder="User Password" required="" />
		<label for="pwd" class="sr-only">비밀번호</label>
	</div>
	
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	
	<span style="font-size:11pt;">
	<a href="#" onClick="fn_btnSignupClick()">Sign up</a>
	</span>
    
	<script>
		function fn_btnSignupClick(){
			location.href ="${pageContext.request.contextPath}/login/signupForm";
        	}    
	</script>
</form:form>