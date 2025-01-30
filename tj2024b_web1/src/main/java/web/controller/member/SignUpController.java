package web.controller.member;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@WebServlet("/member/signup")
public class SignUpController extends HttpServlet {

	private static final String UPLOAD_DIRECTORY = "upload";

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" signup POST OK ");

   		
		// * commons.jar 이용한 업로드 구현 
		// commons-io.jar ,  commons-fileupload.jar 빌드 필요!!
		
		// 1. 저장경로 [ 첨부파일이 저장될 폴더 위치 ] 
		String uploadPath = req.getServletContext().getRealPath("/upload");
		
		// 2. 파일아이템저장소 객체 : 업로드할 옵션  [ import org.apache.commons.fileupload.FileItem; ]
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		itemFactory.setRepository( new File( uploadPath ) );	//  2.저장위치 [ File타입 ] 
		itemFactory.setSizeThreshold( 1024 * 1024 * 1024 ); 	//  3.용량
		itemFactory.setDefaultCharset("UTF-8");					// 4.한글인코딩
		
		// 3. 파일 업로드 객체 [ import org.apache.commons.fileupload.servlet.ServletFileUpload; ] 
		ServletFileUpload fileUpload = new ServletFileUpload( itemFactory );
		
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
		// 4. 파일 업로드 요청[ 요청방식 : request ] 
		try {
			
				// form전송시 input/select/textarea 등 태그의 모든 데이터 한번에 요청해서 결과를 List 반환 
			List< FileItem > fileList = fileUpload.parseRequest( req );
				// FileItem : 각 요청한 데이터 
			// 5. 업로드 실행 
			String filename = null;
			for( FileItem item : fileList ) { // 요청한 input 들의 데이터를 반복문으로 하나씩 꺼내기.
				// 1. 일반 필드 [ isFormField() : 만약에 일반폼필드이면 true / 아니고 첨부파일필드이면 false  ] 
				if( item.isFormField() ) { System.out.println( item.getString() ); } // .getString() : 해당 요청 input의 value 호출 
				else { // 2. file 필드
					// 만약에 파일 필드이면 업로드 진행
						System.out.println( "업로드할 파일명 : " + item.getName() ); // .getName()
					// 6.업로드 경로 + 파일명 [ 조합 ] 
						if( !item.getName().trim().isEmpty() ) {
							// 파일명에 중복이 있을때 식별 생성 
							UUID uuid = UUID.randomUUID();
								// UUID 클래스 : 고유성을 보장하는 ID를 만들기 위한 식별자 표준 규약  [ - 하이픈 4개 구역 ]
							 filename = uuid+"-"+ item.getName().replaceAll("-", "_");
													// 만약에 파일명에 - 하이픈 존재하면 _언더바로 변경 
													// 왜?? 파일명과 UUID 간의 식별하기 위해 구분 -하이픈 사용하기 때문에.
													// 추후에 파일명만 추출시 사용자가 파일명에 - 이 있으면 파일명 추출시 쪼개기가 힘듬.
							// UUID[ - - -  ] - 파일명 : 추후에 파일명만 추출시 -하이픈 기준으로 쪼개기 
							
							File fileUploadPath = new File( uploadPath +"/"+ filename ) ;
								System.out.println( "업로드경로와 파일명이 조합된 경로 : " + fileUploadPath );
							item.write( fileUploadPath ); // .write("저장할경로[파일명포함]") 파일 업로드할 경로를 file타입으로 제공 
						}else {
							filename = "default.png";
						}
				}
			}
			// ------------------------------------- 업로드 끝 --> DB처리 --------------------- //
			
			System.out.println( fileList.get(0).getString() );
			MemberDto memberDto = new MemberDto();
				memberDto.setMid( fileList.get(0).getString() );
				memberDto.setMpwd( fileList.get(1).getString() );
				memberDto.setMname( fileList.get(2).getString() );
				memberDto.setMphone( fileList.get(3).getString() );
				System.out.println( filename );
				memberDto.setMimg(filename);
			
			// Dto를 Dao처리 
			boolean result = MemberDao.getInstance().signup(memberDto);
			System.out.println( result );
			//
			resp.setContentType("application/json");
			resp.getWriter().print(result);
			
		}catch (Exception e) { System.out.println(e); }
		
		
		/*
		// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
		ObjectMapper mapper = new ObjectMapper();
		MemberDto memberDto = mapper.readValue( req.getReader() , MemberDto.class);
		System.out.println( "memberDto : " + memberDto );
		// 2.[ 데이터 유효성검사 ]
		// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
		boolean result = MemberDao.getInstance().signup(memberDto);
		// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
		// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		*/
	}
}


// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
// 2.[ 데이터 유효성검사 ]
// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]