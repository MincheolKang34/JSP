<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.User6VO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터 변수 선언
	List<User6VO> users = new ArrayList<>();
	
	// 데이터베이스 접속 정보
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "mincheolkang34";
	String pass = "1234";
	
	// 데이터베이스 접속 및 sql 실행
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection(host, user, pass);
		Statement stmt = conn.createStatement();
		String sql = "select * from user6";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			User6VO vo = new User6VO();
			vo.setSeq(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setGender(rs.getString(3));
			vo.setAge(rs.getInt(4));
			vo.setAddr(rs.getString(5));
			
			users.add(vo);
		}
		
		rs.close();
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
		<title>user6::list</title>
	</head>
	<body>
		<h3>User6 목록</h3>	
		
		<a href="../jdbc.jsp">처음으로</a>
		<a href="./register.jsp">등록하기</a>
		
		<table border="1">
			<tr>
				<th>시퀀스</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>주소</th>
				<th>관리</th>
			</tr>
			<% for(User6VO user6VO : users){ %>
			<tr>
				<td><%= user6VO.getSeq() %></td>
				<td><%= user6VO.getName() %></td>
				<td><%= user6VO.getGender() %></td>
				<td><%= user6VO.getAge() %></td>
				<td><%= user6VO.getAddr() %></td>
				<td>
					<a href="./modify.jsp?seq=<%= user6VO.getSeq() %>">수정</a>
					<a href="./delete.jsp?seq=<%= user6VO.getSeq() %>">삭제</a>
				</td>
			</tr>
			<% } %>
		</table>
	</body>
</html>