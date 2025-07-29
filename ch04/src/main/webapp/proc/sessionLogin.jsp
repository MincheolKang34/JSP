<%@page import="vo.UserVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 데이터베이스 사용자 조회 후 사용자 객체 생성
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPw(pw);
	vo.setName("김유신");
	vo.setAge(23);
	
	// abc123, 1234 회원 간주
	if(vo != null){
		// 사용자가 회원이면 세션에 사용자 객체 저장
		session.setAttribute("sessUser", vo);
		
		// 리다이렉트(페이지 이동)
		response.sendRedirect("./sessionSuccess.jsp");
	}else{
		// 사용자가 회원이 아니면 다시 로그인 화면이동
		response.sendRedirect("../session.jsp");
	}
%>