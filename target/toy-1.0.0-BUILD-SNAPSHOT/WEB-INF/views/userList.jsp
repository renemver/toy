<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<html>
<head>
<!-- Bootstrap CSS -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Board List</title>
</head>
<script>
</script>
 
<body>
<c:if test="${sessionScope.enr_user_no!=null}">
<article>
	<div class="container">
		<h2>User list</h2>
		
		<div class="table-responsive">
			<table class="table table-striped table-sm" width="500" cellpadding="0" cellspacing="0" border="1">
				<colgroup>
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:auto;" />
					<col style="width:auto;" />
				</colgroup>
				<thead>
					<tr>
						<th>USER NO</th>
						<th>USER ID</th>
						<th>직책</th>
						<th>그룹</th>
						<th>생성권한</th>
						<th>수정권한</th>
						<th>삭제권한</th>
<c:if test="${sessionScope.update_grant=='Y'}"><th>수정</th></c:if>
<c:if test="${sessionScope.delete_grant=='Y'}"><th>삭제</th></c:if>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty userList }" >
							<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
						</c:when> 
						<c:when test="${!empty userList}">
							<c:forEach var="dto" items="${userList}">
								<tr>
									<td><c:out value="${dto.enr_user_no}"/></td>
									<td><c:out value="${dto.enr_user_id}"/></td>
									<td><c:out value="${dto.enr_user_position}"/></td>
									<td><c:out value="${dto.enr_user_group}"/></td>
									<td><c:out value="${dto.create_grant}"/></td>
									<td><c:out value="${dto.update_grant}"/></td>
									<td><c:out value="${dto.delete_grant}"/></td>
	<c:if test="${sessionScope.update_grant=='Y'}"><td><a href="modify_user?enr_user_no=${dto.enr_user_no}">수정 </a></td> </c:if>	
	<c:if test="${sessionScope.delete_grant=='Y'}"><td><a href="deleteUser?enr_user_no=${dto.enr_user_no}">삭제</a></td> </c:if>	
			 
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>					
				</tbody>
			</table>
		</div>
		<div>
		</div>
	</div>
</article>
</c:if>
</body>