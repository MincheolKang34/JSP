<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>거래목록</title>
	</head>
	<body>
		<h3>거래목록</h3>
		
		<a href="/ErdBank">처음으로</a>
		<a href="/ErdBank/transaction/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>거래번호</th>
				<th>계좌번호</th>
				<th>거래구분</th>
				<th>거래금액</th>
				<th>거래날짜</th>
				<th>관리</th>
			</tr>
			<c:forEach var="dto" items="${ dtoList }">
				<tr>
					<td>${ dto.t_no }</td>
					<td>${ dto.t_a_no }</td>
					<td>${ dto.t_dist }</td>
					<td>${ dto.t_amount}</td>
					<td>${ dto.t_datetime }</td>
					<td>
						<a href="/ErdBank/transaction/delete.do?t_no=${ dto.t_no }">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>