<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bank/Customer::list</title>
	</head>
	<body>
		<h3>Bank/Customer 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/bank/customer/modify.do">수정하기</a>
		
		<form action="/ch10/bank/customer/modify.do" method="post">
			<table border="1">
				<tr>
					<td>고객아이디</td>
					<td><input type="text" name="c_id" readonly value="${ dto.c_id }"/></td>
				</tr>
				<tr>
					<td>고객명</td>
					<td><input type="text" name="c_name" value="${ dto.c_name }"/></td>
				</tr>
				<tr>
					<td>고객구분</td>
					<td>
						<label><input type="radio" name="c_type" value="1"/>개인고객(1)</label>
						<label><input type="radio" name="c_type" value="2"/>기업고객(2)</label>
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="c_hp" value="${ dto.c_hp }"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="c_addr" value="${ dto.c_addr }"/></td>
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