package controller.bank.customer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bank.CustomerService;

@WebServlet("/bank/customer/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CustomerService service = CustomerService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String c_id = req.getParameter("c_id");
		
		service.delete(c_id);
		
		resp.sendRedirect("/ch10/bank/customer/list.do");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
