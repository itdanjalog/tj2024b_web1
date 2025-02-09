package web.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;
import web.model.dto.PageDto;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	
	// [1] 게시물 쓰기 컨트롤러 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println( "board post ok ");
		// JSON 문자열 --> 특정한 자바 객체 타입으로 변환 기능을 제공하는 라이브러리 객체 생성 
		ObjectMapper mapper = new ObjectMapper(); 
		// HTTP 의 request Body 로 부터 JSON 문자열을 읽어와서 BoardDto 타입으로 변환하는 readValue 함수 실행 
		BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class );
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
		boolean result = BoardDao.getInstance().write( boardDto );
		// HTTP 로 부터 response 
		resp.setContentType( "application/json" );
		resp.getWriter().print( result );
	} // f end 
	
	// [2] 게시물 전체 조회 컨트롤러 ( 02/07 +추가 : 카테고리별 )
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" board get ok ");

		
		// -------------- 카테고리 별 출력 -------------//
					// 1. 카테고리 매개변수 요청 [ cno ]	2.gettotalsize()/getBoardList() 조건 전달 
					int cno = Integer.parseInt( req.getParameter("cno") );
					
					// -------------- 검색 처리 -----------------//
					// 1. 검색에 필요한 매개변수 요청[ key, keyword ]   2.gettotalsize/getBoardList 조건 전달
//					String key = req.getParameter("key");			
//					String keyword = req.getParameter("keyword");
					
					// ------------- page 처리 --------------- //
					// 1. 현재페이지[요청] , 2.페이지당 표시할게시물수 3.현재페이지[ 게시물시작  ]
					int page = Integer.parseInt( req.getParameter("page") );
					int display = 10;
					//int listsize = Integer.parseInt( request.getParameter("listsize") ) ; // 화면에 표시할 게시물수 요청
					int startrow = (page-1)*display; // 해당 페이지에서의 게시물 시작번호 = 검색된 결과의 레코드중 인덱스번호
					// ------------- page 버튼 만들기 ------------ //
					// 1. 전체페이지수[ 총게시물레코드수/페이지당 표시수 ] 2. 페이지 표시할 최대버튼수 3. 시작버튼/마지막버튼 번호 
						// 1. 검색이 없을때 
					int totalsize = BoardDao.getInstance().gettotalsize( cno );
						// 2. 검색이 있을때
					// int totalsize = BoardDao.getInstance().gettotalsize( key , keyword , cno );
					
					int totalpage = totalsize % display == 0 ? 	// 만약에 나머지가 0 이면 
									totalsize/display :  totalsize/display+1;
					int btnsize = 5; // 최대 페이징버튼 출력수
					int startbtn = ( (page-1) / btnsize ) * btnsize +1 ; 
					int endbtn = startbtn + (btnsize-1);
					// * 단 마지막버튼수가 총페이지수보다 커지면 마지막버튼수 총페이지수로 대입 
					if( endbtn > totalpage ) endbtn = totalpage;
					
					// ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList( startrow , listsize );
//					ArrayList<Object> result 
//						= BoardDao.getInstance().findAll( startrow , listsize , key , keyword , cno );

					Object result 
					= BoardDao.getInstance().findAll( cno , startrow , display );
					
					// page Dto 만들기 
					PageDto pageDto 
						= new PageDto(page, display, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
					
					// java 형식 ---> js형식 
					ObjectMapper mapper = new ObjectMapper();
					String jsonArray =  mapper.writeValueAsString( pageDto );
					// 응답
					resp.setCharacterEncoding("UTF-8");
					resp.setContentType("applcation/json");
					resp.getWriter().print( jsonArray );
					
					
		
		
		
	} // f end 
	
	// [3] 게시물 개별 삭제 컨트롤러 
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" board delete ok ");
		// [1] HTTP queryString 매개변수를 가져오기 , URL?bno=1 , req.getParameter("매개변수명") : 반환타입 문자열 이므로 타입변환 필요할 수 있다.
			// Integer.parseInt( "문자열") : 문자열 타입 --> 정수 타입 변환 함수.
		int bno = Integer.parseInt( req.getParameter("bno") ) ;
		// [2] Dao 에게 삭제할 번호를 전달하고 결과 받기 
		boolean result = BoardDao.getInstance().delete( bno );
		// [3] 결과를 HTTP의 response 로 응답하기 
		resp.setContentType("application/json");	
		resp.getWriter().print(result);  
	}
	
	// [4] 게시물 개별 수정 컨트롤러 
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" board put ok ");
		// [1] 
		ObjectMapper mapper = new ObjectMapper(); 
		// [2]
		BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class );
		// [3]
		boolean result = BoardDao.getInstance().update( boardDto );
		// [4]
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
} // class end 































