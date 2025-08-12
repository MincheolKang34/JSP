package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User2DTO;
import util.DBHelper;

public class User2DAO extends DBHelper {

	private static final User2DAO INSTANCE = new User2DAO();
	public static User2DAO getInstance() {
		return INSTANCE;
	}
	private User2DAO() {}
	
	private final String DBCP = "jdbc/studydb";
	
	// 기본 CRUD 메서드
	public void insertUser2(User2DTO dto) {
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO user2 VALUES (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getAddr());
			psmt.executeUpdate();
			
			closeAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public User2DTO selectUser2(String uid) {
		User2DTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM USER2 WHERE uid='"+uid+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dto = new User2DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setAddr(rs.getString(4));
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public List<User2DTO> selectAllUser2() {

		List<User2DTO> dtoList = new ArrayList<User2DTO>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM user2");
			
			while(rs.next()) {
				User2DTO dto = new User2DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setAddr(rs.getString(4));
				
				dtoList.add(dto);
			}
			
			closeAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	public void updateUser2(User2DTO dto) {
		try {
			conn = getConnection(DBCP);
			String sql = "UPDATE USER2 SET name=?, birth=?, addr=? WHERE uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getBirth());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getUid());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteUser2(String uid) {
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "DELETE FROM USER2 WHERE uid='"+uid+"'";
			stmt.executeUpdate(sql);
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
