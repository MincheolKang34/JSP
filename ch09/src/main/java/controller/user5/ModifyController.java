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

@WebServlet("/user5/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private User5Service service = User5Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전송 데이터 수신
		String name = req.getParameter("name");
		
		// 수정 데이터 조회
		User5DTO user5DTO = service.findByName(name);
		
		// request 객체로 조회 데이터 공유
		req.setAttribute("user5DTO", user5DTO);
		
		// 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user5/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전송 데이터 수신
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		// 서비스 전달을 위한 DTO 생성
		User5DTO dto = new User5DTO();
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		
		// 서비스 호출
		service.modify(dto);
		
		// 이동
		resp.sendRedirect("/ch09/user5/list.do");
	}

}
