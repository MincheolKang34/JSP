package controller.shop.customer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import dto.shop.CustomerDTO;
//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.CustomerService;

@WebServlet("/shop/customer/delete.do")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CustomerService service = CustomerService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cid = req.getParameter("cid");
		
		service.delete(cid);
		
		logger.info("DeleteController doPost : "+cid);
		
		resp.sendRedirect("/ch10/shop/customer/list.do");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	
}
