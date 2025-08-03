package controller.user5;

import java.io.IOException;

import dto.User5DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User5Service;

@WebServlet("/user5/register.do")
public class RegisterController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	// Service 싱클톤 객체 가져오기
	private User5Service service = User5Service.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user5/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전송 데이터 수신
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		//서비스 전달을 위해 DTO 생성(전송 객체 생성)
		User5DTO dto = new User5DTO();
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		
		// 서비스 요청 (객체 전달)
		service.register(dto);
		
		// 이동
		resp.sendRedirect("/ch09/user5/list.do");
	}

}
