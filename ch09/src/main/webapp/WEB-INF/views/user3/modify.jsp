<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user3::modify</title>
	</head>
	<body>
		<h3>User3 수정</h3>
		
		<a href="/ch09">처음으로</a>
		<a href="/ch09/user3/list.do">목록이동</a>
		
		<form action="/ch09/user3/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="user_id" readonly value="${user3DTO.user_id}" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user3DTO.name}" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="${user3DTO.hp}" placeholder="휴대폰 입력(- 포함)"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${user3DTO.age}" placeholder="숫자 입력"/></td>
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