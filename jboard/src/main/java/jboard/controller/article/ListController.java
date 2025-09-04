package jboard.controller.article;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jboard.dto.ArticleDTO;
import jboard.dto.PagenationDTO;
import jboard.service.ArticleService;

@WebServlet("/article/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ArticleService articleService = ArticleService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 페이지 번호 수신
		String pg = req.getParameter("pg");
		
		// 페이지네이션 처리 요청
		PagenationDTO pagenationDTO = articleService.getPagenationInfo(pg, null, null);
		
		List<ArticleDTO> dtoList = articleService.findAll(pagenationDTO.getStart());
		
		req.setAttribute("pagenationDTO", pagenationDTO);
		req.setAttribute("dtoList", dtoList);
		
		logger.debug("article/ListController");
		logger.debug(pagenationDTO.toString());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/article/list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
