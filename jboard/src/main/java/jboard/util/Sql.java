package jboard.util;

public class Sql {

	// terms
	public static final String SELECT_TERMS = "SELECT * FROM TB_TERMS where no=?";
	
	// user
	public static final String SELECT_COUNT = "SELECT COUNT(*) FROM TB_USER";
	public static final String WHERE_USID = " WHERE USID=?";
	public static final String WHERE_NICK = " WHERE NICK=?";
	public static final String WHERE_EMAIL = " WHERE EMAIL=?";
	public static final String WHERE_HP = " WHERE HP=?";
	
	public static final String SELECT_USER_BY_PASS = "SELECT * FROM TB_USER WHERE USID=? AND PASS=STANDARD_HASH(?, 'SHA256')";
	
	public static final String INSERT_USER = "INSERT INTO TB_USER (USID, PASS, US_NAME, NICK, EMAIL, HP, ZIP, ADDR1, ADDR2, REG_IP, REG_DATE) "
												+ "VALUES (?,STANDARD_HASH(?, 'SHA256'),?,?,?,?,?,?,?,?,SYSDATE)";
	
	public static final String INSERT_ARTICLE = "INSERT INTO TB_ARTICLE (TITLE, CONTENT, FILE_CNT, WRITER, REG_IP, WDATE) VALUES (?,?,?,?,?,sysdate)";
}
