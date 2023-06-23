<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<html>
<head>
<!-- Bootstrap CSS -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Board List</title>
</head>
<body>
<c:if test="${msg=='success'}">
<h2>
	${sessionScope.enr_user_no}(${sessionScope.enr_user_id})님 로그인  
</h2>
</c:if>
<c:if test="${msg=='failure'}">
<h2>로그인 실패</h2>
</c:if>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
