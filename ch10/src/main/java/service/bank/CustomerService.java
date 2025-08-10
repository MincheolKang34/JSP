package service.bank;

import java.util.List;

import dao.bank.CustomerDAO;
import dto.bank.CustomerDTO;

public enum CustomerService {

	INSTANCE;
	
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	public void register(CustomerDTO dto) {
		dao.insertCustomer(dto);
	}
	
	public CustomerDTO findByC_id(String c_id) {
		return dao.selectCustomer(c_id);
	}
	
	public List<CustomerDTO> findAll() {
		return dao.selectAllCustomer();
	}
	
	public void modify(CustomerDTO dto) {
		dao.updateCustomer(dto);
	}
	
	public void delete(String c_id) {
		dao.deleteCustomer(c_id);
	}
}
