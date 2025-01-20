package day03;

import java.io.IOException;
import java.io.Reader;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example3")
public class Example3 extends HttpServlet {
	@Override
	// HTTP POST BODY : http://localhost:8080/day03/example3
	// content-type : application/json , body : { "data1" : "유재석" , "data2" : 40  }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// * JOSN자료의 문자열타입을 DTO로 변환해보기. ( JSON는 JS언어에서 사용하는 타입 , JAVA는 DTO 사용한다. )
		System.out.println( "[HTTP *POST 방식으로 요청이 왔어요.]");
		// System.out.println( req.getReader().readLine() ); // 단순한 문자열 읽어왔다.
		// 문자열 : { "data1" : "유재석" , "data2" : "40"  } --> DTO 변환 
		// JSON 모양의 문자열타입 자료를 DTO 로 변환 라이브러리가 필요하다. , jackson 3종 라이브러리 등록 
		ObjectMapper mapper = new ObjectMapper(); // ObjectMapper 인스턴스 생성 
		// req.getReader() 객체의 자료(JSON)들을 DTO 객체 로 변환 함수.
		// .readValue( JSON데이터자료 , 변환할객체타입.class );
		DataDto dataDto = mapper.readValue( req.getReader() , DataDto.class  ); 
		System.out.println( dataDto );
		// DTO : DataDto [data1=유재석, data2=40]
	} // f end 
	@Override
	// HTTP PUT BODY : http://localhost:8080/day03/example3
	// content-type : application/json , body : { "data1" : "유재석" , "data2" : "40"  }
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println( "[HTTP *PUT 방식으로 요청이 왔어요.]");
		ObjectMapper mapper = new ObjectMapper();
		DataDto dataDto = mapper.readValue( req.getReader() , DataDto.class );
		System.out.println( dataDto );
	} // f end 
	
} // class end 











