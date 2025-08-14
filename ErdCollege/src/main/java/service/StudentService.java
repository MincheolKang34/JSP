package service;

import java.util.List;

import dao.StudentDAO;
import dto.StudentDTO;

public enum StudentService {

	INSTANCE;
	
	private StudentDAO dao = StudentDAO.getInstance();
	
	public StudentDTO findById(String stdNo) {
		return dao.select(stdNo);
	}
	public StudentDTO findByIdAndName(String stdNo, String stdName) {
		return dao.select(stdNo, stdName);
	}
	public List<StudentDTO> selectAll() {
		return dao.selectAll();
	}
	public void insert(StudentDTO dto) {
		dao.insert(dto);
	}
	public void update(StudentDTO dto) {
		dao.update(dto);
	}
	public void delete(String stdNo) {
		dao.delete(stdNo);
	}
}
