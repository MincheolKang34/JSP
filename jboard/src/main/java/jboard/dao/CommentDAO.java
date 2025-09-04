package jboard.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jboard.dto.CommentDTO;
import jboard.util.DBHelper;
import jboard.util.Sql;

public class CommentDAO extends DBHelper {

	private final static CommentDAO INSTANCE = new CommentDAO();
	public static CommentDAO getInstance() {
		return INSTANCE;
	}
	private CommentDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insert(CommentDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
			psmt.setInt(1, dto.getAno());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getReg_ip());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	public CommentDTO select(int cno) {
		return null;
	}
	public List<CommentDTO> selectAll() {
		return null;
	}
	public void update(CommentDTO dto) {
		
	}
	public void delete(int cno) {
		
	}
}
