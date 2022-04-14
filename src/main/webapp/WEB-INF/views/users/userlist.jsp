<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>

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
<link rel="stylesheet" href="/resources/css/userlist.css" />

	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
			
	<script src ="/resources/js/category.js"></script>

</head>
<body>
	<%@include file="/WEB-INF/views/includes/menu.jsp" %>
	<div id="u_table">
	<h1 class="admin_title">회원 관리</h1>
	<table class="table ">
		<thead  id ="ut_header">
			<tr>
				<th scope ="col">No</th>
				<th scope ="col">아이디</th>
				<th scope ="col">비밀번호</th>
				<th scope ="col">이름</th>
				<th scope ="col">휴대폰</th>
				<th scope ="col">이메일</th>
				<th scope ="col">성별</th>
				<th scope ="col">주소</th>
				<th scope ="col">수정</th>
				<th scope ="col">탈퇴</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="data" items="${data}">
				<tr id = "ut_body">
					<th scope ="row">${data.user_seq}</th>
					<td>${data.user_id}</td>
					<td>${data.user_pwd}</td>
					<td>${data.user_name}</td>
					<td>${data.user_phone}</td>
					<td>${data.user_email}</td>
					<td>
						<c:if test="${data.user_gender == 1 }">
							<p>남자</p>
						</c:if>
						<c:if test="${data.user_gender == 2 }">
							<p>여자</p>
						</c:if>
					</td>
					<td>${data.user_address}</td>
					<td>
						<a href="/userupdate?user_seq=${data.user_seq}"  id="user_update">수정</a>
					</td>
					<td>
					<form action = "userdelete" method="POST">
								<input type="hidden" value="${data.user_seq }" name="user_seq">
								
								<c:if test = "${data.user_level == 0 }">
									<input type="button" value="탈퇴" id="user_delete" disabled>	
								</c:if>			
											
								<c:if test = "${data.user_level == 1 }">
									<input type="submit" value="탈퇴" id="user_delete">	
								</c:if>
							</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<a href="/join" id="insert_btn3">회원가입</a>
	
	<div id ="page_btn">
			<c:if test="${startPage!=1}">
				<a id="pre" href="/userlist?nowPage=${startPage-1}">&lt;</a>
			</c:if>
	
			<c:forEach var="idx" begin="${startPage}" end="${endPage}">
				<c:choose>
					<c:when test="${nowPage!=idx}">
						<a id="now" href="/userlist?nowPage=${idx}">${idx}&nbsp;</a>
					</c:when>
					<c:when test="${nowPage==idx}">
						<b>${idx}&nbsp;</b>
					</c:when>
				</c:choose>
			</c:forEach>
	
			<c:if test="${endPage!=totalcount}">
				<a id="nxt" href="/userlist?nowPage=${endPage+1}">&gt;</a>
			</c:if>
		</div>
	
	
	
	</div>
</body>
</html>



