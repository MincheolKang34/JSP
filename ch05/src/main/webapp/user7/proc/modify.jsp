<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 요청 데이터 가져오기
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String email = request.getParameter("email");
	
	// 데이터베이스 접속 정보
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "mincheolkang34";
	String pass = "1234";
	
	// 데이터베이스 접속 및 sql 실행
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection(host, user, pass);
		String sql = "update user7 set name=?, age=?, email=? where id=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, age);
		psmt.setString(3, email);
		psmt.setString(4, id);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	// 목록 이동
	response.sendRedirect("../list.jsp");
%>