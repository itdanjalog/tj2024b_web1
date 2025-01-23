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
public class MemberInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. HTTP BODY 로 요청된 데이터들을 JSON --> DTO로 변환 
		System.out.println(" /member/info GET OK ");
		
		HttpSession httpSession = req.getSession();
		Object object = httpSession.getAttribute( "loginDto" );
		
		resp.setContentType("application/json");
		if( object != null ) {
			MemberDto loginDto = (MemberDto)object;
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString( loginDto );
			resp.getWriter().print( jsonResult );	
		}else {
			resp.getWriter().print( object );	
		}
	// 3. 결과 응답
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" /member/info PUT OK ");
		
		// 1. HTTP BODY 로 요청된 데이터들을 JSON --> DTO로 변환 
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto =  mapper.readValue( req.getReader() , MemberDto.class );
		// 2. DAO 처리 
		boolean result = MemberDao.getInstance().update( memberDto );
		// 3. 결과 응답
		resp.setContentType("application/json");
		resp.getWriter().print( result );	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" /member/info POST OK ");
		
		// 1. HTTP BODY 로 요청된 데이터들을 JSON --> DTO로 변환 
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto =  mapper.readValue( req.getReader() , MemberDto.class );
		// 2. DAO 처리 
		boolean result = MemberDao.getInstance().delete( memberDto );
		// 3. 결과 응답
		resp.setContentType("application/json");
		resp.getWriter().print( result );	
		
	}
	
}





