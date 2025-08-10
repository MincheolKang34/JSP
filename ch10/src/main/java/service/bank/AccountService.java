package service.bank;

import java.util.List;

import dao.bank.AccountDAO;
import dto.bank.AccountDTO;

public enum AccountService {
	INSTANCE;
	
	private AccountDAO dao = AccountDAO.getInstance();
	
	public void register(AccountDTO dto) {
		dao.insertAccount(dto);
	}
	
	public AccountDTO findByAcc_no(String acc_no) {
		return dao.selectAccount(acc_no);
	}
	
	public List<AccountDTO> findAll() {
		return dao.selectAllAccount();
	}
	
	public void modify(AccountDTO dto) {
		dao.updateAccount(dto);
	}
	
	public void delete(String acc_no) {
		dao.deleteAccount(acc_no);
	}
}
