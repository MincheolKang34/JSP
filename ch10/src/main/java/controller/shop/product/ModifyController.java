package controller.shop.product;

import java.io.IOException;

import dto.shop.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.ProductService;

public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductService productService = ProductService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pno = req.getParameter("pno");
		
		ProductDTO dto = productService.findByPno(pno);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/ch10/WEB-INF/views/shop/product/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pno = getInitParameter("pno");
		String pname = getInitParameter("pname");
		String stock = getInitParameter("stock");
		String price = getInitParameter("price");
		String company = getInitParameter("company");
		
		ProductDTO dto = new ProductDTO();
		dto.setPno(pno);
		dto.setPname(pname);
		dto.setStock(stock);
		dto.setPrice(price);
		dto.setCompany(company);
		
		productService.modify(dto);
		
		resp.sendRedirect("/ch10/WEB-INF/views/shop/product/list.jsp");
		super.doPost(req, resp);
	}
}
