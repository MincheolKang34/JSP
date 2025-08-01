<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>shop/customer::list</title>
	</head>
	<body>
		<h3>Shop/Customer 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/shop/customer/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>주소</th>
				<th>등록일</th>
				<th>관리</th>
			</tr>
			<c:forEach var="customer" items="${dtoList}">
				<tr>
					<td>${customer.getCid()}</td>
					<td>${customer.getName()}</td>
					<td>${customer.getHp()}</td><!-- 표현언어에서 getter 호출 안하고 직접 속성 참조해서 출력 가능 -->
					<td>${customer.getAddress()}</td>
					<td>${customer.getRdate()}</td>
					<td>
						<a href="/ch10/shop/customer/modify.do?cid=${customer.getCid()}">수정</a>
						<a href="/ch10/shop/customer/delete.do?cid=${customer.getCid()}">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>