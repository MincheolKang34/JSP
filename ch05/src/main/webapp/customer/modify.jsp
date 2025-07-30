<%@page import="javax.naming.InitialContext"%>
<%@page import="vo.CustomerDTO"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String cid = request.getParameter("cid");

	// 수정할 객체
	CustomerDTO customer = null;
	
	try{
		// 자바 기본 환경객체 검색(WAS 환경)
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		
		// jdbc/mincheolkang34 커넥션풀 검색
		DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
		Connection conn = ds.getConnection();
		
		String sql = "SELECT * FROM CUSTOMER WHERE cid=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, cid);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			customer = new CustomerDTO();
			customer.setCid(rs.getString(1));
			customer.setName(rs.getString(2));
			customer.setHp(rs.getString(3));
			customer.setAddress(rs.getString(4));
			customer.setRdate(rs.getString(5));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::list</title>
	</head>
	<body>
		<h3>User1 수정</h3>
		
		<a href="/ch05/dbcp.jsp">처음으로</a>
		<a href="/ch05/register.jsp">등록하기</a>
		
		<form action="/ch05/customer/proc/modify.jsp" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="cid" readonly value="<%= customer.getCid() %>" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="<%= customer.getName() %>" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="<%= customer.getHp() %>" placeholder="휴대폰 입력(- 포함)"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="<%= customer.getAddress() %>"/></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="date" name="rdate" value="<%= customer.getRdate() %>" placeholder="숫자 입력"/></td>
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