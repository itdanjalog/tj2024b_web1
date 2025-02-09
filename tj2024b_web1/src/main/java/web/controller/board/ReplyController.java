package web.controller.board;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.ReplyDto;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		int bno = Integer.parseInt( req.getParameter("bno") );
		
		Object object = BoardDao.getInstance().findReply( bno );
		
		// java 형식 ---> js형식 
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray =  mapper.writeValueAsString( object );
		// 응답
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("applcation/json");
		resp.getWriter().print( jsonArray );
	}
	
	// [1] 게시물 쓰기 컨트롤러 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println( "board post ok ");
		// JSON 문자열 --> 특정한 자바 객체 타입으로 변환 기능을 제공하는 라이브러리 객체 생성 
		ObjectMapper mapper = new ObjectMapper(); 
		// HTTP 의 request Body 로 부터 JSON 문자열을 읽어와서 BoardDto 타입으로 변환하는 readValue 함수 실행 
		ReplyDto boardDto = mapper.readValue( req.getReader() , ReplyDto.class );
			// + 현재 로그인된 회원번호를 세션에서 찾아 boardDto 담아주기.
			// 요청 정보의 세션 객체 호출 
			HttpSession session = req.getSession();
			// 세션 객체내 특정한 속성(로그인된 회원번호)의 값 꺼내기 , .getAttribute("속성명"); , 모든 세션 객체내 속성의 타입은 Object 이다.
			Object object = session.getAttribute("loginMno" );
			// 세션 객체내 로그인된 회원번호 속성이 존재하면 
			if( object != null ) {
				// Object 타입 --> int/Integer 타입으로 변환하기.
				int loginMno = (Integer)object;
				// boardDto 에 로그인된 회워번호 담아주기 , 게시물 작성자 == 로그인된 회원 
				boardDto.setMno( loginMno );
			} // if end 
		// 읽어온 자료를 dao 에게 전달하고 결과를 받는다. 
		boolean result = BoardDao.getInstance().ReplyWrite(  boardDto );
		// HTTP 로 부터 response 
		resp.setContentType( "application/json" );
		resp.getWriter().print( result );
	} // f end 
	
	
	

}
