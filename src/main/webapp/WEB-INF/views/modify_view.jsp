<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>modify</title>
</head>
<%
request.setCharacterEncoding("UTF-8"); 
String img_key = request.getParameter("img_key");
String p_doc_cd = request.getParameter("doc_cd");
%>
<body>
	<article>
		<div class="container  col-md-6" role="main">
		<div class="card">
		<div class="card-header">업무 수정</div>
			<div class="card-body">
		<form action="modify" method="post">
			<input type="hidden" name="img_key" value="<%=img_key%>">
			<input type="hidden" name="p_doc_cd" value="<%=p_doc_cd%>">
		<div class="form-group row">
			<label for="cust_no" class="col-md-3 col-form-label text-md-right">고객번호</label>
			<div class="col-md-5">
				<input type="text" name="cust_no" id="cust_no" class="form-control" placeholder="고객번호" />
			</div>
		</div>		
		<div class="form-group row">
			<label for="cust_nm" class="col-md-3 col-form-label text-md-right">고객이름</label>
			<div class="col-md-5">
				<input type="text" name="cust_nm" id="cust_nm" class="form-control" placeholder="고객이름" />
			</div>
		</div>
		<div class="form-group row">
			<label for="doc_cd" class="col-md-3 col-form-label text-md-right">문서코드</label>
			<div class="col-md-5">
				<input type="text" name="doc_cd" id="doc_cd" class="form-control" placeholder="<%=p_doc_cd%>" />
			</div>
		</div>
		<div class="form-group row">
			<label for="rrn_no" class="col-md-3 col-form-label text-md-right">주민번호</label>
			<div class="col-md-5">
				<input type="text" name="rrn_no" id="rrn_no" class="form-control" placeholder="주민번호" />
			</div>
		</div>
		<div class="form-group row">
			<label for="enr_user_id" class="col-md-3 col-form-label text-md-right">담당자</label>
			<div class="col-md-5">
				<input type="text" name="enr_user_id" id="enr_user_id" class="form-control" placeholder="담당자" />
			</div>
		</div>
		<div class="form-group row">
			<label for="enr_org_cd" class="col-md-3 col-form-label text-md-right">담당업무코드</label>
			<div class="col-md-5">
				<input type="text" name="enr_org_cd" id="enr_org_cd" class="form-control" placeholder="담당업무코드" />
			</div>
		</div>
		<input type="submit" class="btn btn-dark float-right" value="수정"> 
		</form>
		</div>
		</div>
		</div>
	</article>
</body>
</html>