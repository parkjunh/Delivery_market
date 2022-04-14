<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="/resources/css/order_history.css" />



</head>
<body>

	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<%@include file="/WEB-INF/views/includes/navbar.jsp"%>

	<div id="oh_position1">
		<div id="oh_position2">
		
			<input type="hidden" name="user_seq" value="${user_data.user_seq}" >
			<h1 id="order_title">주문 내역</h1>
			<table class="table">
				<thead id="ut_header">
					<tr>
						<th scope="col">주문번호</th>
						<th scope="col">상품이름</th>
						<th scope="col">주문자</th>
						<th scope="col">배송지</th>
						<th scope="col">휴대폰</th>
						<th scope="col">수량</th>
						<th scope="col">가격</th>
						<th scope="col">주문취소</th>
						
					</tr>
				</thead>
				<tbody id="ut_tbody">
					<c:forEach var="ol" items="${list }">
						<tr class="tr_tag">
							<td>${ol.order_num }</td>
							<td>${ol.product_name }</td>
							<td>${ol.reciver_name }</td>
							<td>${ol.address }</td>
							<td>${ol.reciver_phone }</td>
							<td>${ol.product_count }</td>
							<td>${ol.product_price }</td>
							<td>
								<form method="post" action="order_delete">
									<input type="hidden" value="${ol.order_detail_num}" name="order_detail_num">
									<input type="submit" value="주문취소" id="delete_btn">							
								</form>
							</td>
						</tr>
					
					
					</c:forEach>
				</tbody>

			</table>

		</div>

	</div>












	<%@include file="/WEB-INF/views/includes/footer.jsp"%>




</body>
</html>