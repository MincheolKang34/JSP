<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::modify</title>
	</head>
	<body>
		<h3>User4 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user4/list.do">목록이동</a>
		
		<form action="/ch10/user4/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" readonly value="${dto.uid}"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${dto.name}"/></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<label><input type="radio" name="gender" value="M"/>M</label>
						<label><input type="radio" name="gender" value="F"/>F</label>
					</td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${dto.age}"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="${dto.hp}"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="addr" value="${dto.addr}"/></td>
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