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

/*
{
  "mid" : "qweqwe",
  "mpwd" : "123123"
}
*/
@WebServlet("/member/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto  = mapper.readValue( req.getReader(), MemberDto.class);
		System.out.println("[1] check : " + memberDto );
		// 2. 
		int result = MemberDao.getInstance().login(memberDto);
		System.out.println("[2] check : " + result );
		// 3. 
		if( result > 0  ) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute( "loginMno" , result  );
		}
		// 4. 
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		httpSession.removeAttribute( "loginMno");
		// 4. 
		resp.setContentType("application/json");
		resp.getWriter().print(true);
		
	}
	
	
} // class end 






















