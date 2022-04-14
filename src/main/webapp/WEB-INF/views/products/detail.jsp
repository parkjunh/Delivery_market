<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="stylesheet" href="/resources/css/detail.css" />
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/resources/js/detail.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<%@include file="/WEB-INF/views/includes/navbar.jsp"%>


	<div id="pd_view">
		<section class="prod_detail_area">
			<form method="GET" action="/order">
				<input type="hidden" value="${p_detail.product_num }" name="product_num">
				<div class="prod_img_box">
					<img src="/resources/upload/${p_detail.img_name }" class="img_box_detail"/>
				</div>
				<div class="prod_detail_content">
					<p class="prod_name">${p_detail.product_name }</p>
					<div class="detail_info">
						<div class="row">
							<div>카테고리</div>
							<div>
								<p>${p_detail.category_name }</p>
							</div>
						</div>
					</div>

					<div class="detail_info">
						<div class="row">
							<div>상세내용</div>
							<div>내용 더미</div>
						</div>
					</div>


					<div class="detail_info last">
						<div class="row">
							<div>구매수량</div>
							<div>
								<button id="decrease" type="button">
									<i class="fas fa-minus"></i>
								</button>
								<span class="total" name="product_count">1</span>
								<button id="increase" type="button">
									<i class="fas fa-plus"></i>
								</button>
							</div>
						</div>
					</div>
					<div class="final_price_area">
						<div class="final_price">
							<span>총 상품금액 :</span> 
							<span id="final" data-value="${p_detail.product_price }" name="product_price">
								<fmt:formatNumber value="${p_detail.product_price }" pattern="#,###" />
							</span> 
							<span>원</span>
						</div>
					</div>
					<input type="hidden" id="p_count" name="product_count" value="1">
					<input type="hidden" id="p_price" name="product_price"  value="${p_detail.product_price }">
					
					<c:if test="${user_data.user_id == null}">
						<div class="button_area">
							<a href="/login" id="detail_login"> 로그인 후 이용 가능</a>
						</div>
					</c:if>
					<c:if test="${user_data.user_id != null}">
					<div class="button_area">
						<input type="submit" id="add_cart" value="구매 하기" />
						<a id="after_get" href="/order?product_num=${p_detail.product_num }&product_count=${data.product_count }&product_price=${data.product_price }"></a>
					</div>
					</c:if>
				</div>
			</form>
		</section>
	</div>
	<%@include file="/WEB-INF/views/includes/footer.jsp"%>

</body>
</html>