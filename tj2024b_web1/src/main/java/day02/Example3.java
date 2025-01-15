package day02;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/example3")
public class Example3 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 // ObjectMapper를 사용하여 JSON -> DTO 변환
        ObjectMapper objectMapper = new ObjectMapper();
        MyDataDTO data = objectMapper.readValue( req.getReader() , MyDataDTO.class);

        System.out.println( data );
        
        // Jackson을 사용해 객체를 JSON으로 변환
        String jsonResponse = objectMapper.writeValueAsString(data);

        // 응답 설정
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
		
	}
	
	
}
