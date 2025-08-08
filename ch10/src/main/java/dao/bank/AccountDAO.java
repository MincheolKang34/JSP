package dao.bank;

import java.util.ArrayList;
import java.util.List;

import dto.bank.AccountDTO;
import util.DBHelper;

public class AccountDAO extends DBHelper {
	private static final AccountDAO INSTANCE = new AccountDAO();
	public static AccountDAO getInstance() {
		return INSTANCE;
	}
	private AccountDAO() {}
	
	private final String DBCP = "jdbc/bank";
	
	public void insertAccount(AccountDTO dto) {
		try {
			conn = getConnection(DBCP);
			String sql = "INSERT INTO ACCOUNT VALUES (?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getAcc_no());
			psmt.setString(2, dto.getAcc_type());
			psmt.setString(3, dto.getAcc_name());
			psmt.setString(4, dto.getAcc_cid());
			psmt.setInt(5, dto.getAcc_balance());
			psmt.setString(6, dto.getAcc_date());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AccountDTO selectAccount(String acc_no) {
		AccountDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM ACCOUNT WHERE acc_no='"+acc_no+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dto = new AccountDTO();
				dto.setAcc_no(rs.getString(1));
				dto.setAcc_type(rs.getString(2));
				dto.setAcc_name(rs.getString(3));
				dto.setAcc_cid(rs.getString(4));
				dto.setAcc_balance(rs.getInt(5));
				dto.setAcc_date(rs.getString(6));
			}
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<AccountDTO> selectAllAccount() {
		List<AccountDTO> dtoList = new ArrayList<AccountDTO>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			String sql = "SELECT * FROM ACCOUNT";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setAcc_no(rs.getString(1));
				dto.setAcc_type(rs.getString(2));
				dto.setAcc_name(rs.getString(3));
				dto.setAcc_cid(rs.getString(4));
				dto.setAcc_balance(rs.getInt(5));
				dto.setAcc_date(rs.getString(6));
				
				dtoList.add(dto);
			}
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void updateAccount(AccountDTO dto) {
		
	}
	
	public void deleteAccount(String acc_no) {
		
	}
}
