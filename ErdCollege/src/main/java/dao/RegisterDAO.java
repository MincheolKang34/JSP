package dao;

import java.util.ArrayList;
import java.util.List;

import dto.RegisterDTO;
import util.DBHelper;

public class RegisterDAO extends DBHelper {

	private static final RegisterDAO INSTANCE = new RegisterDAO();
	public static RegisterDAO getInstance() {
		return INSTANCE;
	}
	private RegisterDAO() {}
	
	// 기본 CRUD
	public RegisterDTO select(String regStdNo, int regLecNo) {
		return null;
	}
	public List<RegisterDTO> selectAll(String regStdNo) {
		List<RegisterDTO> dtoList = new ArrayList<RegisterDTO>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM REGISTER WHERE REGSTDNO='"+regStdNo+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				RegisterDTO dto = new RegisterDTO();
				dto.setRegStdNo(rs.getString(1));
				dto.setRegLecNo(rs.getInt(2));
				dto.setRegMidScore(rs.getInt(3));
				dto.setRegFinalScore(rs.getInt(4));
				dto.setRegTotalScore(rs.getInt(5));
				dto.setRegGrade(rs.getString(6));
				
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	public void insert(RegisterDTO dto) {
		
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO REGISTER (REGSTDNO, REGLECNO) VALUES(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getRegStdNo());
			psmt.setInt(2, dto.getRegLecNo());
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(RegisterDTO dto) {
		
	}
	public void delete(String regStdNo, int regLecNo) {
		try {
			conn = getConnection();
			String sql = "DELETE FROM REGISTER WHERE REGSTDNO=? AND REGLECNO=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, regStdNo);
			psmt.setInt(2, regLecNo);
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
