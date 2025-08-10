package controller.library.book;

import java.io.IOException;

import dto.library.BookDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.library.BookService;

@WebServlet("/library/book/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private BookService service = BookService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String book_id = req.getParameter("book_id");
		
		BookDTO dto = service.findByBook_id(book_id);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/library/book/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String book_id = req.getParameter("book_id");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String available = req.getParameter("available");
		String reg_date = req.getParameter("reg_date");
		reg_date = reg_date.replace('T', ' '); // datetime-local은 YYYY-MM-DDThh:mm:ss 형식으로 입력됨.
		if(reg_date.substring(16) == "") // 00초일 경우 생략됨.
			reg_date = reg_date + ":00";
		
		BookDTO dto = new BookDTO();
		dto.setBook_id(book_id);
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setPublisher(publisher);
		dto.setAvailable(available);
		dto.setReg_date(reg_date);
		
		service.modify(dto);
		
		resp.sendRedirect("/ch10/library/book/list.do");
	}
}
