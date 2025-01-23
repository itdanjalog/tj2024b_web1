package web.controller.member;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import day05.BoardDao;
import day05.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@WebServlet("/member/signup")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)
public class MemberSignup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" /member/signup POST OK ");
		
        // 업로드 경로 설정
        String uploadPath = getServletContext().getRealPath("/uploads");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir(); // 폴더 생성
        }

        String mid = null, mpwd = null, memail = null, mimg = null;

        try {
            // Apache Commons FileUpload를 이용해 멀티파트 데이터 처리
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> items = upload.parseRequest( req );
            for (FileItem item : items) {
                if (item.isFormField()) {
                    // 텍스트 필드 처리
                    switch (item.getFieldName()) {
                        case "mid":
                            mid = item.getString("UTF-8");
                            break;
                        case "mpwd":
                            mpwd = item.getString("UTF-8");
                            break;
                        case "memail":
                            memail = item.getString("UTF-8");
                            break;
                    }
                } else {
                    // 파일 처리
                    String fileName = new File(item.getName()).getName();
                    mimg = fileName;
                    File storeFile = new File(uploadPath + File.separator + fileName);
                    item.write(storeFile); // 파일 저장
                }
            }

            // DTO 생성
            MemberDto dto = new MemberDto( 0 , mid, mpwd, memail, mimg, null );
            System.out.println("DTO 생성 성공: " + dto.getMid() + ", " + dto.getMemail() + ", " + dto.getMimg());

            resp.getWriter().print("회원가입 성공!");

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("회원가입 실패!");
        }
		
		/*
		// 1. HTTP BODY 로 요청된 데이터들을 JSON --> DTO로 변환 
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto =  mapper.readValue( req.getReader() , MemberDto.class );
		// 2. DAO 처리 
		boolean result = MemberDao.getInstance().signup( memberDto );
		// 3. 결과 응답
		resp.setContentType("application/json");
		resp.getWriter().print( result );	
		*/
	}
	
//		{
//		  "mid" : "qweqwe",
//		  "mpwd" : "qweqwe",
//		  "memail" : "qweqwe@qweqwe.com"
//		}  
	
}
