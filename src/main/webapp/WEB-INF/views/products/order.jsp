<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/order.css" />


</head>
<body>

	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<%@include file="/WEB-INF/views/includes/navbar.jsp"%>
	<div id="order_position1">
		<div id="order_position2">
			<form method="post" id="order_form">
				<input type="hidden" name="product_num" value="${data.product_num }">
				<input type="hidden" name="user_seq" value="${user_data.user_seq }">
				<input type="hidden" name="order_detail_num">
				<input type="hidden" name="order_num">
				
				<input type="hidden" name="user_id" value="${user_data.user_id }">
				<h1 class="order_title">주문 결제</h1>
				<hr>
				<div>
					<label id="order_name">이름&nbsp;&nbsp;&nbsp;:</label> 
					<input type="text"  name="reciver_name" value="${user_data.user_name}">
				</div>
				<div>
					<label id="order_addr">배송지:</label> 
					<input type="text"name="address" value="${user_data.user_address }">
				</div>
				<div>
					<label id="order_phone">휴대폰:</label> 
					<input type="text"  name="reciver_phone" value="${user_data.user_phone }">
				</div>
				<div>
					<label id="order_count">수량&nbsp;&nbsp;&nbsp;:</label> 
					<input type="number" value="${data.product_count }" name="product_count"  readonly>

				</div>
				<div>
					<label id="order_price">가격&nbsp;&nbsp;&nbsp;:</label> 
					<input type="number" value="${data.product_price }" name="product_price"  readonly >
				</div>

				<input type="submit" value="구매" id ="order_submit">
			</form>
		</div>


	</div>







	<%@include file="/WEB-INF/views/includes/footer.jsp"%>

</body>
</html>