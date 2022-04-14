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
<link rel="stylesheet" href="/resources/css/categoryupdate.css" />

<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/product_IaU.css" />

<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>

<script src="/resources/js/product.js"></script>

</head>
<body>
	<%@include file="/WEB-INF/views/includes/menu.jsp"%>
	<div id="product_position">
		<div id="product_update">

			<form method="POST" enctype="multipart/form-data">
				<h1 id="title">상품 수정</h1>
				<hr>
				<input type="hidden" name="product_num" value="${data.product_num }">
				
				<div>
					<label for="p_name" id="pc_name">상품이름 </label>
					<input type="text" id="p_name" name="product_name" value="${pList.product_name }">
				</div>
				<br>
				<div>
					<label for="p_content" id="pc_content">상품 내용 </label>
					<textarea id="p_content" name="product_content">${pList.product_content }</textarea>
				</div>
				
				<div>
					<label for="p_category" id="pc_category">카테고리</label>
					
					<select id="p_category" name="category_name">
						<c:forEach items="${cList }" var="c_list">
							
								<option value="${c_list.category_name }" selected >
									${c_list.category_name }
								</option>
							
						</c:forEach>
					</select>
				</div>
				<br>
				<label for="p_price" id="pc_price">가격</label>
				<input type="number" id="p_price" name="product_price"  value="${pList.product_price }">
				<br>
				<div id="filebox">
					<label for = "p_imgName" id="pc_imgName">이미지 추가</label><br>
					<input id="upload_name" value="첨부파일" placeholder="첨부파일">
					<label for="p_imgName" id="upload_label" >파일 선택</label>
					<input type="file" accept=".jpg , .png , .jpeg" name="img_name" id="p_imgName">
				</div>
				
				
				<div>
					<input  type="submit" value="상품 추가" id="submit_btn"><br>
				</div>
				<div id="history_btn">
					<a href="javascript:window.history.back();">목록으로 >> </a>								
				</div>
			</form>


		</div>
	</div>

</body>
</html>