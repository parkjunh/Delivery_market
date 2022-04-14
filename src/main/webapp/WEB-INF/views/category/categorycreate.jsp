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
<link rel="stylesheet" href="/resources/css/category_IaU.css" />

<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>


</head>
<body>
	<%@include file="/WEB-INF/views/includes/menu.jsp"%>

	<div id="category_position">
		<div id="product_update">
			<form method="POST">
				<h1 id="title">카테고리 추가</h1>
				<input type="text" name="category_name" id="c_input">
					 <input type="submit" value="추가" id="submit_btn">
				 <br>
				<a href="javascript:window.history.back();" id="history_btn">목록으로 >> </a>
			</form>
		</div>
	</div>

</body>
</html>