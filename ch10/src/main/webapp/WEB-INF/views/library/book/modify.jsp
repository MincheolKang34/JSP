<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Library/Book::list</title>
	</head>
	<body>
		<h3>Library/Book 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/library/book/modify.do">수정하기</a>
		
		<form action="/ch10/library/book/modify.do" method="post">
			<table border="1">
				<tr>
					<td>도서번호</td>
					<td><input type="text" name="book_id" value="${ dto.book_id }"/></td>
				</tr>
				<tr>
					<td>도서명</td>
					<td><input type="text" name="title" value="${ dto.title }"/></td>
				</tr>
				<tr>
					<td>저자</td>
					<td><input type="text" name="author" value="${ dto.author }"/></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td><input type="text" name="publisher" value="${ dto.publisher }"/></td>
				</tr>
				<tr>
					<td>대출여부</td>
					<td>
						<label><input type="radio" name="available" value="Y"/>Y</label>
						<label><input type="radio" name="available" value="N"/>N</label>
					</td>
				</tr>
				<tr>
					<td>도서 등록일</td>
					<td><input type="datetime-local" step="1" name="reg_date" value="${ dto.reg_date }"/></td>
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