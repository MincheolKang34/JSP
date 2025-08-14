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
				<th>학번</th>
				<th>강좌번호</th>
				<th>중간점수</th>
				<th>기말점수</th>
				<th>총합점수</th>
				<th>등급</th>
				<th>관리</th>
			</tr>
			<c:forEach var="register" items="${ dtoList }">
				<tr>
					<td>${ register.regStdNo }</td>
					<td>${ register.regLecNo }</td>
					<td>${ register.regMidScore }</td>
					<td>${ register.regFinalScore }</td>
					<td>${ register.regTotalScore }</td>
					<td>${ register.regGrade }</td>
					<td>
						<a href="/ErdCollege/register/modify.do?regLecNo=${ register.regLecNo }">수정</a>
						<a href="/ErdCollege/register/delete.do?regLecNo=${ register.regLecNo }">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>