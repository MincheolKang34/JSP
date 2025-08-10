package controller.bank.customer;

import java.io.IOException;

import dto.bank.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bank.CustomerService;

@WebServlet("/bank/customer/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CustomerService service = CustomerService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/bank/customer/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String c_id = req.getParameter("c_id");
		String c_name = req.getParameter("c_name");
		String c_type = req.getParameter("c_type");
		String c_hp = req.getParameter("c_hp");
		String c_addr = req.getParameter("c_addr");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setC_id(c_id);
		dto.setC_name(c_name);
		dto.setC_type(c_type);
		dto.setC_hp(c_hp);
		dto.setC_addr(c_addr);
		
		service.register(dto);
		
		resp.sendRedirect("/ch10/bank/customer/list.do");
	}
}
