package controller.js.user1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.User1DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/js/user1/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private User1Service service = User1Service.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/js/user1/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// JSON 수신(GSON 라이브러리 활용) -> Spring Boot에서는 자동 처리
		BufferedReader reader = req.getReader();
		StringBuilder requestBody = new StringBuilder();
		String line;
		
		while((line = reader.readLine()) != null) {
			requestBody.append(line);
		}
		
		reader.close();
		
		// Gson을 이용한 DTO 생성
		Gson gson = new Gson();
		User1DTO dto = gson.fromJson(requestBody.toString(), User1DTO.class);
		
		System.out.println(dto);
		
		// 서비스 요청
		service.modify(dto);
		
		// JSON 출력
		JsonObject json = new JsonObject();
		json.addProperty("result", 1);
		
		// JSON 출력(클라이언트 전송)
		resp.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(json.toString());
	}
}
