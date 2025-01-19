package day03.webBoard1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import day03.DataDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/board")
public class BoardController extends HttpServlet {

	
/*
http://localhost:8080/tj2024b_web1/day03/board
{
  "btitle" : "제목1",
  "bcontent" : "내용1",
  "bwriter" : "작성자1",
  "bpwd" : "비밀번호1"
}  
*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 매개변수
		// 2. Dto 변환 
		ObjectMapper objectMapper = new ObjectMapper();
        BoardDto boardDto = objectMapper.readValue( req.getReader() , BoardDto.class);
        
        // 요청 본문을 HashMap으로 변환 //JSON 데이터가 중첩 구조라면 LinkedHashMap이나 List로 처리됩니다.
        // HashMap<String, Object> requestData = objectMapper.readValue(req.getReader(), HashMap.class);

		// 3. dao 처리 
		boolean result = BoardDao.getInstance().write(boardDto);
		// 4. 응답 처리 
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print( result );
	}
/*
http://localhost:8080/tj2024b_web1/day03/board
*/
	@Override // http://localhost:8080/tj2024b_web1/day03/board
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
		
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(result);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print( jsonResult );
		
	}
/*
http://localhost:8080/tj2024b_web1/day03/board
{
  "bno" : 1, 
  "btitle" : "제목2",
  "bcontent" : "내용2"
}  
*/
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 매개변수
		// 2. Dto 변환 
		ObjectMapper objectMapper = new ObjectMapper();
        BoardDto boardDto = objectMapper.readValue( req.getReader() , BoardDto.class);
		// 3. dao 처리 
		boolean result = BoardDao.getInstance().update(boardDto);
		// 4. 응답 처리 
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print( result );
	}

/*
http://localhost:8080/tj2024b_web1/day03/board?bno=1
*/
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 매개변수
		// 2. Dto 변환 
		int bno = Integer.parseInt( req.getParameter("bno") );
		// 3. dao 처리 
		boolean result = BoardDao.getInstance().delete(bno);
		// 4. 응답 처리 
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print( result );
	}
	
}











