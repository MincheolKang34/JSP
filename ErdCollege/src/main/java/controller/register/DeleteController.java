package controller.register;

import java.io.IOException;

import dto.StudentDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.RegisterService;

@WebServlet("/register/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private RegisterService service = RegisterService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		StudentDTO sessStudent = (StudentDTO) session.getAttribute("sessStudent");
		String regStdNo = sessStudent.getStdNo();
		
		String regLecNo = req.getParameter("regLecNo");
		
		int regLecNoInt = 0;
		if(regLecNo != null) 
			regLecNoInt = Integer.parseInt(regLecNo);
		
		service.delete(regStdNo, regLecNoInt);
		
		resp.sendRedirect("/ErdCollege/register/list.do");
	}	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
