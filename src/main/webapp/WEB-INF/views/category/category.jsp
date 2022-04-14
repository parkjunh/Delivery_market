<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" href="/resources/css/userlist.css" />

	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
			
	<script src ="/resources/js/category.js"></script>

</head>
<body>
	<%@include file="/WEB-INF/views/includes/menu.jsp"%>

	<div id="u_table">
		<h1 class="admin_title">카테고리 관리</h1>
		<table class="table">
			<thead>
				<tr id="ut_header">
					<th scope="col">No</th>
					<th scope="col">카테고리 명</th>
					<th scope="col">등록 날짜</th>
					<th scope="col">수정</th>
					<th scope="col">삭제</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cdata }" var="c_data">
					<tr id="ut_body">
						<th scope="row">${c_data.category_code }</th>
						<td>${c_data.category_name }</td>
						<td>${c_data.category_insertdate }</td>
						<td>
							<a href="/categoryupdate?category_code=${c_data.category_code }" id="user_update">수정</a>
						</td>
						<td>
							<form action = "category_delete" method="POST">
								<input type="hidden" value="${c_data.category_code }" name="category_code" >
								<input type="submit" value="삭제" id="user_delete">
							</form>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
			<a href="/categorycreate" id="insert_btn2">카테고리 추가</a>
		
		<div id ="page_btn">
			<c:if test="${startPage!=1}">
				<a id="pre" href="/category?nowPage=${startPage-1}">&lt;</a>
			</c:if>
	
			<c:forEach var="idx" begin="${startPage}" end="${endPage}">
				<c:choose>
					<c:when test="${nowPage!=idx}">
						<a id="now" href="/category?nowPage=${idx}">${idx}&nbsp;</a>
					</c:when>
					<c:when test="${nowPage==idx}">
						<b>${idx}&nbsp;</b>
					</c:when>
				</c:choose>
			</c:forEach>
	
			<c:if test="${endPage!=totalcount}">
				<a id="nxt" href="/category?nowPage=${endPage+1}">&gt;</a>
			</c:if>
		</div>
		
	</div>
	
	



</body>
</html>