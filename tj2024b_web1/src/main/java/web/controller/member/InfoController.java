package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@WebServlet("/member/info")
public class InfoController extends HttpServlet {

	// [ 내(로그인된) 회원 정보 조회 ]
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
		// 2.[ 데이터 유효성검사 ]
		// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
		MemberDto result = null;
			// (1) 현재 로그인된 회원의 번호 : 세션객체내 존재. 속성명 : loginMno
		HttpSession session = req.getSession(); // 세션객체 가져오기.
		Object object = session.getAttribute("loginMno"); // 세션객체내 지정한 속성 값 가져오기.
			// (2) 만약에 세션객체내 지정한 속성값이 존재하면 로그인회원번호를 타입변환한다. 
		if( object != null ) {
			int loginMno = (Integer)object; 
			// (3) 현재 로그인된 회원번호를 매개변수로 전달한다.
			result = MemberDao.getInstance().myInfo(loginMno);
			// * 내 포인트 조회
			int mpoint = MemberDao.getInstance().getPoint(loginMno);
			result.setMpoint( mpoint );
		}
		// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString( result );
		// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]
		resp.setContentType("application/json");
		resp.getWriter().print( jsonResult );
	} // f end 
	
	// [ 내(로그인된) 회원 탈퇴 ]
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
		// 2.[ 데이터 유효성검사 ]
		// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
		boolean result = false;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if( object != null ) {
			int loginMno = (Integer)object;
			result = MemberDao.getInstance().delete(loginMno);
			if( result == true ) {	// 만약에 회원탈퇴를 성공했다면 
				session.removeAttribute("loginMno"); // 세션객체내 속성제거 -> 로그아웃 
			}
		}
		// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
		// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end 
	
	// [ 내(로그인된) 회원 정보 수정 ]
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue( req.getReader(), MemberDto.class );
		System.out.println( memberDto );
		// 2.[ 데이터 유효성검사 ]
		// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
		boolean result = false;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginMno");
		if( object != null ) {
			int loginMno = (Integer)object;
			memberDto.setMno(loginMno); // 조회된 로그인된 회원번호를 dto에 넣어주고.
			result = MemberDao.getInstance().update(memberDto);
		}
		// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
		// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end 
	
} // class end 
























