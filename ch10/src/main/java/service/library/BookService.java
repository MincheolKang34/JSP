package service.library;

import java.util.List;

import dao.library.BookDAO;
import dto.library.BookDTO;

public enum BookService {
	INSTANCE;
	
	private BookDAO dao = BookDAO.getInstance();
	
	public void register(BookDTO dto) {
		dao.insertBook(dto);
	}
	
	public BookDTO findByBook_id(String book_id) {
		return dao.selectBook(book_id);
	}
	
	public List<BookDTO> findAll() {
		return dao.selectAllBook();
	}
	
	public void modify(BookDTO dto) {
		dao.updateBook(dto);
	}
	
	public void delete(String book_id) {
		dao.deleteBook(book_id);
	}
}
