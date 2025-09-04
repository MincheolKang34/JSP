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
	
	// article
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM TB_ARTICLE";
	public static final String SELECT_ARTICLE_ALL = "SELECT a.*, tu.NICK FROM tb_article a "
													+ "JOIN TB_USER tu ON a.WRITER = tu.USID "
													+ "ORDER BY ano DESC "
													+ "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
	
	public final static String SELECT_ARTICLE_BY_ANO_WITH_FILE = "SELECT ta.*, tu.NICK, tf.* FROM TB_ARTICLE ta "
																+ "JOIN TB_USER tu ON ta.WRITER = tu.USID "
																+ "LEFT JOIN TB_FILE tf ON ta.ANO = tf.ANO "
																+ "WHERE ta.ANO=?";
	
	public static final String SELECT_MAX_ANO = "SELECT max(ano) FROM TB_ARTICLE";
	public static final String INSERT_ARTICLE = "INSERT INTO TB_ARTICLE (TITLE, CONTENT, FILE_CNT, WRITER, REG_IP, WDATE) VALUES (?,?,?,?,?,sysdate)";
	public static final String INSERT_COMMENT = "INSERT INTO TB_COMMENT (ANO, CONTENT, WRITER, REG_IP, WDATE) "
												+ "	VALUES (?, ?, ?, ?, SYSDATE)";
	
	// file
	public static final String INSERT_FILE = "INSERT INTO tb_file (ano, oname, sname, rdate) VALUES (?,?,?,sysdate)";
	public static final String SELECT_FILE = "SELECT * FROM TB_FILE WHERE fno=?";
	public static final String UPDATE_FILE_DOWNLOAD = "UPDATE TB_FILE SET DOWNLOAD = DOWNLOAD + 1 WHERE FNO=?";
}
