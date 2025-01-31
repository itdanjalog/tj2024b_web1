package day09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

// 서블릿X
public class Example1 {
	public static void main(String[] args) {
		
		// [1] 실행중인 자바 자료를 (윈도우)파일에 출력 하기
			// - FileOutputStream out = new FileOutputStream("파일경로");
			// - c드라이브에 'java' 폴더를 하나 생성하기. 
			// - FileNotFoundException : 예외처리
		try {
			// (1) 파일출력스트림 객체 생성한다. - 1. 파일경로 2.예외처리필수 
			FileOutputStream out = new FileOutputStream("c:/java/test1.txt");
			// (2) 출력할 문자열 
			String str = "Hello JAVA";
			// (3) 출력할 문자열을 바이트열로 변환. - "".getBytes() : String --> byte[] 반환 함수.
			byte[] outStr = str.getBytes();
			// (4) 출력스트림 객체내 출력 함수로 바이트열 내보내기. .write( 출력할바이트 ) , - 예외처리필수
			out.write( outStr );
			System.out.println("파일 저장 성공 ");
		}
		catch( FileNotFoundException e ) { System.out.println( e );}
		catch( IOException e ) { System.out.println( e ); }
		
		// [2] 키보드로부터 입력받은 자료를 파일에 출력하기.
		try {
			FileOutputStream out = new FileOutputStream("c:/java/test2.txt");
			Scanner scan = new Scanner(System.in);
			System.out.print("[2] 메모장에 작성할 내용입력:");
			String str = scan.nextLine();
			byte[] outStr = str.getBytes();
			out.write(outStr);
			System.out.println("파일 저장 성공2");
		}catch( IOException e ) { System.out.println( e ); }
		
	} // main end  
} // class end 




