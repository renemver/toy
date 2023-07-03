<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Modify User</title>
</head>
<%
request.setCharacterEncoding("UTF-8"); 
String enr_user_no = request.getParameter("enr_user_no");
%>

<body>
	<c:if test="${sessionScope.enr_user_no!=null}">
	<article>
	<div class="container col-md-6" role="main">
	<div class="card">
	<div class="card-header">유저 수정</div>
	<div class="card-body">
	<form action="modify_user_content" method="post">	
		<input type="hidden" name="enr_user_no" value="<%=enr_user_no%>">
		<div class="form-group row">
			<label for="enr_user_position" class="col-md-3 col-form-label text-md-right">직책</label>
			<div class="col-md-5">
				<input type="text" name="enr_user_position" id="enr_user_position" class="form-control" placeholder="직책" />
			</div>
		</div>		
		<div class="form-group row">
			<label for="enr_user_group" class="col-md-3 col-form-label text-md-right">조직</label>
			<div class="col-md-5">
				<input type="text" name="enr_user_group" id="enr_user_group" class="form-control" placeholder="조직" />
			</div>
		</div>
		<div class="form-group row">
			<label for="create_grant" class="col-md-3 col-form-label text-md-right">생성권한</label>
			<div class="col-md-5">
				<input type="text" name="create_grant" id="create_grant" class="form-control" placeholder="생성권한" />
			</div>
		</div>
		<div class="form-group row">
			<label for="update_grant" class="col-md-3 col-form-label text-md-right">수정권한</label>
			<div class="col-md-5">
				<input type="text" name="update_grant" id="update_grant" class="form-control" placeholder="수정권한" />
			</div>
		</div>
		<div class="form-group row">
			<label for="delete_grant" class="col-md-3 col-form-label text-md-right">삭제권한</label>
			<div class="col-md-5">
				<input type="text" name="delete_grant" id="delete_grant" class="form-control" placeholder="삭제권한" />
			</div>
		</div>		
		<input type="submit" class="btn btn-dark float-right" value="수정"> 
		</form>
		</div>
		</div>
	</article>
		</c:if>
</body>
</html>