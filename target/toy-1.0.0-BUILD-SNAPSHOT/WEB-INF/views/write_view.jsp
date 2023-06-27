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
		<form action="write" method="post">
		<tr>
			<td>업무키</td>
			<td>고객번호</td>
			<td>고객이름</td>
			<td>문서코드</td>
			<td>담당자</td>
			<td>담당업무코드</td>
			</tr>
		<tr>
			<td><input type="text" name="img_key"></td>
			<td><input type="text" name="cust_no"></td>
			<td><input type="text" name="cust_nm"></td>
			<td><input type="text" name="doc_cd"></td>
			<td><input type="text" name="enr_user_id"></td>
			<td><input type="text" name="enr_org_cd"></td>
		</tr>
		
		<tr>
			<td colspan="5"><input type="submit" value="신규 등록"> &nbsp;&nbsp; 
		</tr>
		</form>
		</table>
		</div>
		</div>
	</article>
</body>
</html>