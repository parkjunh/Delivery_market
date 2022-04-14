<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/resources/slick/slick.min.js"></script>
<script src="/resources/js/main.js"></script>

<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/main.css" />

<link rel="stylesheet" href="/resources/slick/slick.css" />
<link rel="stylesheet" href="/resources/slick/slick-theme.css" />
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp"%>
	<%@include file="/WEB-INF/views/includes/navbar.jsp"%>



	<div id="mp_view">
		<div id="mp_banner">
			<section class="main_banner_area">
				<div class="main_banner_wrap">
					<div class="banner_item">
						<a href="#"> <img src="/resources/img/b1.jpg">
						</a>
					</div>
					<div class="banner_item">
						<a href="#"> <img src="/resources/img/b2.jpg">
						</a>
					</div>

					<div class="banner_item">
						<a href="#"> <img src="/resources/img/b3.jpg">
						</a>
					</div>
					<div class="banner_item">
						<a href="#"> <img src="/resources/img/b4.jpg">
						</a>
					</div>
				</div>
				<div class="banner_btn_area">
					<button id="prev">
						<img src="/resources/img/bb1.PNG" />
					</button>
					<button id="next">
						<img src="/resources/img/bb2.PNG" />
					</button>
				</div>
			</section>
		</div>

		<section class="item_list_area">
			<h1>전체 상품</h1>
			<div class="item_list_wrap">
				<c:forEach items="${list_data }" var="product">
					<div class="prod_list">
						<div class="prod_item">
							<a href="/detail?product_num=${product.product_num }"> 
								<img src="/resources/upload/${product.img_name }">
							</a>
						</div>
						<a href="/detail?product_num=${product.product_num }" class="pt_link">
							<div class="prod_item_text">
								<p class="prod_item_title">[${product.category_name }]&nbsp;${product.product_name }</p>
							</div>
							<div class="prod_item_price">
								&#8361;<fmt:formatNumber value="${product.product_price }" pattern="#,###" />
							</div>
						
						</a>
						
					</div>
				</c:forEach>
			</div>
		</section>
	</div>
	
	
	<%@include file="/WEB-INF/views/includes/footer.jsp"%>
</body>
</html>