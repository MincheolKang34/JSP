<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user7::modify</title>
	</head>
	<body>
		<h3>User7 수정</h3>
		
		<a href="/ch09">처음으로</a>
		<a href="/ch09/user7/list.do">목록이동</a>
		
		<form action="/ch09/user7/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="number" name="id" readonly value="${user7DTO.id}"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user7DTO.name}" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${user7DTO.age}" placeholder="숫자 입력"/></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" value="${user7DTO.email}" placeholder="이메일 주소 입력"/></td>
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