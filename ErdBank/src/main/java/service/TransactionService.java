package service;

import java.util.List;

import dao.TransactionDAO;
import dto.TransactionDTO;

public enum TransactionService {

	INSTANCE;
	
	private TransactionDAO dao = TransactionDAO.getInstance();

	public void register(TransactionDTO dto) {
		dao.insert(dto);
	}
	public TransactionDTO find(String t_no) {
		return dao.select(t_no);
	}
	public List<TransactionDTO> findAll() {
		return dao.selectAll();
	}
	public void modify(TransactionDTO dto) {
		dao.update(dto);
	}
	public void delete(String t_no) {
		dao.delete(t_no);
	}
}
