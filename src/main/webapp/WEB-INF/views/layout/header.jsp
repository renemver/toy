<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

<!-- Bootstrap CSS -->
<script src="/node_modules/jquery/dist/jquery.min.js"></script>
<link rel="stylesheet" href="/node_modules/bootstrap/dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/node_modules/font-awesome/css/font-awesome.min.css"/>
<script src="/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
  
<!-- common CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/common/css/common.css">

<!--메뉴바 추가 부분-->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav navbar-dark">
		<div class="modal fade" role="dialog" id="loginmodal" tabindex="-1" aria-labelledby="loginmodallabel" aria-hidden="true">
<div class="modal-dialog"><div class="modal-content">
<div class="modal-header">

<h5 class="modal-title" id="loginmodallabel"></h5>
<div class="modal-body">
<!-- login form {s} -->
<form class="form-signin" name="form1" id="form1" role="form" modelAttribute="userVO" action="login/loginCheck.do" method="post">
	<div class="text-center mb-4">
		<h1 class="h3 mb-3 font-weight-normal">로그인</h1>
	</div>
	
	<div class="form-label-group">
		<label for="uid" class="sr-only">사번</label>
		<input type="text" id="enr_user_no" name="enr_user_no" class="form-control" placeholder="사번" required="" autofocus="" />
	</div>
	
	<div class="form-label-group">
		<label for="pwd" class="sr-only">비밀번호</label>
		<input type="password id="enr_user_pw" name="enr_user_pw" class="form-control" placeholder="비밀번호" required="" />
	</div>
	<div class="form-label-group">
	<button type="submit" class="btn btn-dark float-right" >로그인</button>
	<button type="button" class="btn btn-dark" href="#" onClick="fn_btnSignupClick()">가입</button>
	</div>
	
</form>
</div><div class="modal-footer">
<button type="button" class="close" data-dismiss="modal" aria-labe="Close"><span aria-hidden="true">&times;</span></button>
</div></div></div></div></div>
		<li class="nav-item dropdown">
			<a class="nav-link" href="/toy">Toy</a>
		</li>
		<c:if test="${sessionScope.enr_user_no!=null}">
		<!-- 드롭다운 메뉴-->
            <div class="dropdown">
			  <button class="btn btn-dark float-right" type="button" id="codrop" onClick="common('')" aria-haspopup="true" aria-expanded="false">
			    공통
			  </button>
			</div>
			
			<div class="dropdown">
			  <button class="btn btn-dark float-right" type="button" id="dpdrop" onClick="deposit('')" aria-haspopup="true" aria-expanded="false">
			     수신
			  </button>
			</div>
			
			<div class="dropdown">
			  <button class="btn btn-dark float-right" type="button" id="lndrop" onClick="loan('')" aria-haspopup="true" aria-expanded="false">
			    여신
			  </button>
			</div>
	</ul>
	<button class="btn btn-dark float-right" type="button href="#" onClick="fn_btnuserList()">유저목록</button>
		<button class="btn btn-dark float-right" type="button href="#" onClick="fn_btnmenuview()">분류목록</button>
		</c:if>
		<c:choose>
			<c:when test="${sessionScope.enr_user_no==null}">
			<button type="button" class="btn btn-dark float-right" data-toggle="modal" data-target="#loginmodal">로그인</button>
			</c:when>
			<c:otherwise><a class="float-right"href="${pageContext.request.contextPath}/login/logout.do">로그아웃</a></c:otherwise>
		</c:choose>
</nav>

	<script>
		function common(element) {
			var url = "${pageContext.request.contextPath}/listCO";
			url = url + "?element=" + element;
			location.href = url;
		}
		function deposit(element) {
			var url = "${pageContext.request.contextPath}/listDP";
			url = url + "?element=" + element;
			location.href = url;
		}
		function loan(element) {
			var url = "${pageContext.request.contextPath}/listLN";
			url = url + "?element=" + element;
			location.href = url;
		}
		function fn_btnuserList(){
			location.href ="${pageContext.request.contextPath}/userList";
        }    
		function fn_btnmenuview(){
			location.href ="${pageContext.request.contextPath}/menu_view";
        }  
		function openloginmodal(){
	<!--		location.href ="${pageContext.request.contextPath}/login/login";-->
			$('.modal-content').load("login/login");
	<!--		$('loginmodal').modal();-->
	     }    

		function fn_btnSignupClick(){
			location.href ="${pageContext.request.contextPath}/login/signupForm";
	     }  
	</script>
    