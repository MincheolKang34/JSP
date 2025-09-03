package jboard.controller.article;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jboard.dto.ArticleDTO;
import jboard.service.ArticleService;

@WebServlet("/article/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ArticleService articleService = ArticleService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 페이지 번호 수신
		String pg = req.getParameter("pg");
		
		// 전체 게시물 갯수 구하기
		int total = articleService.getCountTotal();
		
		// 마지막 페이지 번호 구하기
		int lastPageNum = 0;
		if (total % 10 == 0) {
			lastPageNum = total / 10;     // 10으로 나누어 떨어짐
		}else {
			lastPageNum = total / 10 + 1; // 10으로 나누어 떨어지지 않음
		}
		
		// 현재 페이지 번호 시작값 구하기
		int page = 1;
		if (pg != null) {
			page = Integer.parseInt(pg);
		}
		int start = (page - 1) * 10;
		
		// 현재 페이지 그룹 구하기
		int currentPageGroup = (int) Math.ceil(page / 10.0);
		int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
		int pageGroupEnd = currentPageGroup * 10;
		
		if (pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		
		List<ArticleDTO> dtoList = articleService.findAll(start);
		
		req.setAttribute("dtoList", dtoList);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/article/list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
