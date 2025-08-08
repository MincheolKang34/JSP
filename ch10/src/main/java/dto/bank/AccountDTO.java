package dto.bank;

public class AccountDTO {
	private String acc_no;
	private String acc_type;
	private String acc_name;
	private String acc_cid;
	private int acc_balance;
	private String acc_date;
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public String getAcc_cid() {
		return acc_cid;
	}
	public void setAcc_cid(String acc_cid) {
		this.acc_cid = acc_cid;
	}
	public int getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(int acc_balance) {
		this.acc_balance = acc_balance;
	}
	public void setAcc_balance(String acc_balance) {
		if(acc_balance != null)
			this.acc_balance = Integer.parseInt(acc_balance);
	}
	public String getAcc_date() {
		return acc_date;
	}
	public void setAcc_date(String acc_date) {
		this.acc_date = acc_date;
	}
	
	@Override
	public String toString() {
		return "AccountDTO [acc_no=" + acc_no + ", acc_type=" + acc_type + ", acc_name=" + acc_name + ", acc_cid="
				+ acc_cid + ", acc_balance=" + acc_balance + ", acc_date=" + acc_date + "]";
	}
}
