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
		<div class="container">
		<div class="table-responsive">
	<table class="table table-striped table-sm" width="700" cellpadding="0" cellspacing="0" border="1">
		<form action="modify_user_content" method="post">
		<tr>
			<td>직책</td>
			<td>조직</td>
			<td>생성권한</td>
			<td>수정권한</td>
			<td>삭제권한</td>
			</tr>
		<tr>
			<input type="hidden" name="enr_user_no" value="<%=enr_user_no%>">
			<td><input type="text" name="enr_user_position"></td>
			<td><input type="text" name="enr_user_group"></td>
			<td><input type="text" name="create_grant"></td>
			<td><input type="text" name="update_grant"></td>
			<td><input type="text" name="delete_grant"></td>
		</tr>
		<tr>
			<td colspan="7"><input type="submit" value="수정"> </td>
		</tr>
		</form>
		</table>
		</div>
		</div>
	</article>
		</c:if>
</body>
</html>