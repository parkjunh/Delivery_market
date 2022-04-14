<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 폼</title>

<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/join.css" />

</head>
<body>

	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<%@include file="/WEB-INF/views/includes/navbar.jsp"%>

	<div id="join_form1">
		<div id="join_form2">

			<h2 id="join_title">회원 가입</h2>
			<hr>
			<form action="/join" method="post">
				<input type="hidden" name="user_seq">
				<div>
					<label for="inputId" class="form-label">아이디</label> <input
						type="text" class="form-control join_input" id="inputId" name="user_id"
						placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합">
				</div>
				<div>
					<label for="inputPassword" class="form-label">비밀번호</label> <input
						type="password" class="form-control join_input" id="inputPassword"
						name="user_pwd" placeholder="비밀번호를 입력해주세요">
				</div>
				<div>
					<label for="inputName" class="form-label">이름</label> <input
						type="text" class="form-control join_input" name="user_name" id="inputName"
						placeholder="이름을 입력해주세요">
				</div>
				<div>
					<label for="inputEmail" class="form-label">Email</label> <input
						type="email" class="form-control join_input" id="inputEmail4"
						name="user_email" placeholder="예 : username@delivery_market.com">
				</div>
				<div>
					<label for="inputPhone" class="form-label" id="phone_title">휴대폰</label>
					<input
						type="text" name="user_phone" id="inputPhone"
						placeholder="숫자만 입력해주세요">
				</div>
				
				<div>
					<label for="inputAddress" class="form-label" id="join_address">주소</label><br>
					 <input
						type="text" id="inputAddress" name="user_address"
						placeholder="주소를 직접 입력해주세요">
				</div>

				<div>
					<label for="inputGender" class="form-label">성별</label>
					<div id="Gender_btn">
						<input class="form-check-input"  type="radio" name="user_gender"
							id="inputgendM" value="1" checked> <label
							class="form-check-label" for="flexRadioDefault1" id="lg_m"> 남자 </label>
						<input class="form-check-input" type="radio" name="user_gender"
							value="2" id="inputgendW"> <label
							class="form-check-label" for="flexRadioDefault2" id="lg_w"> 여자 </label>
					</div>
				</div>
				<hr>
				<div class="col-6">
					<button type="submit" class="btn text-while w-100" id = "join_submit">가입하기</button>
				</div>
			</form>
		</div>
	</div>
	
	<%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>