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
	<c:if test="${sessionScope.enr_user_no!=null}">
	<article>
		<div class="container">
		<div class="table-responsive">
		<div class="dropdown">
		<p style="text-align:center;font-size:25px;display:inline;">여신 업무</p>
			  <button class="btn btn-secondary dropdown-toggle float-right" type="button" id="commondrop" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			  중분류
			  </button>
			  <ul id="common" class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			  <c:forEach items="${menuLN}" var="list">
			    <li><a class="dropdown-item" value="001" onClick="loan('${list.middle_cd}')">${list.middle_desc}</a></li>
			  </c:forEach></ul>
			</div>
	<table class="table table-striped table-sm" width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>업무키</td>
			<td>고객번호</td>
			<td>고객이름</td>
			<td>주민번호</td>
			<td>문서코드</td>
			<td>삭제</td>
			<td>담당자</td>
			<td>담당업무코드</td>
<c:if test="${sessionScope.update_grant=='Y'}"><td>수정</td></c:if>	
<c:if test="${sessionScope.delete_grant=='Y'}"><td>삭제</td></c:if>
		</tr>
		<c:forEach items="${listLN}" var="dto">
		<tr>	
			<td><a href="content_view?img_key=${dto.img_key}&doc_cd=${dto.doc_cd}">${dto.img_key}</a></td>
			<td>${dto.cust_no}</td>
			<td>${dto.cust_nm}</td>
			<td>${dto.rrn_no}</td>
			<td>${dto.doc_cd}</td>
			<td>${dto.del_yn}</td>
			<td>${dto.enr_user_id}</td>
			<td>${dto.enr_org_cd}</td>
<c:if test="${sessionScope.update_grant=='Y'}"><td><a href="modify_view?img_key=${dto.img_key}&doc_cd=${dto.doc_cd}">수정 </a></td> </c:if>
<c:if test="${sessionScope.delete_grant=='Y'}"><td><a href="delete?img_key=${dto.img_key}&doc_cd=${dto.doc_cd}">삭제</a></td> </c:if>	
		</tr>
		</c:forEach>
		<tr>
<c:if test="${sessionScope.create_grant=='Y'}"><td colspan="10"><a href="write_view">등록 </a></td></c:if>			
		</tr>
		</table>
		</div>
		<div class="form-group row justify-content-center">
		<input type="date" id="sdate" name="sdate">~<input type="date" id="edate" name="edate">
			<div class="w100" style="padding-right:10px">
				<select class="form-control form-control-sm" name="searchType" id="searchType">
					<option value="img_key">업무키</option>
					<option value="doc_cd">문서코드</option>
				</select>
			</div>
			<div class="w300" style="padding-right:10px">
				<input type="text" class="form-control form-control-sm" name="keyword" id="keyword">
			</div>
			<div>
				<button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">검색</button>
			</div>
		</div>
		<script>
			function fn_prev(page, range, rangeSize, searchType, keyword, sdate,edate) {
				var page = parseInt((range - 2) * rangeSize) + 1;
				var range = parseInt(range) - 1;
				var url = "${pageContext.request.contextPath}/listLN";
				url = url + "?page=" + page;
				url = url + "&range=" + range;
				url = url + "&searchType=" + searchType;
				url = url + "&keyword=" + keyword;
				url = url + "&sdate=" + sdate;
				url = url + "&edate=" + edate;
				location.href = url;
			}
		
			function fn_pagination(page, range, rangeSize, searchType, keyword, sdate,edate) {
				var url = "${pageContext.request.contextPath}/listLN";
				url = url + "?page=" + page;
				url = url + "&range=" + range;
				url = url + "&searchType=" + searchType;
				url = url + "&keyword=" + keyword;
				url = url + "&sdate=" + sdate;
				url = url + "&edate=" + edate;
				location.href = url;	
			}
		
			function fn_next(page, range, rangeSize, searchType, keyword, sdate,edate) {
				var page = parseInt((range * rangeSize)) + 1;
				var range = parseInt(range) + 1;
				var url = "${pageContext.request.contextPath}/listLN";
				url = url + "?page=" + page;
				url = url + "&range=" + range;
				url = url + "&searchType=" + searchType;
				url = url + "&keyword=" + keyword;
				url = url + "&sdate=" + sdate;
				url = url + "&edate=" + edate;
				location.href = url;
			}
			$(document).on('click', '#btnSearch', function(e){
				e.preventDefault();
				var url = "${pageContext.request.contextPath}/listLN";
				url = url + "?searchType=" + $('#searchType').val();
				url = url + "&keyword=" + $('#keyword').val();
				url = url + "&sdate=" + $('#sdate').val();
				url = url + "&edate=" + $('#edate').val();
				location.href = url;
				console.log(url);
			});	
			</script>
		<!-- pagination{s} -->
		<div id="paginationBox">
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}', '${pagination.sdate}', '${pagination.edate}')" >Previous</a></li>
				</c:if>
	
				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
					<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}', '${pagination.sdate}', '${pagination.edate}')"> ${idx} </a></li>
				</c:forEach>
					
				<c:if test="${pagination.next}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}', '${pagination.sdate}', '${pagination.edate}')" >Next</a></li>
				</c:if>
			</ul>
		</div>
		<!-- pagination{e} -->
		</div>
	</article>
	</c:if>
</body>
</html>