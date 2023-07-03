<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>write</title>
</head>
<body>
	<article>
		<div class="container  col-md-6" role="main">
		<div class="card">
		<div class="card-header">분류 등록</div>
			<div class="card-body">
		<form action="write_menu_content" method="post">
		<div class="form-group row">
			<label for="main_cd" class="col-md-3 col-form-label text-md-right">대분류 코드</label>
			<div class="col-md-5">
				<input type="text" name="main_cd" id="main_cd" class="form-control" placeholder="대분류 코드" />
			</div>
		</div>		
		<div class="form-group row">
			<label for="main_desc" class="col-md-3 col-form-label text-md-right">대분류 명</label>
			<div class="col-md-5">
				<input type="text" name="main_desc" id="main_desc" class="form-control" placeholder="대분류  명" />
			</div>
		</div>
		<div class="form-group row">
			<label for="middle_cd" class="col-md-3 col-form-label text-md-right">중분류 코드</label>
			<div class="col-md-5">
				<input type="text" name="middle_cd" id="middle_cd" class="form-control" placeholder="중분류 코드" />
			</div>
		</div>
		<div class="form-group row">
			<label for="middle_desc" class="col-md-3 col-form-label text-md-right">중분류 명</label>
			<div class="col-md-5">
				<input type="text" name="middle_desc" id="middle_desc" class="form-control" placeholder="중분류 명" />
			</div>
		</div>
		<div class="form-group row">
			<label for="sub_cd" class="col-md-3 col-form-label text-md-right">소분류 코드</label>
			<div class="col-md-5">
				<input type="text" name="sub_cd" id="sub_cd" class="form-control" placeholder="소분류 코드" />
			</div>
		</div>
		<div class="form-group row">
			<label for="sub_desc" class="col-md-3 col-form-label text-md-right">소분류 명</label>
			<div class="col-md-5">
				<input type="text" name="sub_desc" id="sub_desc" class="form-control" placeholder="소분류 명" />
			</div>
		</div>
		<input type="submit" class="btn btn-dark float-right" value="신규 등록"> 
		</form>
		</div>
		</div>
	</article>
</body>
</html>