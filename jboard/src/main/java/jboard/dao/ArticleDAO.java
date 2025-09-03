package jboard.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jboard.dto.ArticleDTO;
import jboard.util.DBHelper;
import jboard.util.Sql;

public class ArticleDAO extends DBHelper {

	private final static ArticleDAO INSTANCE = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return INSTANCE;
	}
	private ArticleDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insert(ArticleDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getFile_cnt());
			psmt.setString(4, dto.getWriter());
			psmt.setString(5, dto.getReg_ip());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	public ArticleDTO select(int ano) {
		return null;
	}
	public List<ArticleDTO> selectAll() {
		return null;
	}
	public void update(ArticleDTO dto) {
		
	}
	public void delete(int ano) {
		
	}
}
