package dao;

import java.util.List;

import dto.StudentDTO;
import util.DBHelper;

public class StudentDAO extends DBHelper {
	
	private static final StudentDAO INSTANCE = new StudentDAO();
	public static StudentDAO getInstance() {
		return INSTANCE;
	}
	private StudentDAO() {}
	
	// 기본 CRUD
	public StudentDTO select(String stdNo) {
		return null;
	}
	public List<StudentDTO> selectAll() {
		
		return null;
	}
	public void insert(StudentDTO dto) {
		
	}
	public void update(StudentDTO dto) {
		
	}
	public void delete(String stdNo) {
		
	}
}
