package controller.college.course;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.CourseService;

@WebServlet("/college/course/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CourseService service = CourseService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cs_id = req.getParameter("cs_id");
		
		service.delete(cs_id);
		
		resp.sendRedirect("/ch10/college/course/list.do");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
