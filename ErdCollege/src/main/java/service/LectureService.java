package service;

import java.util.List;

import dao.LectureDAO;
import dto.LectureDTO;

public enum LectureService {

	INSTANCE;
	
	private LectureDAO dao = LectureDAO.getInstance();
	
	public LectureDTO select(int lecNo) {
		return dao.select(lecNo);
	}
	public List<LectureDTO> selectAll() {
		return dao.selectAll();
	}
	public void insert(LectureDTO dto) {
		dao.insert(dto);
	}
	public void update(LectureDTO dto) {
		dao.update(dto);
	}
	public void delete(int lecNo) {
		dao.delete(lecNo);
	}
}
