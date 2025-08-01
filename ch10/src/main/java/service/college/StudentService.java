package service.college;

import java.util.List;

import dao.college.StudentDAO;
import dto.college.StudentDTO;

public enum StudentService {

	INSTANCE;
	
	private final String DBCP = "college/student";
	
	private StudentDAO dao = StudentDAO.getInstance();
	
	public void register(String stdNo) {
		dao.insertStudent(stdNo);
	}
	public List<StudentDTO> findById() {
		return dao.selectStudent();
	}
	public void findAll() {
		
	}
	public void modify() {
		try {
			conn = getConnection(DBCP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete() {
		try {
			conn = getConnection(DBCP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
