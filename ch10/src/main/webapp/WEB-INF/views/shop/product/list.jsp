<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>shop/product::list</title>
	</head>
	<body>
		<h3>Shop/Product 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/shop/product/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>상풍번호</th>
				<th>상품명</th>
				<th>재고량</th>
				<th>단가</th>
				<th>제조업체</th>
				<th>관리</th>
			</tr>
			<c:forEach var="product" items="${dtoList}">
				<tr>
					<td>${ product.getPno() }</td>
					<td>${ product.getPname() }</td>
					<td>${ product.getStock() }</td><!-- 표현언어에서 getter 호출 안하고 직접 속성 참조해서 출력 가능 -->
					<td>${ product.getPrice() }</td>
					<td>${ product.getCompany() }</td>
					<td>
						<a href="/ch10/shop/product/modify.do?${ product.getPno() }">수정</a>
						<a href="/ch10/shop/product/delete.do?${ product.getPno() }">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>