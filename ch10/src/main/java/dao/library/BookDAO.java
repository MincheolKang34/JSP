package dao.library;

import java.util.ArrayList;
import java.util.List;

import dto.library.BookDTO;
import util.DBHelper;

public class BookDAO extends DBHelper {

	private static final BookDAO INSTANCE = new BookDAO();
	public static BookDAO getInstance() {
		return INSTANCE;
	}
	private BookDAO() {}
	
	private final String DBCP = "jdbc/library";
	
	public void insertBook(BookDTO dto) {
		try {
			conn = getConnection(DBCP);
			String sql = "INSERT INTO BOOK VALUES (?,?,?,?,?,SYSDATE)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getBook_id());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getAuthor());
			psmt.setString(4, dto.getPublisher());
			psmt.setString(5, dto.getAvailable());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BookDTO selectBook(String book_id) {
		BookDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM BOOK WHERE book_id="+book_id;
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dto = new BookDTO();
				dto.setBook_id(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setPublisher(rs.getString(4));
				dto.setAvailable(rs.getString(5));
				dto.setReg_date(rs.getString(6));
			}
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<BookDTO> selectAllBook() {
		List<BookDTO> dtoList = new ArrayList<BookDTO>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM BOOK";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setBook_id(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setPublisher(rs.getString(4));
				dto.setAvailable(rs.getString(5));
				dto.setReg_date(rs.getString(6));
				
				dtoList.add(dto);
			}
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void updateBook(BookDTO dto) {
		try {
			conn = getConnection(DBCP);
			String sql = "UPDATE BOOK SET title=?, author=?, publisher=?, available=?, reg_date=? WHERE book_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getAuthor());
			psmt.setString(3, dto.getPublisher());
			psmt.setString(4, dto.getAvailable());
			psmt.setTimestamp(5, java.sql.Timestamp.valueOf(dto.getReg_date()));
			psmt.setInt(6, dto.getBook_id());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook(String book_id) {
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "DELETE FROM BOOK WHERE book_id="+book_id;
			stmt.executeUpdate(sql);
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
