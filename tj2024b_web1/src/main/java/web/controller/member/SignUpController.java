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

@WebServlet("/member/signup")
public class SignUpController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" signup POST OK ");
		// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue( req.getReader() , MemberDto.class);
		System.out.println( "memberDto : " + memberDto );
		// 2.[ 데이터 유효성검사 ]
		// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
		boolean result = MemberDao.getInstance().signup(memberDto);
		// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
		// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}


// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
// 2.[ 데이터 유효성검사 ]
// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]