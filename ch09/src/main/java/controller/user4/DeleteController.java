package controller.user4;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User4Service;

@WebServlet("/user4/delete.do")
public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private User4Service service = User4Service.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전송 데이터 수신
		String name = req.getParameter("name");
		
		// 서비스 호출
		service.delete(name);
		
		// 이동
		resp.sendRedirect("/ch09/user4/list.do");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
