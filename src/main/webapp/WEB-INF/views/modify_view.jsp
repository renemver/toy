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
%>
<body>
	<article>
		<div class="container">
		<div class="table-responsive">
	<table class="table table-striped table-sm" width="700" cellpadding="0" cellspacing="0" border="1">
		<form action="modify" method="post">
		<tr>
			<td>고객번호</td>
			<td>고객이름</td>
			<td>문서코드</td>
			<td>담당자</td>
			<td>담당업무코드</td>
			<td>주민번호</td>
			</tr>
		<tr>
			<input type="hidden" name="img_key" value="<%=img_key%>">
			<td><input type="text" name="cust_no"></td>
			<td><input type="text" name="cust_nm"></td>
			<td><input type="text" name="doc_cd"></td>
			<td><input type="text" name="enr_user_id"></td>
			<td><input type="text" name="enr_org_cd"></td>
			<td><input type="text" name="rrn_no"></td>
		</tr>
		
		<tr>
			<td colspan="6"><input type="submit" value="수정"> 
		</tr>
		</form>
		</table>
		</div>
		</div>
	</article>
</body>
</html>