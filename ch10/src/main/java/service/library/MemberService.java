package service.library;

import java.util.List;

import dao.library.MemberDAO;
import dto.library.MemberDTO;

public enum MemberService {
	INSTANCE;
	
	private MemberDAO dao = MemberDAO.getInstance();
	

	public void register(MemberDTO dto) {
		dao.insertMember(dto);
	}
	
	public MemberDTO findByMember_id(String member_id) {
		return dao.selectMember(member_id);
	}
	
	public List<MemberDTO> findAll() {
		return dao.selectAllMember();
	}
	
	public void modify(MemberDTO dto) {
		dao.updateMember(dto);
	}
	
	public void delete(String member_id) {
		dao.deleteMember(member_id);
	}
}
