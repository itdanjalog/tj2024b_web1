package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;


//{
//	  "mid" : "qweqwe",
//	  "mpwd" : "123123",
//	  "mname" : "유재석",
//	  "mphone" : "010-3333-3333"
//	}  
@WebServlet("/member/signup")
public class Signup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto  = mapper.readValue( req.getReader(), MemberDto.class);
		System.out.println("[1] check : " + memberDto );
		// 2. 
		boolean result = MemberDao.getInstance().signup(memberDto);
		System.out.println("[2] check : " + result );
		// 3. 
		// 4. 
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	} // f end 
} // class end 
