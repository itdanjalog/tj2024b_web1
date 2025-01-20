package day04;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day04/example1")
public class Example1 extends HttpServlet {
	
	@Override // http://localhost:8080/tj2024b_web1/day04/example1?value1=123&value2=123
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 
		String value1 = req.getParameter("value1");
		int value2 = Integer.parseInt( req.getParameter("value2") );
		System.out.println( "value1 : " + value1 );
		System.out.println( "value2 : " + value2 );
		
		// 2. 
		boolean result = true;
		resp.setContentType("application/json");
		resp.getWriter().print( result );
	
	} // f end 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// 1. 
		ValueDto valueDto = mapper.readValue( req.getReader() , ValueDto.class );
		System.out.println( valueDto );
		
		// 2. 
		ValueDto valueDto2 = new ValueDto("유재석", 40);
		String result = mapper.writeValueAsString(valueDto2);
		resp.setContentType("application/json");
		resp.getWriter().print( result );
		
	}// f end 
	
} // class end 
