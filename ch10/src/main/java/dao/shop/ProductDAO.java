package dao.shop;

import java.util.ArrayList;
import java.util.List;

import dto.shop.ProductDTO;
import util.DBHelper;

public class ProductDAO extends DBHelper{
	private static final ProductDAO INSTANCE = new ProductDAO();
	public static ProductDAO getInstance() {
		return INSTANCE;
	}
	private ProductDAO() {};
	
	private final String DBCP = "jdbc/shop";
	
	public void insertProduct(ProductDTO dto) {
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO PRODUCT VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getPno());
			psmt.setString(2, dto.getPname());
			psmt.setInt(3, dto.getStock());
			psmt.setInt(4, dto.getPrice());
			psmt.setString(5, dto.getCompany());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ProductDTO selectProduct(String pno) {
		return null;
	}
	public List<ProductDTO> selectAllProduct() {
		
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		
		try {
			
			conn = getConnection(DBCP);
			
			stmt = conn.createStatement();
			String sql = "SELECT * FROM PRODUCT";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setPno(rs.getInt(1));
				dto.setPname(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));
				
				dtoList.add(dto);
			}
			
			closeAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	public void updateProduct(ProductDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "UPDATE PRODUCT SET pname=?, stock=?, price=?, company=? WHERE pno=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPname());
			psmt.setInt(2, dto.getStock());
			psmt.setInt(3, dto.getPrice());
			psmt.setString(4, dto.getCompany());
			psmt.setInt(5, dto.getPno());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteProduct(String pno) {
		
	}
}
