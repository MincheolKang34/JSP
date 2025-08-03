<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 요청 데이터 가져오기
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	String address = request.getParameter("address");

	// 데이터베이스 접속 정보
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "mincheolkang34";
	String pass = "1234";
	
	// 데이터베이스 접속 및 sql 실행
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection(host, user, pass);
		String sql = "insert into user5 values(?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, gender);
		psmt.setString(3, age);
		psmt.setString(4, address);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	// 목록 이등
	response.sendRedirect("../list.jsp");
%>