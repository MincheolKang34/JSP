<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College/Student::list</title>
	</head>
	<body>
		<h3>College/Student 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/student/register.do">등록하기</a>
		
		<form action="/ch10/college/student/register.do" method="post">
			<table border="1">
				<tr>
					<td>학번</td>
					<td><input type="text" name="stdNo" placeholder="학번 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" name="birth"/></td>
				</tr>
				<tr>
					<td>전공</td>
					<td>
						<select name="major">
							<option value="국문학과">국문학과</option>
							<option value="영문학과">영문학과</option>
							<option value="일문학과">일문학과</option>
							<option value="중문학과">중문학과</option>
							<option value="컴공학과">컴공학과</option>
							<option value="통계학과">통계학과</option>
							<option value="수학학과">수학학과</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>입학일</td>
					<td><input type="date" name="enr_date"/></td>
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