<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College/Student::modify</title>
	</head>
	<body>
		<h3>College/Student 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/student/list.do">목록이동</a>
		
		<form action="/ch10/college/course/modify.do" method="post">
			<table border="1">
				<tr>
					<td>강좌번호</td>
					<td><input type="text" name="cs_id" readonly value="${ dto.cs_id }"/></td>
				</tr>
				<tr>
					<td>강좌이름</td>
					<td><input type="text" name="cs_name" value="${ dto.cs_name }"/></td>
				</tr>
				<tr>
					<td>취득학점</td>
					<td><input type="number" name="cs_credit" value="${ dto.cs_credit }"/></td>
				</tr>
				<tr>
					<td>학과</td>
					<td>
						<select name="cs_dept">
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
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>