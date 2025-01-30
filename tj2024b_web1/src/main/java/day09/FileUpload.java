package day09;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day09/file")
public class FileUpload extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 다운로드 할 파일명 요청
		req.setCharacterEncoding("UTF-8");
		String filename = req.getParameter("filename");
			System.out.println( "filename:"+filename); 
		// 2. 파일 다운로드 
			// 1. 다운로드할 폴더의 경로 찾기 
		// String path = request.getSession().getServletContext().getRealPath("/board/bfile");
			// System.out.println( "path : "+ path );
			// 2. 다운로드할 폴더[ 폴더/파일명 ]의 파일 경로 찾기 
		String path = req.getSession().getServletContext().getRealPath("/upload/"+filename);
			System.out.println( "path : "+ path );
			// 3. 파일 클래스 [ 해당 경로의 파일을 파일 객체화 ]  
				// - path.length()	: 경로 문자열 길이
				// - file.length() 	: 해당 파일의 바이트 길이[용량]
		File file = new File( path );	
		// 3. HTTP 다운로드 형식[프론트엔드] = 각 브라우저(크롬,엣지등) 제공
		resp.setHeader( // HTTP Header메소드[ HTTP 옵션정보 설정 ]
					"Content-Disposition" , // 각 브라우저마다 다운로드형식 HTTP 옵션에 포함해서 보내기
					"attachment;filename="+URLEncoder.encode( filename , "UTF-8" )
					// 다운로드시 파일명이 표시되는 옵션 [ 한글파일 인코딩 ]
					// URLEncoder.encode( 파일명 , "UTF-8" ) : URL(통신주소) 의 한글인코딩
				);
		// 4. 파일 스트림[바이트단위] * 예외발생
				// 1. 파일 객체의 바이트를 모두 읽어온다.
					// 1. 해당 경로[파일] 파일입력스트림객체 만들기 
		// BufferedInputStream fin = new BufferedInputStream( new FileInputStream(file) );
		FileInputStream fin = new FileInputStream( file );
					// 2. 파일입력스트림객체에서 꺼내올 바이트들을 저장할 바이트 배열 준비[선언]
					// 바이트배열 길이 = 파일의 길이 = 바이트개수
		byte[] bytes = new byte[ (int)file.length() ];
					// 3. 파일입력스트림객체에서 read() : 해당 파일을 바이트로 읽어오는 함수 
		fin.read( bytes );
				// 2. 읽어온 바이트를 모두 출력한다.[ 클라이언트에게 응답  ]
					// 1. response응답객체에서 출력스트림 호출해서 파일출력스트림객체 만들기 
					//  response.getOutputStream() : HTTP 스트림 단위[바이트] 전송 
		BufferedOutputStream fout = new BufferedOutputStream( resp.getOutputStream() );
		// ServletOutputStream fout = response.getOutputStream();
					// 2. 파일입력스트림객체에서 읽어온 바이트들[바이트배열]을 
					// 파일출력스트림객체 write() : 해당 배열내 바이트를 출력하는 함수 
		fout.write( bytes ); // ---> response.getOutputStream()
				// 3. 스트림 닫기 [ CG 대신 직접 스트림 닫기 ]
		fin.close();	// 파일입력스트림객체 스트림 닫기
		fout.flush();	// 파일출력스트림객체 스트림 메모리 초기화
		fout.close();	// 파일출력스트림객체 스트림 닫기
		
	}

    // 1. [C] (첨부파일 있을때 form )회원가입
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
		
		// ------------ 첨부파일 있을때 --------------//
		/*
		 	request는 첨부파일(대용량) 에 대한 요청이 불가능 --> 외부 라이브러리  cos.jar
		 	1. 프로젝트 build path 에 cos.jar 추가
		 	2. 프로젝트 WEB-INF -> lib -> cos.jar 추가 
		  	---------
		  	MultipartRequest 클래스 제공 
		  		1. 요청방식 : HTTP request
		  		2. 저장폴더 : 1.프로젝트[git] 2.서버[워크스페이스] // 수업에서는 서버 에 올림 
		  			서버폴더 경로 찾기 : request.getSession().getServletContext().getRealPath("(webapps생략)폴더명");
		  		3. 첨부파일 허용 범위 용량[ 바이트단위 ]
		  		4. 첨부파일 요청 한글 인코딩 
		  		5. 첨부파일 파일명 중복일경우 뒤에 자동 붙임 
		  	--------
		  	용량 
		  		1bit : 0 , 1 
		  		1byte : 01010101	8bit --> 1byte 
		  		1kbyte : 1024byte 	--> 1KB
		  		1MByte : 1024kb 	--> 1MB
		  		1GByte : 1024mb		--> 1GB
		  		
		 */
   		
   		
   	    // Get the upload path
   		String uploadPath = request.getServletContext().getRealPath("/upload");

        // Create the directory if it doesn't exist
        System.out.println( uploadPath );
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // Configure the file upload
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            factory.setRepository( new File( uploadPath ) );	//  2.저장위치 [ File타입 ] 
            factory.setSizeThreshold( 1024 * 1024 * 1024 ); 	//  3.용량
    		factory.setDefaultCharset("UTF-8");					// 4.한글인코딩
    		
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && !formItems.isEmpty()) {
                for (FileItem item : formItems) {
                    // Check if it's a form field or a file
                    if (!item.isFormField()) {
    					// 만약에 파일 필드이면 업로드 진행
						System.out.println( "업로드할 파일명 : " + item.getName() ); // .getName()
					// 6.업로드 경로 + 파일명 [ 조합 ] 
					
						// 파일명에 중복이 있을때 식별 생성 
						UUID uuid = UUID.randomUUID();
							// UUID 클래스 : 고유성을 보장하는 ID를 만들기 위한 식별자 표준 규약  [ - 하이픈 4개 구역 ]
						String filename = uuid+"-"+ item.getName().replaceAll("-", "_");
												// 만약에 파일명에 - 하이픈 존재하면 _언더바로 변경 
												// 왜?? 파일명과 UUID 간의 식별하기 위해 구분 -하이픈 사용하기 때문에.
												// 추후에 파일명만 추출시 사용자가 파일명에 - 이 있으면 파일명 추출시 쪼개기가 힘듬.
						// UUID[ - - -  ] - 파일명 : 추후에 파일명만 추출시 -하이픈 기준으로 쪼개기 
						
					File fileUploadPath = new File( uploadPath +"/"+ filename ) ;
					
						System.out.println( "업로드경로와 파일명이 조합된 경로 : " + fileUploadPath );
					item.write( fileUploadPath ); // .write("저장할경로[파일명포함]") 파일 업로드할 경로를 file타입으로 제공 
					// 7. 업로드 된 파일명을 Map에 저장 [ -DB에 저장할려고  ]
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().println("Error: " + ex.getMessage());
        }
        
   	}
}
