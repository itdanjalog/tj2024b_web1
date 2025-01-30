package day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day09/example3")
public class Example3 extends HttpServlet {

	ArrayList< HashMap<String,String > > list = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,String >map = mapper.readValue( req.getReader(), HashMap.class );
		
		list.add(map);
		
		String outStr = mapper.writeValueAsString(list);
		
		File file = new File("c:/java/servlet.txt");
		
		FileOutputStream outputStream = new FileOutputStream( file  );
		
        // [3] 파일출력 객체 생성 , 파일의 경로 지정
        
        
        // [4] 파일출력 객체를 이용한 문자열 출력하기.   , .write( "문자열".getBytes() );
        outputStream.write(outStr.getBytes() );        System.out.println("[ 저장 성공 ]");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        File file = new File("c:/java/servlet.txt");
        System.out.println( file.isFile() );    // true
        System.out.println( file.getName() );   // test2.txt
        System.out.println( file.length() );    // 반환타입 long
        System.out.println( file.exists() );
        System.out.println( file.mkdir() );
       
        byte[] bytes = new byte[ (int)file.length() ];
            // (캐스팅) : 강제 타입 변환 , long타입을 int 타입으로 변환
            // 배열내 [ ] 안에 들어가는 배열크기는 타입이 정수(int)만 가능하다.

        System.out.println("[ 불러오기 성공 ]");    
		// .
        	ObjectMapper mapper = new ObjectMapper();
        	ArrayList< HashMap<String,String > > list = mapper.readValue( file , ArrayList.class );
        
		String jsonResult = mapper.writeValueAsString( list );
		// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]
		resp.setContentType("application/json");
		resp.getWriter().print( jsonResult );
        
		
	}
	
}







