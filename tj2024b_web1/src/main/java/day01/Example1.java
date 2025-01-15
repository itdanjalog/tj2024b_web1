package day01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("http://192.168.40.25:8080/tj2024b_web1/day01/example1") : URL : 절대경로
@WebServlet("/day01/example1") // : URL : 상대경로(프로젝트명 생략 가능)
public class Example1 extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("안녕 나는 서블릿이야1.");
	}
}
