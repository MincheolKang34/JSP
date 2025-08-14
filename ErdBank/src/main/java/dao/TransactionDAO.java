package dao;

import java.util.ArrayList;
import java.util.List;

import dto.TransactionDTO;
import util.DBHelper;
import util.Sql;

public class TransactionDAO extends DBHelper {

	private static final TransactionDAO INSTANCE = new TransactionDAO();
	public static TransactionDAO getInstance() {
		return INSTANCE;
	}
	private TransactionDAO() {}
	
	public void insert(TransactionDTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_TRANSACTION);
			psmt.setString(1, dto.getT_a_no());
			psmt.setInt(2, dto.getT_dist());
			psmt.setInt(3, dto.getT_amount());
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public TransactionDTO select(String t_no) {
		return null;
	}
	public List<TransactionDTO> selectAll() {
		List<TransactionDTO> dtoList = new ArrayList<TransactionDTO>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM BANK_TRANSACTION");
			
			while(rs.next()) {
				TransactionDTO dto = new TransactionDTO();
				dto.setT_no(rs.getInt(1));
				dto.setT_a_no(rs.getString(2));
				dto.setT_dist(rs.getInt(3));
				dto.setT_amount(rs.getInt(4));
				dto.setT_datetime(rs.getString(5));
				
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	public void update(TransactionDTO dto) {
		
	}
	public void delete(String t_no) {
		
	}
}
