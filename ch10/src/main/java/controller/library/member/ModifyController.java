package controller.library.member;

import java.io.IOException;

import dto.library.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.library.MemberService;

@WebServlet("/library/member/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private MemberService service = MemberService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String member_id = req.getParameter("member_id");
		
		MemberDTO dto = service.findByMember_id(member_id);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/library/member/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String member_id = req.getParameter("member_id");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String hp = req.getParameter("hp");
		String join_date = req.getParameter("join_date");
		join_date = join_date.replace('T', ' '); // datetime-local은 YYYY-MM-DDThh:mm:ss 형식으로 입력됨.
		if(join_date.substring(16) == "") // 00초일 경우 생략됨.
			join_date = join_date + ":00";
		
		MemberDTO dto = new MemberDTO();
		dto.setMember_id(member_id);
		dto.setName(name);
		dto.setAddress(address);
		dto.setHp(hp);
		dto.setJoin_date(join_date);
		
		service.modify(dto);
		
		resp.sendRedirect("/ch10/library/member/list.do");
	}
}
