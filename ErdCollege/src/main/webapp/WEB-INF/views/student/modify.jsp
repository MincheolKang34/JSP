<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생수정</title>
	</head>
	<body>
		<h3>학생수정</h3>
		
		<a href="/ErdCollege">처음으로</a>
		<a href="/ErdCollege/student/list.do">목록이동</a>
		
		<form action="/ErdCollege/student/modify.do" method="post">
			<table border="1">
				<tr>
					<td>학번</td>
					<td><input type="text" name="stdNo" readonly value="${ dto.stdNo }"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="stdName" value="${ dto.stdName }"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="stdHp" value="${ dto.stdHp }"/></td>
				</tr>
				<tr>
					<td>학년</td>
					<td><input type="number" name="stdYear" value="${ dto.stdYear }"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="stdAddress" value="${ dto.stdAddress }"/></td>
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