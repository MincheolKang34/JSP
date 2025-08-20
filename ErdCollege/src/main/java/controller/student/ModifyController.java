package controller.student;

import java.io.IOException;

import dto.StudentDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.StudentService;

@WebServlet("/student/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private StudentService service = StudentService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		StudentDTO sessStudent = (StudentDTO) session.getAttribute("sessStudent");
		String stdNo = sessStudent.getStdNo();
		
		StudentDTO dto = service.findById(stdNo);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/student/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stdNo = req.getParameter("stdNo");
		String stdName = req.getParameter("stdName");
		String stdHp = req.getParameter("stdHp");
		String stdYear = req.getParameter("stdYear");
		String stdAddress = req.getParameter("stdAddress");

		StudentDTO dto = new StudentDTO();
		dto.setStdNo(stdNo);
		dto.setStdName(stdName);
		dto.setStdHp(stdHp);
		dto.setStdYear(stdYear);
		dto.setStdAddress(stdAddress);
		
		service.update(dto);
		
		resp.sendRedirect("/ErdCollege/student/list.do");
	}
}
