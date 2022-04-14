<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findID</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
	
	
	
<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/find.css" />

</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<%@include file="/WEB-INF/views/includes/navbar.jsp"%>

	<div id="find_position">
		<div id="find_id">
			<form method="POST" action="findID" name="findform" id="fi_form">
				<h1 id="find_title">아이디 찾기</h1>
				<div>
					<label for="inputName">이름</label> 
					<input type="text" name="user_name" id="fi_name">
				</div>
				<div >
					<label for="inputPhone" class="form-label">휴대폰번호</label> 
					<input type="text" name="user_phone" id="fi_phone">
				</div>
	
				<div >
					<input type=submit value="아이디 확인" id="find_btn">
				</div>
	
				<!-- 이름과 전화번호가 일치하지 않을 때-->
				<c:if test="${IDdata == 1}">
					<script>
						opener.document.findform.user_name.value = "";
						opener.document.findform.user_phone.value = "";
					</script>
					<label class="find_result" >일치하는 정보가 존재하지 않습니다.</label>
				</c:if>
	
				<!-- 이름과 비밀번호가 일치하지 않을 때 -->
				<c:if test="${IDdata == 0}">
					<div>
						<label class="find_result">찾으시는 아이디는'<span id="find_success">${data.user_id}</span>' 입니다.
							</label>
						<div>
							<a href="/login" id="loginPage">로그인 페이지로 ...</a>						
						</div>
					</div>
				</c:if>
	
			</form>
		
		</div>

	</div>
	<%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>