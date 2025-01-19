package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example1")
public class Example1 extends HttpServlet {

	@Override // HTTP , POST , URL : http://localhost:8080/tj2024b_web1/day03/example1?data1=유재석&data2=30
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP GET METHOD]");
		String data1 = req.getParameter("data1");
		int data2 = Integer.parseInt( req.getParameter("data2") ) ;
		System.out.println( "data1 : " + data1 );
		System.out.println( "data2 : " + data2 );
	}
	
	@Override // HTTP , POST , URL : http://localhost:8080/tj2024b_web1/day03/example1?data1=유재석&data2=30
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP POST METHOD]");
		String data1 = req.getParameter("data1");
		int data2 = Integer.parseInt( req.getParameter("data2") ) ;
		System.out.println( "data1 : " + data1 );
		System.out.println( "data2 : " + data2 );
	}
	
	@Override // HTTP , PUT , URL : http://localhost:8080/tj2024b_web1/day03/example1?data1=유재석&data2=30
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP PUT METHOD]");
		String data1 = req.getParameter("data1");
		int data2 = Integer.parseInt( req.getParameter("data2") ) ;
		System.out.println( "data1 : " + data1 );
		System.out.println( "data2 : " + data2 );
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP DELETE METHOD]");
		String data1 = req.getParameter("data1");
		int data2 = Integer.parseInt( req.getParameter("data2") ) ;
		System.out.println( "data1 : " + data1 );
		System.out.println( "data2 : " + data2 );
	}
	
	
	
	
	
}
