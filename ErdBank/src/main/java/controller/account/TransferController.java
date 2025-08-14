package controller.account;

import java.io.IOException;

import dto.AccountDTO;
import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.AccountService;
import service.CustomerService;

@WebServlet("/account/transfer.do")
public class TransferController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AccountService service = AccountService.INSTANCE;
	private CustomerService service2 = CustomerService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 사용자 주민번호 세션에서 가져오기
		HttpSession session = req.getSession();
		CustomerDTO sessCustomer = (CustomerDTO) session.getAttribute("sessCustomer");
		String c_no = sessCustomer.getC_no();
		
		// 사용자 조회
		CustomerDTO customerDTO = service2.findById(c_no);
		
		// 공유참조
		req.setAttribute("customerDTO", customerDTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/transfer.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String a_no_from = req.getParameter("a_no_from");
		String a_no_to = req.getParameter("a_no_to");
		String a_amount = req.getParameter("a_amount");
		String c_name = req.getParameter("c_name");
	}
}
