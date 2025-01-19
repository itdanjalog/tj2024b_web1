package day03;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example4")
public class Example4 extends HttpServlet {

	@Override // http://localhost:8080/tj2024b_web1/day03/example4?data1=123&data2=123
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP GET METHOD]");
		String data1 = req.getParameter("data1");
		int data2 = Integer.parseInt( req.getParameter("data2") ) ;
		System.out.println( "data1 : " + data1 );
		System.out.println( "data2 : " + data2 );
		
		boolean result = true;
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print( result );
	}
	
	@Override // http://localhost:8080/tj2024b_web1/day03/example4?data1=123&data2=123
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP POST METHOD]");
		String data1 = req.getParameter("data1");
		int data2 = Integer.parseInt( req.getParameter("data2") ) ;
		System.out.println( "data1 : " + data1 );
		System.out.println( "data2 : " + data2 );
		
		String result = "자바";
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print( result );
	}
	
	@Override // http://localhost:8080/tj2024b_web1/day03/example4?data1=123&data2=123
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP PUT METHOD]");
		String data1 = req.getParameter("data1");
		int data2 = Integer.parseInt( req.getParameter("data2") ) ;
		System.out.println( "data1 : " + data1 );
		System.out.println( "data2 : " + data2 );
		
		int result = 35 ;
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print( result );
	}
	
	@Override // http://localhost:8080/tj2024b_web1/day03/example4?data1=123&data2=123
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP DELETE METHOD]");
		String data1 = req.getParameter("data1");
		int data2 = Integer.parseInt( req.getParameter("data2") ) ;
		System.out.println( "data1 : " + data1 );
		System.out.println( "data2 : " + data2 );
		
		DataDto result = new DataDto( "유재석" , 40 );
		
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(result);

        
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print( jsonResult );
		
	}
	
	
	
	
	
}
