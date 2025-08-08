package service.college;

import java.util.List;

import dao.college.CourseDAO;
import dto.college.CourseDTO;

public enum CourseService {

	INSTANCE;
	
	private CourseDAO dao = CourseDAO.getInstance();
	
	public void register(CourseDTO dto) {
		dao.insertCourse(dto);
	}
	public CourseDTO findByCs_id(String cs_id) {
		return dao.selectCourse(cs_id);
	}
	public List<CourseDTO> findAll() {
		return dao.selectAllCourse();
	}
	public void modify(CourseDTO dto) {
		dao.updateCourse(dto);
	}
	public void delete(String cs_id) {
		dao.deleteCourse(cs_id);
	}
}
