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

import dto.User6DTO;

// DAO(Data Access Objcet) : DB 처리를 수행하는 객체
public class User6DAO {

	// DAO는 기본 싱글톤
	private final static User6DAO INSTANCE = new User6DAO();
	public static User6DAO getInstance() {
		return INSTANCE;
	}
	
	private User6DAO() {}
	
	// 기본 CRUD 메서드
	public void insertUser6(User6DTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			// 시퀀스 생성 여부 체크
			Connection conn = ds.getConnection();
			Statement psmt1 = conn.createStatement();
			String sql1 = "SELECT sequence_name FROM user_sequences WHERE sequence_name = 'SEQ_USER6'";
			ResultSet rs = psmt1.executeQuery(sql1);
			
			// 시퀀스 없을 시 생성(테이블에 데이터를 처음 넣는 경우)
			if(!(rs.next())) {
				String sql2 = "CREATE SEQUENCE seq_user6 INCREMENT BY 1 START WITH 1";
				PreparedStatement psmt2 = conn.prepareStatement(sql2);
				psmt2.executeUpdate();
				psmt2.close();
			}
			rs.close();
			psmt1.close();
			
			String sql3 = "INSERT INTO USER6 VALUES (seq_user6.nextval,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql3);
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
	public User6DTO selectUser6(String seq) {
		
		User6DTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			String sql = "SELECT * FROM USER6 WHERE seq=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User6DTO();
				dto.setSeq(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setAddr(rs.getString(5));
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<User6DTO> selectAllUser6() {
		
		List<User6DTO> dtoList = new ArrayList<User6DTO>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM USER6";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User6DTO dto = new User6DTO();
				dto.setSeq(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setAddr(rs.getString(5));
				
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
	public void updateUser6(User6DTO dto) {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
			
			Connection conn = ds.getConnection();
			
			String sql = "UPDATE USER6 SET name=?, gender=?, age=?, addr=? WHERE seq=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			psmt.setInt(5, dto.getSeq());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteUser6(String seq) {
		
	try {
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup("jdbc/mincheolkang34");
		
		Connection conn = ds.getConnection();
		
		String sql = "DELETE FROM USER6 WHERE seq=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, seq);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
