package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/example2")
public class Example2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드 요청이 왔습니다.");
		System.out.println( req.getParameter("value1") );
		System.out.println( req.getParameter("value2") );
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 메소드 요청이 왔습니다.");
		System.out.println( req.getParameter("value1") );
		System.out.println( req.getParameter("value2") );
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPut 메소드 요청이 왔습니다.");
		System.out.println( req.getParameter("value1") );
		System.out.println( req.getParameter("value2") );
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doDelete 메소드 요청이 왔습니다.");
		System.out.println( req.getParameter("value1") );
		System.out.println( req.getParameter("value2") );
	}
	
}
