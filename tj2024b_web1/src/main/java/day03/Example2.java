package day03;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example2")
public class Example2 extends HttpServlet {

	@Override // HTTP , POST , URL : http://localhost:8080/tj2024b_web1/day03/example2
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println( req.getReader() );
		//System.out.println( req.getReader().readLine() ); // 한번만 읽임.
		
        ObjectMapper objectMapper = new ObjectMapper();
        DataDto data = objectMapper.readValue( req.getReader() , DataDto.class);

        System.out.println( data );
       
	}
	@Override // HTTP , PUT , URL : http://localhost:8080/tj2024b_web1/day03/example2
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println( req.getReader() );
		//System.out.println( req.getReader().readLine() );
		
        ObjectMapper objectMapper = new ObjectMapper();
        DataDto data = objectMapper.readValue( req.getReader() , DataDto.class);

        System.out.println( data );
	}
}


