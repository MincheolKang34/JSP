package controller.college.course;

import java.io.IOException;

import dto.college.CourseDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.CourseService;

@WebServlet("/college/course/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CourseService service = CourseService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cs_id = req.getParameter("cs_id");
		
		CourseDTO dto = service.findByCs_id(cs_id);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/college/course/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cs_id = req.getParameter("cs_id");
		String cs_name = req.getParameter("cs_name");
		String cs_credit = req.getParameter("cs_credit");
		String cs_dept = req.getParameter("cs_dept");
		
		CourseDTO dto = new CourseDTO();
		dto.setCs_id(cs_id);
		dto.setCs_name(cs_name);
		dto.setCs_credit(cs_credit);
		dto.setCs_dept(cs_dept);
		
		service.modify(dto);
		
		resp.sendRedirect("/ch10/college/course/list.do");
	}
}
