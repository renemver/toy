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
<c:if test="${sessionScope.enr_user_no!=null}">
<article>
		<div class="container">
		<div class="table-responsive">
	<table class="table table-striped table-sm" cellpadding="0" cellspacing="0" border="1">
		<form method="post" action="write_content" enctype="multipart/form-data">
		<tr>
			<td>선택</td>
			<td>Elementid</td>
			<td>업무키</td>
			<td>고객번호</td>
			<td>고객이름</td>
			<td>문서코드</td>
			<td>파일명</td>
			<td>등록날짜</td>
			<td>담당자</td>
			<td>담당업무코드</td>
			<td>삭제코드</td>
			<td>보기</td>
		</tr>
		<c:forEach items="${content_view}" var="dto">
			<tr>
				<td><input type="checkbox" name="checkbox" value="${dto.elementid}" onclick='checkOnlyOne(this)'></td>
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
			    <td><a href="display?elementid=${dto.elementid}?file_nm=${dto.file_nm}">보기</a></td>		    		
			 </tr>
		</c:forEach>
		
		<tr>
			<script>
				function checkOnlyOne(element) { 
				  const checkboxes = document.getElementsByName("checkbox");
				  
				  checkboxes.forEach((checkbox) =>{
					  checkbox.checked = false;
				  })
				  
				  element.checked = true;
				}
				function submit2(frm) { 
			    	frm.action='modify_content'; 
			    	frm.enctype="multipart/form-data";
			    	frm.submit(); 
			    	return true; 
				} 
				function submit3(frm) { 
			    	frm.action='delete_content'; 
			    	frm.submit(); 
			    	return true; 
				} 
				function submit4(frm) { 
			    	frm.action='download_content'; 
			    	frm.submit(); 
			    	return true; 
				} 
			</script>
		</tr>
		<table class="table table-striped table-sm" width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td><c:if test="${sessionScope.create_grant!='N'}">등록 파일 선택 : <input type="file" multiple="multiple" name="file"
			accept=".hwp, .doc, .docx, .ppt, .pptx, .xls, .xlsx, .tif, .jpg, .png, .bmp, .pdf">
			<input type="submit" value="이미지등록" ></c:if> </td> 
			
			<td><c:if test="${sessionScope.update_grant!='N'}">변경 파일 선택 : <input type="file" name="replace_file" 
			accept=".hwp, .doc, .docx, .ppt, .pptx, .xls, .xlsx, .tif, .jpg, .png, .bmp, .pdf">
			<input type="submit" value="이미지변경" onclick='return submit2(this.form);'> </c:if></td> 
			
			<td><c:if test="${sessionScope.delete_grant!='N'}">
			<input type="submit" value="삭제" onclick='return submit3(this.form);'></c:if></td>
			<td><input type="submit" value="다운로드" onclick='return submit4(this.form);'></td>
			</tr></table>
		</form>
		</table>
		</div>
		</div>
	</article>
	</c:if>
</body>
</html>