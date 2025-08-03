package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.User3DTO;

// DAO(Data Access Objcet) : DB 처리를 수행하는 객체
public class User3DAO {

	// DAO는 기본 싱글톤
	private final static User3DAO INSTANCE = new User3DAO();
	public static User3DAO getInstance() {
		return INSTANCE;
	}
	
	private User3DAO() {}
	
	// 기본 CRUD 메서드
	public void insertUser3(User3DTO dto) {
		
		try {
			//Connection conn = DriverManager.getConnection(null, null, null);
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			String sql = "INSERT INTO USER3 VALUES (?,?,?,?)";
			conn.prepareStatement(sql);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public User3DTO selectUser3(String user_id) {
		
		User3DTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			String sql = "SELECT * FROM USER3 WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User3DTO();
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<User3DTO> selectAllUser3() {
		
		List<User3DTO> dtoList = new ArrayList<User3DTO>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM USER3";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User3DTO dto = new User3DTO();
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
				
				dtoList.add(dto);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void updateUser3(User3DTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			
			String sql = "UPDATE USER3 SET name=?, hp=?, age=? WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getUser_id());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteUser3(String user_id) {
		
	try {
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
		
		Connection conn = ds.getConnection();
		
		String sql = "DELETE FROM USER3 WHERE user_id=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, user_id);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
