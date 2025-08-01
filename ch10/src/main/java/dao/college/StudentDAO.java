package dao.college;

import java.util.ArrayList;
import java.util.List;

import dto.college.StudentDTO;
import util.DBHelper;

public class StudentDAO extends DBHelper {

	private static final StudentDAO INSTANCE = new StudentDAO();
	public static StudentDAO getInstance() {
		return INSTANCE;
	}
	private StudentDAO() {}
	
	private final String DBCP = "college/student";
	
	public void insertStudent(String stdNo) {
		try {
			conn = getConnection(DBCP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<StudentDTO> selectStudent() {
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		
		try {
			conn = getConnection(DBCP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void selectAllStudent() {
		try {
			conn = getConnection(DBCP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateStudent() {
		try {
			conn = getConnection(DBCP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteStudent() {
		try {
			conn = getConnection(DBCP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
