package dao;

import java.util.ArrayList;
import java.util.List;

import dto.StudentDTO;
import util.DBHelper;

public class StudentDAO extends DBHelper {
	
	private static final StudentDAO INSTANCE = new StudentDAO();
	public static StudentDAO getInstance() {
		return INSTANCE;
	}
	private StudentDAO() {}
	
	// 기본 CRUD
	public StudentDTO select(String stdNo) {
		
		StudentDTO dto = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM STUDENT WHERE stdNo=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setStdName(rs.getString(2));
				dto.setStdHp(rs.getString(3));
				dto.setStdYear(rs.getInt(4));
				dto.setStdAddress(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public StudentDTO select(String stdNo, String stdName) {
		
		StudentDTO dto = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM STUDENT WHERE stdNo=? AND stdName=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			psmt.setString(2, stdName);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setStdName(rs.getString(2));
				dto.setStdHp(rs.getString(3));
				dto.setStdYear(rs.getInt(4));
				dto.setStdAddress(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public List<StudentDTO> selectAll() {
		
		List<StudentDTO> dtoList = new ArrayList<StudentDTO>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM STUDENT");
			
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setStdName(rs.getString(2));
				dto.setStdHp(rs.getString(3));
				dto.setStdYear(rs.getInt(4));
				dto.setStdAddress(rs.getString(5));
				
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	public void insert(StudentDTO dto) {
		try {
			conn = getConnection();
			String sql = "INSERT INTO STUDENT VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getStdNo());
			psmt.setString(2, dto.getStdName());
			psmt.setString(3, dto.getStdHp());
			psmt.setInt(4, dto.getStdYear());
			psmt.setString(5, dto.getStdAddress());
			
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(StudentDTO dto) {
		try {
			conn = getConnection();
			String sql = "UPDATE STUDENT SET stdName=?, stdHp=?, stdYear=?, stdAddress=? WHERE stdNo=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getStdName());
			psmt.setString(2, dto.getStdHp());
			psmt.setInt(3, dto.getStdYear());
			psmt.setString(4, dto.getStdAddress());
			psmt.setString(5, dto.getStdNo());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(String stdNo) {
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "DELETE FROM STUDENT WHERE stdNo='"+stdNo+"'";
			stmt.executeUpdate(sql);
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
