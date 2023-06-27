<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
	$(document).on('click', '#btnSignup', function(e){
		e.preventDefault();

		$("#form").submit();
	});
	

	function fn_btnCancel(){
		location.href ="${pageContext.request.contextPath}/login";
     }    

</script>

<article>
	<div class="container  col-md-6" role="main">
		<div class="card">
			<div class="card-header">Register</div>
			<div class="card-body">
				<form:form name="form" id="form" class="form-signup" role="form" modelAttribute="userVO" method="post" action="${pageContext.request.contextPath}/insertUser">
					<div class="form-group row">
						<label for="enr_user_no" class="col-md-3 col-form-label text-md-right">사번</label>
						<div class="col-md-5">
							<form:input path="enr_user_no" id="enr_user_no" class="form-control" placeholder="사번을 입력해 주세요" />
						</div>
					</div>
		
					<div class="form-group row">
						<label for="enr_user_id" class="col-md-3 col-form-label text-md-right">이름</label>
						<div class="col-md-5">
							<form:input path="enr_user_id" id="enr_user_id" class="form-control" placeholder="이름을 입력해 주세요" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="enr_user_pw" class="col-md-3 col-form-label text-md-right">비밀번호</label>
						<div class="col-md-5">
							<form:password path="enr_user_pw" id="enr_user_pw" class="form-control" placeholder="비밀번호를 입력해 주세요" />
						</div>
					</div>
					<div class="form-group row">
						<label for="enr_user_re_pwd" class="col-md-3 col-form-label text-md-right">비밀번호 확인</label>
						<div class="col-md-5">
							<form:password path="enr_user_re_pwd" id="enr_user_re_pwd" class="form-control" placeholder="비밀번호를 입력해 주세요" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="enr_user_position" class="col-md-3 col-form-label text-md-right">직책</label>
						<div class="col-md-5">
							<form:input path="enr_user_position" id="enr_user_position" class="form-control" placeholder="직책을 입력해 주세요" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="enr_user_group" class="col-md-3 col-form-label text-md-right">그룹</label>
						<div class="col-md-5">
							<form:input path="enr_user_group" id="enr_user_group" class="form-control" placeholder="그룹을 입력해 주세요" />
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div style="margin-top:10px">
			<button type="button" class="btn btn-sm btn-primary" href="insertUser" id="btnSignup">회원가입</button>
			<button type="button" class="btn btn-sm btn-primary" href="#" onClick="fn_btnCancel()">취소</button>
		</div>
	</div>
	
</article>