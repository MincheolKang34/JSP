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
import jboard.service.ArticleService;

@WebServlet("/article/search.do")
public class SearchListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ArticleService articleService = ArticleService.INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchType = req.getParameter("searchType");
		String keyword = req.getParameter("keyword");
		
		List<ArticleDTO> dtoList = articleService.findAllSearch(searchType, keyword);
		
		req.setAttribute("dtoList", dtoList);
		
		logger.debug("SearchListController"+dtoList.get(0).toString());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/article/searchList.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
