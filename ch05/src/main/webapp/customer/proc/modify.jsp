<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String cid = request.getParameter("cid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String address = request.getParameter("address");
	String rdate = request.getParameter("rdate");
		
	try {
		// 자바 기본 환경객체 검색(WAS 환경)
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		
		// jdbc/mincheolkang34 커넥션풀 검색
		DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
		Connection conn = ds.getConnection();
				
		Statement stmt = conn.createStatement();
		
		String sql = "UPDATE CUSTOMER SET name='" + name+ "', hp='" + hp + "', address='" + address + "', ";
			   sql += "rdate='" + rdate + "' WHERE cid='"+cid+"'";
		
		stmt.executeUpdate(sql);
		
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	// 목록이동
	response.sendRedirect("../list.jsp");
%>