<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<html>
<head>
<!-- Bootstrap CSS -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>menu view</title>
</head>
<body>
<c:if test="${sessionScope.enr_user_no!=null}">
<article>
		<div class="container">
		<div class="table-responsive">
	<table class="table table-striped table-sm" cellpadding="0" cellspacing="0" border="1">
		<form method="post" action="write_menu">
		<tr>
			<td>대분류</td>
			<td>코드</td>
			<td>중분류</td>
			<td>코드</td>
			<td>소분류</td>
			<td>코드</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${menu_view}" var="dto">
			<tr>
			    <td><input type="hidden" name="main_desc" 	value="${dto.main_desc}">${dto.main_desc}</td>
				<td><input type="hidden" name="main_cd" 	value="${dto.main_cd}">${dto.main_cd}</td>
			    <td><input type="hidden" name="middle_desc" value="${dto.middle_desc}">${dto.middle_desc}</td>
			    <td><input type="hidden" name="middle_cd" 	value="${dto.middle_cd}">${dto.middle_cd}</td>
			    <td><input type="hidden" name="sub_desc" 	value="${dto.sub_desc}">${dto.sub_desc}</td> 	
			    <td><input type="hidden" name="sub_cd" 		value="${dto.sub_cd}">${dto.sub_cd}</td>
			    <c:if test="${sessionScope.update_grant!='N'}"><td><a href="modify_menu?doc_cd=${dto.doc_cd}">수정 </a></td> </c:if>	
				<c:if test="${sessionScope.delete_grant!='N'}"><td><a href="delete_menu?doc_cd=${dto.doc_cd}">삭제</a></td> </c:if>	
			 </tr>
		</c:forEach>
		
		<tr>
			
		</tr>
		<table class="table table-striped table-sm" width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<c:if test="${sessionScope.create_grant!='N'}"><td>
			<a href="write_menu">분류등록 </a></td> </c:if> 
			</tr></table>
		</form>
		</table>
		</div>
		</div>
	</article>
	</c:if>
</body>
</html>