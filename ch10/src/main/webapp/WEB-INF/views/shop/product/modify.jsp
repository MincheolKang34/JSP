<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Shop/Product::modify</title>
	</head>
	<body>
		<h3>Shop/Product 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/shop/product/list.do">목록이동</a>
		
		<form action="/ch10/shop/product/modify.do" method="post">
			<table border="1">
				<tr>
					<td>상품번호</td>
					<td><input type="number" name="pno" readonly value="${dto.pno}"/></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="pname" value="${dto.pname}"/></td>
				</tr>
				<tr>
					<td>재고량</td>
					<td><input type="number" name="stock" value="${dto.stock}"/></td>
				</tr>
				<tr>
					<td>단가</td>
					<td><input type="number" name="price" value="${dto.price}"/></td>
				</tr>
				<tr>
					<td>제조업체</td>
					<td><input type="text" name="company" value="${dto.company}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>