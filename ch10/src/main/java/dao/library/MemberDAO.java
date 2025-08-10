package dao.library;

import java.util.ArrayList;
import java.util.List;

import dto.library.MemberDTO;
import util.DBHelper;

public class MemberDAO extends DBHelper {

	private static final MemberDAO INSTANCE = new MemberDAO();
	public static MemberDAO getInstance() {
		return INSTANCE;
	}
	private MemberDAO() {}
	
	private final String DBCP = "jdbc/library";
	
	public void insertMember(MemberDTO dto) {
		try {
			conn = getConnection(DBCP);
			String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,SYSDATE)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getMember_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getHp());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO selectMember(String member_id) {
		MemberDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MEMBER WHERE member_id="+member_id;
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMember_id(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setJoin_date(rs.getString(5));
			}
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public List<MemberDTO> selectAllMember() {
		List<MemberDTO> dtoList = new ArrayList<MemberDTO>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MEMBER";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMember_id(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAddress(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setJoin_date(rs.getString(5));
				
				dtoList.add(dto);
			}
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void updateMember(MemberDTO dto) {
		try {
			conn = getConnection(DBCP);
			String sql = "UPDATE MEMBER SET name=?, address=?, hp=?, join_date=? WHERE member_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getAddress());
			psmt.setString(3, dto.getHp());
			// YYYY-MM-DD HH:mm:ss 문자열을 setString으로 넣으면 컬럼 타입이 DATETIME일 때 "리터럴 형식이 맞지 않음" 오류 발생
			// JDBC에서 날짜/시간 값을 문자열로 직접 넣으면 DB 엔진이 타입 변환에 실패하는 경우가 많기 때문.
			// PreparedStatement에서는 JDBC 타입 매칭이 엄격하기 때문에,
			// 날짜/시간 형식의 컬럼에는 java.sql.Timestamp나 java.sql.Date 등 맞는 타입 객체를 써야 정상적으로 동작
			psmt.setTimestamp(4, java.sql.Timestamp.valueOf(dto.getJoin_date()));
			psmt.setInt(5, dto.getMember_id());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMember(String member_id) {
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "DELETE FROM MEMBER WHERE member_id="+member_id;
			stmt.executeUpdate(sql);
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
