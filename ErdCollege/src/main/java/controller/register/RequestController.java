package controller.register;

import java.io.IOException;

import dto.RegisterDTO;
import dto.StudentDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.RegisterService;

@WebServlet("/register/request.do")
public class RequestController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private RegisterService service = RegisterService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String lecNo = req.getParameter("lecNo");
		
		// 서비스 요청을 위한 DTO 생성
		HttpSession session = req.getSession();
		StudentDTO sessStudent = (StudentDTO) session.getAttribute("sessStudent");
		String stdNo = sessStudent.getStdNo();
		
		RegisterDTO dto = new RegisterDTO();
		dto.setRegStdNo(stdNo);
		dto.setRegLecNo(lecNo);
		
		// 서비스 요청
		service.insert(dto);
		
		// 수강 목록 이동
		resp.sendRedirect("/ErdCollege/lecture/list.do");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
