<%@page import="dto.FileDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	List<FileDTO> files = new ArrayList<>();

	try {
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
		Connection conn = ds.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM FILES");
		
		while(rs.next()){
			FileDTO dto = new FileDTO();
			dto.setNo(rs.getInt(1));
			dto.setTitle(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setOname(rs.getString(4));
			dto.setSname(rs.getString(5));
			dto.setRdate(rs.getString(6));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>fileDownload</title>
		<!-- 
			날짜 : 2025.07.30.
			이름 : 강민철
			내용 : JSP 파일 업로드 실습하기
		 -->
	</head>
	<body>
		<h3>파일 다운로드</h3>	
		
		<a href="/ch06/fileupload.jsp">파일 업로드</a>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>파일명</th>
				<th>관리</th>
			</tr>
			<tr>
				<td>1</td>
				<td>파일 업로드 테스트</td>
				<td>김유신</td>
				<td>세부훈련시간표.pdf</td>
				<td>
					<a href="#">삭제</a>
					<a href="#">다운로드</a>
				</td>
			</tr>
		</table>
	</body>
</html>