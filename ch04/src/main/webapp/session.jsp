<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>session</title>
		<%--
			날짜 : 2025.07.29.
			이름 : 강민철
			내용 : JSP 세션 실습하기
		--%>
	</head>
	<body>
		<h3>session 실습</h3>	
		
		<h4>session ID 확인</h4>
		<p>
			session 객체 ID값 : <%= session.getId() %><br/>
			request session : <%= request.getSession().getId() %>
		</p>
		<form action="./proc/sessionLogin.jsp" method="post">
			<input type="text" name="id" placeholder="아이디 입력"/><br/>
			<input type="password" name="pw" placeholder="비밀번호 입력"/><br/>
			<input type="submit" value="로그인"/>			
		</form>
	</body>
</html>