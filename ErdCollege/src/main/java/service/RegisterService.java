package service;

import java.util.List;

import dao.RegisterDAO;
import dto.RegisterDTO;

public enum RegisterService {

	INSTANCE;
	
	private RegisterDAO dao = RegisterDAO.getInstance();
	
	public RegisterDTO select(String regStdNo, int regLecNo) {
		return dao.select(regStdNo, regLecNo);
	}
	public List<RegisterDTO> selectAll(String regStdNo) {
		return dao.selectAll(regStdNo);
	}
	public void insert(RegisterDTO dto) {
		dao.insert(dto);
	}
	public void update(RegisterDTO dto) {
		dao.update(dto);
	}
	public void delete(String regStdNo, int regLecNo) {
		dao.delete(regStdNo, regLecNo);
	}
}
