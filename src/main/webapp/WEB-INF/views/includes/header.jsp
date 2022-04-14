<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/header.css" />

</head>
<body>

	<div id="user_header">
		<c:choose>
			<c:when test="${empty user_data.user_id}">
				<div id="user_menu">
					<a href="/login">로그인</a> <span>|</span> <a href="/join">회원가입</a> <span>|</span>
					<div class="dropdownboardBF">
						<button class="boarddropdown dropdown-toggle" type="button"
							id="menuboard" data-bs-toggle="dropdown" aria-expanded="false">
							고객센터</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a class="dropdown-item" href="#">공지사항</a></li>
							<li><a class="dropdown-item" href="#">1:1 문의 </a></li>
						</ul>
					</div>
				</div>
			</c:when>

			<c:otherwise>
				<div id="user_menu">
					<div class="dropdownloginAF">
						<a class=" login dropdown-toggle" href="#" role="button"
							id="menulogin" data-bs-toggle="dropdown" aria-expanded="false">
							${user_data.user_id} 님 </a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<c:if test="${user_data.user_level==0}">
								<li><a class="dropdown-item" href="/product">관리자 페이지</a></li>
							</c:if>
							<li><a class="dropdown-item" href="/order_history?user_seq=${user_data.user_seq }">주문내역</a></li>
							<li><a class="dropdown-item"
								href="/u_update?user_seq=${user_data.user_seq }">개인정보수정</a></li>
							<li><a class="dropdown-item" href="/logout">로그아웃</a></li>
						</ul>
					</div>
					<span>|</span>
					<div class="dropdownboardAF">
						<button class="board dropdown-toggle" type="button" id="menuboard"
							data-bs-toggle="dropdown" aria-expanded="false">고객센터</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a class="dropdown-item" href="#">공지사항</a></li>
							<li><a class="dropdown-item" href="#">1:1 문의 </a></li>
						</ul>
					</div>
				</div>

			</c:otherwise>
		</c:choose>
	</div>


	<div id="mainpage_1">
		<div class="main_header">
			<a href="/main"> <img src="/resources/img/deliverylab_logo.png"
				id="logo_img">
			</a>
			<form id="main_search">
				<input type="text" id="search_input1" value="   "> <input
					type="submit" id="search_submit" value="Search">
			</form>
		</div>
	</div>

</body>
</html>