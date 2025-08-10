package controller.bank.account;

import java.io.IOException;

import dto.bank.AccountDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bank.AccountService;

@WebServlet("/bank/account/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AccountService service = AccountService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acc_no = req.getParameter("acc_no");
		
		AccountDTO dto = service.findByAcc_no(acc_no);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/bank/account/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acc_no = req.getParameter("acc_no");
		String acc_type = req.getParameter("acc_type");
		String acc_name = req.getParameter("acc_name");
		String acc_cid = req.getParameter("acc_cid");
		String acc_balance = req.getParameter("acc_balance");
		String acc_date = req.getParameter("acc_date");
		
		AccountDTO dto = new AccountDTO();
		dto.setAcc_no(acc_no);
		dto.setAcc_type(acc_type);
		dto.setAcc_name(acc_name);
		dto.setAcc_cid(acc_cid);
		dto.setAcc_balance(acc_balance);
		dto.setAcc_date(acc_date);
		
		service.modify(dto);
		
		resp.sendRedirect("/ch10/bank/account/list.do");
	}
}
