package day03.task3;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/visit2")
public class VisitController extends HttpServlet {
	// 1. 방문록 등록 		: POST		, url : http://localhost:8080/tj2024b_web1/day03/visit2	
	// 매개변수 : BODY					, 매개변수 예] { "content":"안녕" , "age" : 30 }
	// 반환타입 : application/json 	, 매개변수 예] true/false
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로 부터 요청(request) 받은 HTTP HEADER BODY(본문) 를 DTO 파싱(변환) 가져오기.
		ObjectMapper mapper = new ObjectMapper();
		VisitDto visitDto = mapper.readValue( req.getReader() , VisitDto.class );
		// 2. DAO 처리 
		boolean result = VisitDao.getInstance().write(visitDto);
		// 3. DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response) 보내기 
		resp.setContentType("application/json");   	// (1) 응답할 자료의 타입 명시 
		resp.getWriter().print(result);				// (2) 응답 자료 보내기. 
	} // f end 
	
	// 2. 방문록 전체조회 	: GET		, url : http://localhost:8080/tj2024b_web1/day03/visit2	
	// 매개변수 : X
	// 반환타입 : application/json		, 매개변수 예] [ { "num" : 1 , "content":"안녕1" , "age" : 30 } , { "num" : 2 , "content":"안녕2" , "age" : 20 }  ]
	
	
	// 3. 방문록 수정 		: PUT 		, url : http://localhost:8080/tj2024b_web1/day03/visit2	
	// 매개변수 : BODY 				, 매개변수 예] { "num" : 3 , "content":"수정안녕" , "age" : 40 }
	// 반환타입 : application/json		, 매개변수 예] true
	
	
	// 4. 방문록 삭제 		: DELETE 	, url : http://localhost:8080/tj2024b_web1/day03/visit2?num=1
	// 매개변수 : queryString 			, 매개변수 예 ] ?num=1
	// 반환타입 : application/json		, 매개변수 예] true
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP로 부터 요청(request) 받은 HTTP queryString 의 매개변수 가져오기
		int num = Integer.parseInt( req.getParameter("num") );
		// 2. DAO 처리 
		boolean result = VisitDao.getInstance().delete(num);
		// 3. DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response) 보내기
		resp.setContentType("application/json");
		resp.getWriter().print( result );
	}
	
} // f end 







