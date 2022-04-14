<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/login.css" />


</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<%@include file="/WEB-INF/views/includes/navbar.jsp"%>
	
	<div id="login_view1">
		<div id="login_view2">

			<h3 class=mb-2 id="login_title">Login</h3>

			<form method="post" action="/login" id="login_form">
				<input type="hidden" name="user_level">
				<div class=m-2>
					<input type="text" name="user_id" placeholder="아이디를 입력해주세요"
						 id="id_input">
				</div>
				<div class=m-2 >
					<input type="password" name="user_pwd" placeholder="비밀번호를 입력해주세요"
						 id="pwd_input">
				</div>
				<div class="m-2" id="findchk">
					<a href="/join">회원가입</a> <span>|</span>
					<a href="/findID">아이디 찾기</a> <span>|</span>
					<a href="/findPWD">비밀번호
						찾기</a>
				</div>
				<div class=m-2 id="login_next">
					<input type=submit value="로그인">
				</div>
				

			</form>

		</div>

	</div>
	<%@include file="/WEB-INF/views/includes/footer.jsp"%>

</body>
</html>