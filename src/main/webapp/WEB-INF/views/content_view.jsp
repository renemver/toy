<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<html>
<head>
<!-- Bootstrap CSS -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>content view</title>
</head>
<body>
<article>
		<div class="container">
		<div class="table-responsive">
	<table class="table table-striped table-sm" width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write_content" method="post" enctype="multipart/form-data">
		<tr>
			<td></td>>
			<td>eid</td>
			<td>업무키</td>
			<td>고객번호</td>
			<td>고객이름</td>
			<td>문서코드</td>
			<td>파일명</td>
			<td>등록날짜</td>
			<td>담당자</td>
			<td>담당업무코드</td>
			<td>삭제코드</td>		
		</tr>
		<c:forEach items="${content_view}" var="dto">
			<tr>
				<td><input type="checkbox" name="ck" value="${dto.elementid}"></td>
				<td><input type="hidden" name="elementid" value="${dto.elementid}">${dto.elementid}</td>
			    <td><input type="hidden" name="img_key" value="${dto.img_key}">${dto.img_key}</td>
			    <td><input type="hidden" name="cust_no" value="${dto.cust_no}">${dto.cust_no}</td>
			    <td><input type="hidden" name="cust_nm" value="${dto.cust_nm}">${dto.cust_nm}</td>
			    <td><input type="hidden" name="doc_cd" value="${dto.doc_cd}">${dto.doc_cd}</td>
			    <td><input type="hidden" name="file_nm" value="${dto.file_nm}">${dto.file_nm}</td>
			    <td><input type="hidden" name="enr_dtm" value="${dto.enr_dtm}">${dto.enr_dtm}</td>
			    <td><input type="hidden" name="enr_user_id" value="${dto.enr_user_id}">${dto.enr_user_id}</td>
			    <td><input type="hidden" name="enr_org_cd" value="${dto.enr_org_cd}">${dto.enr_org_cd}</td>
			    <td><input type="hidden" name="del_yn" value="${dto.del_yn}">${dto.del_yn}</td>
			    		
			 </tr>
		</c:forEach>
		
		<tr>
			파일 선택 : <input type="file" multiple="multiple" name="file">				
			<td colspan="5"><input type="submit" value="이미지등록">
			<td colspan="5"><input type="submit" value="수정"> &nbsp;&nbsp;  
			<a href="list">목록으로</a> &nbsp;&nbsp;
			<a href="delete?elementid=${dto.elementid}">삭제</a>
			</td>
		</tr>
		</form>
		</table>
		</div>
		</div>
	</article>
</body>
</html>