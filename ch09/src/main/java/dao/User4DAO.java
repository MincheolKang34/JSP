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

import dto.User4DTO;

// DAO(Data Access Objcet) : DB 처리를 수행하는 객체
public class User4DAO {

	// DAO는 기본 싱글톤
	private final static User4DAO INSTANCE = new User4DAO();
	public static User4DAO getInstance() {
		return INSTANCE;
	}
	
	private User4DAO() {}
	
	// 기본 CRUD 메서드
	public void insertUser4(User4DTO dto) {
		
		try {
			//Connection conn = DriverManager.getConnection(null, null, null);
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			String sql = "INSERT INTO USER4 VALUES (?,?,?,?)";
			conn.prepareStatement(sql);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public User4DTO selectUser4(String name) {
		
		User4DTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			String sql = "SELECT * FROM USER4 WHERE name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User4DTO();
				dto.setName(rs.getString(1));
				dto.setGender(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setAddr(rs.getString(4));
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<User4DTO> selectAllUser4() {
		
		List<User4DTO> dtoList = new ArrayList<User4DTO>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM USER4";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User4DTO dto = new User4DTO();
				dto.setName(rs.getString(1));
				dto.setGender(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setAddr(rs.getString(4));
				
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
	public void updateUser4(User4DTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			
			String sql = "UPDATE USER4 SET gender=?, age=?, addr=? WHERE name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getGender());
			psmt.setInt(2, dto.getAge());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getName());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteUser4(String name) {
		
	try {
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
		
		Connection conn = ds.getConnection();
		
		String sql = "DELETE FROM USER4 WHERE name=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
