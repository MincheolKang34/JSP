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

@WebServlet("/library/book/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private BookService service = BookService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/library/book/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String book_id = req.getParameter("book_id");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String available = req.getParameter("available");
		
		BookDTO dto = new BookDTO();
		dto.setBook_id(book_id);
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setPublisher(publisher);
		dto.setAvailable(available);
		
		service.register(dto);
		
		resp.sendRedirect("/ch10/library/book/list.do");
	}
}
