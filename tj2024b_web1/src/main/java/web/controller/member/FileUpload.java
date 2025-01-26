package web.controller.member;

import java.io.File;
import java.io.IOException;
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

@WebServlet("/file/upload")
public class FileUpload extends HttpServlet {

	private static final String UPLOAD_DIRECTORY = "upload";
	
	    // 1. [C] (첨부파일 있을때 form )회원가입
	   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   		
	   	    // Get the upload path
	        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

	        // Create the directory if it doesn't exist
	        System.out.println( uploadPath );
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }

	        try {
	            // Configure the file upload
	            DiskFileItemFactory factory = new DiskFileItemFactory();
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
