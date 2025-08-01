<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.User4VO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터 객체 생성
	List<User4VO> users = new ArrayList<>();

	// 데이터베이스 접속 정보
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "mincheolkang34";
	String pass = "1234";
	
	// 데이터베이스 접속 및 sql 실행
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection(host, user, pass);
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM USER4";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			User4VO vo = new User4VO();
			vo.setName(rs.getString(1));
			vo.setGender(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setAddress(rs.getString(4));
			
			users.add(vo);
		}
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
		<h3>User4 목록</h3>
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./register.jsp">등록하기</a>
		
		<table border="1">
			<tr>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<% for(User4VO vo : users){ %>
				<tr>
					<td><%= vo.getName() %></td>
					<td><%= vo.getGender() %></td>
					<td><%= vo.getAge() %></td>
					<td><%= vo.getAddress() %></td>
					<td>
						<a href="./modify.jsp?name=<%= vo.getName() %>">수정</a>
						<a href="./delete.jsp?name=<%= vo.getName() %>">삭제</a>
					</td>
				</tr>
			<% } %>
		</table>
	</body>
</html>