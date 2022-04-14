<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findPWD</title>
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
		<div id="find_pwd">
			<form method="POST" action="findPWD" name="findform" id="fi_form">
				<h1 id="find_title">비밀번호 찾기</h1>
				<div>
					<label for="fi_id">아아디</label> 
					<input type="text" name="user_id" id="fi_id" />
				</div>

				<div>
					<label for="fi_name">이름</label> 
					<input type="text" id="fi_name" name="user_name"  />
				</div>

				<div>
					<label for="fi_phone1">전화번호</label> 
					<input type="text" id="fi_phone1"
						name="user_phone"  />
				</div>

				<div>
					<input type="submit" id="find_btn" value="비밀번호 확인">
				</div>

				<!-- 정보가 일치하지 않는 경우 -->
				<c:if test="${PWDdata == 1}">
					<script>
						opener.document.findform.user_id.value = "";
						opener.document.findform.user_name.value = "";
						opener.document.findform.user_phone.value = "";
					</script>
					<div>
						<label>일치하는 정보가 존재하지 않습니다.</label>
					</div>
				</c:if>

				<!-- 이름과 비밀번호가 일치하지 않을 때 -->
				<c:if test="${PWDdata == 0 }">
					<div>
						<label class="find_result">찾으시는 비밀번호는'<span id="find_success">${data.user_pwd}</span>' 입니다.</label>
						<br>
						<a href="/login" id="loginPage">로그인 페이지로 ...</a>						
					
					</div>
				
						
				</c:if>
			</form>


			<!-- <script type="text/javascript">
		function updatePassword(){
			if(document.findform.pwd.value==""){
				alert("비밀번호를 입력해주세요.");
				document.findform.pwd.focus();
			} else if(document.findform.pwd.value != document.findform.confirmpwd.value){
				alert("비밀번호가 일치하지 않습니다.");
				document.findform.confirmpwd.focus();
			} else {
				document.findform.action="update_password";
				document.findform.submit();
			}
		} 
		</script> -->

		</div>
	</div>

	<%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>