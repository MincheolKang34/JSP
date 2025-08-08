package dao.college;

import java.util.ArrayList;
import java.util.List;

import dto.college.CourseDTO;
import util.DBHelper;

public class CourseDAO extends DBHelper {

	private static final CourseDAO INSTANCE = new CourseDAO();
	public static CourseDAO getInstance() {
		return INSTANCE;
	}
	private CourseDAO() {}
	
	private final String DBCP = "jdbc/college";
	
	public void insertCourse(CourseDTO dto) {
		try {
			conn = getConnection(DBCP);
			String sql = "INSERT INTO COURSE VALUES (?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getCs_id());
			psmt.setString(2, dto.getCs_name());
			psmt.setInt(3, dto.getCs_credit());
			psmt.setString(4, dto.getCs_dept());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public CourseDTO selectCourse(String cs_id) {
		CourseDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM COURSE WHERE cs_id="+cs_id;
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dto = new CourseDTO();
				dto.setCs_id(rs.getInt(1));
				dto.setCs_name(rs.getString(2));
				dto.setCs_credit(rs.getInt(3));
				dto.setCs_dept(rs.getString(4));
			}
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public List<CourseDTO> selectAllCourse() {
		List<CourseDTO> dtoList = new ArrayList<CourseDTO>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM COURSE";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CourseDTO dto = new CourseDTO();
				dto.setCs_id(rs.getInt(1));
				dto.setCs_name(rs.getString(2));
				dto.setCs_credit(rs.getInt(3));
				dto.setCs_dept(rs.getString(4));
				
				dtoList.add(dto);
			}
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	public void updateCourse(CourseDTO dto) {
		try {
			conn = getConnection(DBCP);
			String sql = "UPDATE COURSE SET cs_name=?, cs_credit=?, cs_dept=? WHERE cs_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCs_name());
			psmt.setInt(2, dto.getCs_credit());
			psmt.setString(3, dto.getCs_dept());
			psmt.setInt(4, dto.getCs_id());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteCourse(String cs_id) {
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "DELETE FROM COURSE WHERE cs_id="+cs_id;
			stmt.executeUpdate(sql);
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
