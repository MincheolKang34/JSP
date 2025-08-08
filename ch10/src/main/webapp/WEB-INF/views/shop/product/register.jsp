<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Shop/Product::list</title>
	</head>
	<body>
		<h3>Shop/Product 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/shop/product/register.do">등록하기</a>
		
		<form action="/ch10/shop/product/register.do" method="post">
			<table border="1">
				<tr>
					<td>상품번호</td>
					<td><input type="number" name="pno"/></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="pname" placeholder="상품명 입력"/></td>
				</tr>
				<tr>
					<td>재고수량</td>
					<td><input type="number" name="stock"/></td>
				</tr>
				<tr>
					<td>단가</td>
					<td><input type="number" name="price"/></td>
				</tr>
				<tr>
					<td>제조업체</td>
					<td><input type="text" name="company" placeholder="제조업체 입력"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="등록하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>