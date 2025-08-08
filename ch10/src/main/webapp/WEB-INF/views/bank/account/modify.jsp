<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bank/Account::list</title>
	</head>
	<body>
		<h3>Bank/Account 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/bank/account/modify.do">수정하기</a>
		
		<form action="/ch10/bank/account/modify.do" method="post">
			<table border="1">
				<tr>
					<td>계좌번호</td>
					<td><input type="text" name="acc_no" readonly value="${ dto.acc_no })"/></td>
				</tr>
				<tr>
					<td>상품구분</td>
					<td>
						<select name="acc_type">
							<option value="S1">S1</option>
							<option value="S2">S2</option>
							<option value="S3">S3</option>
							<option value="L1">L1</option>
							<option value="L2">L2</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>상품명</td>
					<td>
						<select name="acc_name">
							<option value="자유저축예금">자유저축예금</option>
							<option value="정기적립예금">정기적립예금</option>
							<option value="주택청약예금">주택청약예금</option>
							<option value="신용대출">신용대출</option>
							<option value="담보대출">담보대출</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>고객번호</td>
					<td><input type="text" name="acc_cid"/></td>
				</tr>
				<tr>
					<td>현재잔액</td>
					<td><input type="number" name="acc_balance"/></td>
				</tr>
				<tr>
					<td>개설일</td>
					<td><input type="date" name="acc_date"/></td>
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