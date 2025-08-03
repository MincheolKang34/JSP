<%@page import="java.sql.ResultSet"%>
<%@page import="vo.User5VO"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 요청 데이터 받기
	String name = request.getParameter("name");
	
	// 데이터베이스 접속 정보
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "mincheolkang34";
	String pass = "1234";
	
	// 데이터 객체 생성
	User5VO vo = null;
	
	// 데이터베이스 접속 및 sql 실행
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection(host, user, pass);
		Statement stmt = conn.createStatement();
		String sql = "select * from user5 where name='"+name+"'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			vo = new User5VO();
			vo.setName(rs.getString(1));
			vo.setGender(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setAddress(rs.getString(4));
		}
		
		stmt.close();
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user4::list</title>
	</head>
	<body>
		<h3>User5 수정</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./list.jsp">목록으로</a>
		
		<form action="./proc/modify.jsp" method="post">
			<table border="1">
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" readonly value="<%= vo.getName() %>"/>
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<label><input type="radio" name="gender"  value="M"/>남자</label>
						<label><input type="radio" name="gender"  value="F"/>여자</label>
					</td>
				</tr>
				<tr>
					<td>나이</td>
					<td>
						<input type="number" name="age"  value="<%= vo.getAge() %>"/>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address"  value="<%= vo.getAddress() %>"/>
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