package controller.student;

import java.io.IOException;

import dto.StudentDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.StudentService;

@WebServlet("/student/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	StudentService service = StudentService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		StudentDTO sessStudent = (StudentDTO) session.getAttribute("sessStudent");
		String stdNo = sessStudent.getStdNo();
		
		service.delete(stdNo);
		
		resp.sendRedirect("/ErdCollege/student/list.do");
	}
}
