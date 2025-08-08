<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College/Course::list</title>
	</head>
	<body>
		<h3>College/Course 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/course/register.do">등록하기</a>
		
		<form action="/ch10/college/course/register.do" method="post">
			<table border="1">
				<tr>
					<td>과목번호</td>
					<td><input type="text" name="cs_id" placeholder="과목번호 입력"/></td>
				</tr>
				<tr>
					<td>과목이름</td>
					<td><input type="text" name="cs_name" placeholder="과목이름 입력"/></td>
				</tr>
				<tr>
					<td>학점</td>
					<td><input type="number" name="cs_credit"/></td>
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
						<input type="submit" value="등록하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>