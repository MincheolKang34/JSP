<%@page import="vo.UserVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 로그아웃 처리 : 현재 세션 sessUser값 제거 및 session 무효화
	session.removeAttribute("sessUser");
	session.invalidate();
	
	// 페이지 이동
	response.sendRedirect("../session.jsp");
%>