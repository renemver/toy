<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	$(document).on('click', '#btnSearch', function(e){
		e.preventDefault();
		var url = "${getBoardListURL}";
		url = url + "?searchType=" + $('#searchType').val();
		url = url + "&keyword=" + $('#keyword').val();
		console.log(url);
		location.href = url;
		
	});
		
	function fn_prev(page, range, rangeSize, searchType, keyword) {
		
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		
		var url = "${pageContext.request.contextPath}/userList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&searchType=" + searchType;
		url = url + "&keyword=" + keyword;
		
		location.href = url;
	}

	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		var url = "${pageContext.request.contextPath}/userList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&searchType=" + searchType;
		url = url + "&keyword=" + keyword;
		console.log(url);
		location.href = url;
		
	}
	
	function fn_next(page, range, rangeSize, searchType, keyword) {
		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		
		var url = "${pageContext.request.contextPath}/userList";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		url = url + "&searchType=" + searchType;
		url = url + "&keyword=" + keyword;
		
		location.href = url;
	}
	
</script>
 
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
						<th>읽기권한</th>
						<th>수정권한</th>
						<th>삭제권한</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty userList }" >
							<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
						</c:when> 
						<c:when test="${!empty userList}">
							<c:forEach var="list" items="${userList}">
								<tr>
									<td><c:out value="${list.enr_user_no}"/></td>
									<td><c:out value="${list.enr_user_id}"/></td>
									<td><c:out value="${list.enr_user_position}"/></td>
									<td><c:out value="${list.enr_user_group}"/></td>
									<td><c:out value="${list.create_grant}"/></td>
									<td><c:out value="${list.read_grant}"/></td>
									<td><c:out value="${list.update_grant}"/></td>
									<td><c:out value="${list.delete_grant}"/></td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div>
		<a href="list">목록으로</td>
		</div>
		<!-- pagination{s} -->
		<!-- 
		<div id="paginationBox">
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}')">Previous</a></li>
				</c:if>
				
				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
					<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}' )"> ${idx} </a></li>
				</c:forEach>
				
				<c:if test="${pagination.next}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.searchType}', '${pagination.keyword}')">Next</a></li>
				</c:if>
			</ul>
		</div>
 -->
		<!-- pagination{e} -->
		<!-- search{s} -->
		<!-- 
		<div class="form-group row justify-content-center">
			<div style="padding-right:10px">
				<select class="form-control form-control-sm" name="searchType" id="searchType">
					<option value="enr_user_id" <c:if test="${pagination.searchType eq 'enr_user_id'}">selected</c:if> >사번</option>
					<option value="enr_user_no" <c:if test="${pagination.searchType eq 'enr_user_no'}">selected</c:if>>이름</option>
				</select>
			</div>
			<div style="padding-right:10px">
				<input type="text" class="form-control form-control-sm" name="keyword" id="keyword" value="${pagination.keyword}">
			</div>
			<div>
				<button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">검색</button>
			</div>
		</div>
 -->
		<!-- search{e} -->
	</div>
</article>