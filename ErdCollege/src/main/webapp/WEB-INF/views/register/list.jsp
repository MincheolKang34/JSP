<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>수강목록</title>
	</head>
	<body>
		<h3>수강목록</h3>
		
		<a href="/ErdCollege">처음으로</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>주소</th>
				<th>등록일</th>
				<th>관리</th>
			</tr>
			<c:forEach var="lecture" items="${ dtoList }">
				<tr>
					<td>${ lecture.custid }</td>
					<td>${ lecture.name }</td>
					<td>${ lecture.hp }</td>
					<td>${ lecture.addr }</td>
					<td>${ lecture.rdate }</td>
					<td>
						<a href="/ErdCollege/lecture/modify.do?">수정</a>
						<a href="/ErdCollege/lecture/delete.do?">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>