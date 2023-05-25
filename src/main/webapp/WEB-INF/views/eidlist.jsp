<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>eid List</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
 			<td>엘리먼트id</td>
			<td>업무키</td>
			<td>고객번호</td>
			<td>고객이름</td>
			<td>문서코드</td>
 			<td>파일명</td>
 			<td>생성일</td>
			<td>담당자</td>
			<td>담당업무코드</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>	
 			<td>${dto.elementid}</td>
			<td>${dto.img_key}</td>
			<td>${dto.cust_no}</td>
			<td>${dto.cust_nm}</td>
			<td>${dto.doc_cd}</td>
 			<td>${dto.file_nm}</td>
			<td>${dto.enr_dtm}</td>
			<td>${dto.enr_user_id}</td>
			<td>${dto.enr_org_cd}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view">등록 </a> &nbsp;&nbsp; <input type="text" class="form-control" placeholder="검색">
			<button type="submit" class="btn btn-default">검색하기</button>
			</td>			
		</tr>
		</table>
</body>
</html>