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
		<div class="container">
		<div class="table-responsive">
	<table class="table table-striped table-sm" width="700" cellpadding="0" cellspacing="0" border="1">
		<form action="write_menu_content" method="post">
		<tr>
			<td>대분류 코드</td>
			<td>대분류 명</td>
			<td>중분류 코드</td>
			<td>중분류 명</td>
			<td>소분류 코드</td>
			<td>소분류 명</td>
			</tr>
		<tr>
			<td><input type="text" name="main_cd"></td>
			<td><input type="text" name="main_desc"></td>
			<td><input type="text" name="middle_cd"></td>
			<td><input type="text" name="middle_desc"></td>
			<td><input type="text" name="sub_cd"></td>
			<td><input type="text" name="sub_desc"></td>
		</tr>
		
		<tr>
			<td colspan="6"><input type="submit" value="신규 등록"> &nbsp;&nbsp; 
		</tr>
		</form>
		</table>
		</div>
		</div>
	</article>
</body>
</html>