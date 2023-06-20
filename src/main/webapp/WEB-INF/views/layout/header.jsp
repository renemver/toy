<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		<li class="nav-item dropdown">
			<a class="nav-link">Toy</a>
		</li>
		<!-- 드롭다운 메뉴-->
			<form action="listCO" method="post">
			<input type="hidden" name="httpMethod" id="httpMethod" value="">
            <div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" id="commondrop" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    공통
			  </button>
			  <ul id="common" class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			    <li><a class="dropdown-item" value="001" onClick="common('001')">전표</a></li>
			    <li><a class="dropdown-item" value="003" onClick="common('003')">증빙서류</a></li>
			  </ul>
			</div>
			</form>
			
			<div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			     수신
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			  		<a class="dropdown-item" value="001" onClick="deposite('001')">거래 신청서</a>
			    	<a class="dropdown-item" value="002" onClick="deposite('002')">예금잔액증명 의뢰서</a>
			    	<a class="dropdown-item" value="003" onClick="deposite('003')">위임장</a>
			    	<a class="dropdown-item" value="004" onClick="deposite('004')">정기예금 월 이자 자동이체 신청서</a>
			    	<a class="dropdown-item" value="005" onClick="deposite('005')">제신고 및 재발급 신청서</a>
			    	<a class="dropdown-item" value="006" onClick="deposite('006')">전자금융서비스 이용신청서</a>
			    	<a class="dropdown-item" value="007" onClick="deposite('007')">상속예금(지급 명의 변경) 의뢰 및 이자소득 귀속동의서</a>
			    	<a class="dropdown-item" value="008" onClick="deposite('008')">CMS출금이체 신청서</a>
			    	<a class="dropdown-item" value="009" onClick="deposite('009')">비거주자 판정표</a>
			    	<a class="dropdown-item" value="010" onClick="deposite('010')">세금우대 적용배재 신청서</a>
			  </div>
			</div>
			
			<div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    여신
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			    	<a class="dropdown-item" value="001" onClick="loan('001')">대출금 부속서류 명세표</a>
			    	<a class="dropdown-item" value="002" onClick="loan('002')">심의서</a>
			    	<a class="dropdown-item" value="003" onClick="loan('003')">심의자료外</a>
			    	<a class="dropdown-item" value="004" onClick="loan('004')">감정평가서</a>
			    	<a class="dropdown-item" value="005" onClick="loan('005')">신청서</a>
			    	<a class="dropdown-item" value="006" onClick="loan('006')">여신거래약정서</a>
			    	<a class="dropdown-item" value="007" onClick="loan('007')">신용부금 납입계약서</a>
			    	<a class="dropdown-item" value="008" onClick="loan('008')">추가약정서</a>
			  </div>
			</div>
			
		<button type="button href="#" onClick="fn_btnuserList()">유저목록</button>
	</ul>
</nav>

	<script>
		function common(element) {
			var url = "${pageContext.request.contextPath}/listCO";
			url = url + "?element=" + element;
			location.href = url;
		}
		function deposite(element) {
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
	</script>
    