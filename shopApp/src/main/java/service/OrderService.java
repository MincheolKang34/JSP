package service;

import java.util.List;

import dao.OrderDAO;
import dto.OrderDTO;

public enum OrderService {

	INSTANCE;
	
	private OrderDAO dao = OrderDAO.getInstance();
	
	// DAO 요청메서드
	public void register(OrderDTO dto) {
		dao.insertOrder(dto);
	}
	
	public OrderDTO findById(int prodNo) {
		return dao.selectOrder(prodNo);
	}
	
	public List<OrderDTO> findAll() {
		return dao.selectAllOrder();
	}
	
	public void modify(OrderDTO dto) {
		dao.updateOrder(dto);
	}
	
	public void delete(int prodNo) {
		dao.deleteOrder(prodNo);
	}
}
