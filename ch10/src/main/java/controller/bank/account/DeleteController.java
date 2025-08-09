package controller.bank.account;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.bank.AccountService;

@WebServlet("/bank/account/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AccountService service = AccountService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acc_no = req.getParameter("acc_no");

		service.delete(acc_no);
		
		resp.sendRedirect("/ch10/bank/account/list.do");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
