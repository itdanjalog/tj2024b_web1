package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" signup POST OK ");
		// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class);
		
		HttpSession session = req.getSession();// - (1) 세션 객체불러오기
		Object object = session.getAttribute("loginMno"); // -(2) 세션의 속성 값을 불러오기
		
//		if( object != null ){ // -(3) 속성값이 존재하면 속성값 제거한다->로그아웃 
//			boardDto.setMno( (Integer)object );
//		}
		boardDto.setMno( 1 );
		
		// 2.[ 데이터 유효성검사 ]
		// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
		int result = BoardDao.getInstance().write(boardDto);
		// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
		// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cno = Integer.parseInt( req.getParameter("cno") ) ;
		int page = Integer.parseInt( req.getParameter("page") ) ;
		
        if( page < 1 ){ page = 1 ; }
        
        int display = 3 ; // - 하나의 페이지당 3개씩 표시
        // 2. 페이지당 게시물을 출력할 시작레코드 번호
        int startRow = ( page - 1) *  display ;
		
		Object result = BoardDao.getInstance().findByCno( cno , startRow , display );
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( result );
		
		resp.setContentType("application/json");
		resp.getWriter().print( jsonResult );
	}
}
