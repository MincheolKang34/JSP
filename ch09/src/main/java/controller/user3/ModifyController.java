package controller.user3;

import java.io.IOException;

import dto.User3DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User3Service;

@WebServlet("/user3/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private User3Service service = User3Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전송 데이터 수신
		String user_id = req.getParameter("user_id");
		
		// 수정 데이터 조회
		User3DTO user3DTO = service.findById(user_id);
		
		// request 객체로 조회 데이터 공유
		req.setAttribute("user3DTO", user3DTO);
		
		// 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user3/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전송 데이터 수신
		String user_id = req.getParameter("user_id");
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		String age = req.getParameter("age");
		
		// 서비스 전달을 위한 DTO 생성
		User3DTO dto = new User3DTO();
		dto.setUser_id(user_id);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAge(age);
		
		// 서비스 호출
		service.modify(dto);
		
		// 이동
		resp.sendRedirect("/ch09/user3/list.do");
	}

}
