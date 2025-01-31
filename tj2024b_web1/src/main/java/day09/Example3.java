package day09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day09/example3")
public class Example3 extends HttpServlet {
	// * 여러개 map객체(dto) 를 저장할 list 선언 
	// ArrayList< dto > list = new ArrayList<>();
	private ArrayList< HashMap<String, String> > list = new ArrayList<>();
	// * 파일 경로
	private String filePath = "c:/java";
	
	// 1. doPost : 파일쓰기 
	@Override // http://localhost:8080/tj2024b_web1/day09/example3 , { "name" : "유재석" , "age" : "40" }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// (1) HTTP 요청된 BODY 자료들을 HashMap타입 으로 변환 하기. 
		ObjectMapper mapper = new ObjectMapper();
		HashMap< String , String > map = mapper.readValue( req.getReader() , HashMap.class );
		// (2) 입력받은 map를 list 저장 
		list.add(map);
		// (3) 만약에 지정한 경로가 존재하지 않으면 폴더 경로 생성 
		File file = new File( filePath );
		if( !file.exists() ) { file.mkdir(); }
		// (4) 출력 스트림 객체 
		FileOutputStream out = new FileOutputStream( filePath + "/test3.txt" );
		// (5) 출력할 내용물 , list 타입을 (JSON형식)문자열타입으로 변환 
		String outStr = mapper.writeValueAsString(list);
		// (6) 출력할 내용물을 바이트로 변환 
		byte[] bytes = outStr.getBytes();
		// (7) 바이트 출력/내보내기 
		out.write( bytes );
	} // f end 
	
} // class end 













