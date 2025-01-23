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

@WebServlet("/member/login")
public class MemberLogin extends HttpServlet {
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(" /member/login POST OK ");
		// 1. HTTP BODY 로 요청된 데이터들을 JSON --> DTO로 변환 
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto =  mapper.readValue( req.getReader() , MemberDto.class );
		// 2. DAO 처리 
		MemberDto result = MemberDao.getInstance().login( memberDto );
		resp.setContentType("application/json");
		if( result !=null ) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute( "loginDto" , result  );
			resp.getWriter().print( true );	
		}else {
			resp.getWriter().print( false );	
		}
		
		
		
	}
}
