<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
		
		// 시퀀스 생성 여부 체크
		Statement psmt1 = conn.createStatement();
		String sql1 = "SELECT sequence_name FROM user_sequences WHERE sequence_name = 'SEQ_USER6'";
		ResultSet rs = psmt1.executeQuery(sql1);
		
		// 시퀀스 없을 시 생성
		if(!(rs.next())) {
			String sql2 = "create sequence seq_user6 increment by 1 start with 1";
			PreparedStatement psmt2 = conn.prepareStatement(sql2);
			psmt2.executeUpdate();
			psmt2.close();
		}
		rs.close();
		psmt1.close();
		
		String sql3 = "insert into user6 values(seq_user6.nextval,?,?,?,?)";
		PreparedStatement psmt3 = conn.prepareStatement(sql3);
		psmt3.setString(1, name);
		psmt3.setString(2, gender);
		psmt3.setString(3, age);
		psmt3.setString(4, address);
		
		psmt3.executeUpdate();
		
		psmt3.close();
		conn.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	// 목록 이등
	response.sendRedirect("../list.jsp");
%>