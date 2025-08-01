package controller.college.student;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.StudentService;

@WebServlet("/college/student/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 서비스 객체 가져오기
	private StudentService service = StudentService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		List<CustomerDTO> dtoList = service.findAll();
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/college/student/list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
}
