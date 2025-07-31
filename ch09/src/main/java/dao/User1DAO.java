package dao;

import java.util.List;

import dto.User1DTO;

// DAO(Data Access Objcet) : DB 처리를 수행하는 객체
public class User1DAO {

	// DAO는 기본 싱글톤
	private static User1DAO INSTANCE = new User1DAO();
	
	public static User1DAO getInstance() {
		return INSTANCE;
	}
	
	private User1DAO() {}
	
	// 기본 CRUD 메서드
	public void insertUser1(User1DTO dto) {}
	public User1DTO selectUser1(String user_id) {
		return null;
	}
	public List<User1DTO> selectAllUser1() {
		return null;
	}
	public void updateUser1(User1DTO dto) {}
	public void deleteUser1(String user_id) {}
}
