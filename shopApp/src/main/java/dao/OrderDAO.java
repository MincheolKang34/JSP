package dao;

import java.util.ArrayList;
import java.util.List;

import dto.OrderDTO;
import util.DBHelper;

public class OrderDAO extends DBHelper {

	private static final OrderDAO INSTANCE = new OrderDAO();
	public static OrderDAO getInstance() {
		return INSTANCE;
	}
	private OrderDAO() {}
	
	
	// 기본 CRUD 메서드
	public void insertOrder(OrderDTO dto) {
		
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO \"Order\" (ORDERID,ORDERPRODUCT,ORDERCOUNT,ORDERDATE) VALUES (?,?,?,SYSDATE)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getOrderId());
			psmt.setInt(2, dto.getOrderProduct());
			psmt.setInt(3, dto.getOrderCount());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public OrderDTO selectOrder(int orderid) {
		return null;
	}
	
	public List<OrderDTO> selectAllOrder() {
		
		List<OrderDTO> dtoList = new ArrayList<OrderDTO>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM \"Order\"";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setOrderId(rs.getString(1));
				dto.setOrderProduct(rs.getInt(2));
				dto.setOrderCount(rs.getInt(3));
				dto.setOrderDate(rs.getString(4));
				dto.setOrderNo(rs.getInt(5));
				
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void updateOrder(OrderDTO dto) {}
	
	public void deleteOrder(int orderid) {}
}
