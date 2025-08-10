<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Library/Member::list</title>
	</head>
	<body>
		<h3>Library/Member 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/library/member/modify.do">수정하기</a>
		
		<form action="/ch10/library/member/modify.do" method="post">
			<table border="1">
				<tr>
					<td>회원번호</td>
					<td><input type="text" name="member_id" readonly value="${ dto.member_id }"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${ dto.name }"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="${ dto.address }"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="${ dto.hp }"/></td>
				</tr>
				<tr>
					<td>가입일</td>
					<td><input type="datetime-local" step="1" name="join_date" value="${ dto.join_date }"/></td>
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