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
import web.model.dto.PointDto;

@WebServlet("/member/signup")
public class SignUpController extends HttpServlet {

	
	// [ 프로필 등록 가능한 회원가입 ] 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("signup post ok");
		// 1. 업로드 경로 가져오기 
		String uploadPath = req.getServletContext().getRealPath("/upload");
		// 2. 만일 해당 경로가 없으면 만들어주기.
		File file = new File( uploadPath );
		if( file.exists() ) {} 	// 경로가 존재하면 아무것도 안함.
		else {  file.mkdir(); } // 경로가 존재하지 않으면 경로(폴더) 생성 하기.
		// 3. 파일 업로드 설정 , DiskFileItemFactory클래스 
		DiskFileItemFactory factory = new DiskFileItemFactory(); // 업로드 설정 객체 생성 
		factory.setRepository(file); // 경로 설정 
		factory.setSizeThreshold( 1024 * 1024 *1024 ); // 용량 제한 설정, 1024 -> 1kb , 1024*1024 -> 1mb , 1024*1024*1024->1gb
		factory.setDefaultCharset("UTF-8"); // 힌글 인코딩 설정 
		// 4. 설정된 객체를 서블릿업로드 객체에 대입
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		// 5. HTTP 요청 객체 내 데이터 파싱/가져오기 ,
		String filename = "default.jpg";
		try {
			List< FileItem > fileList = fileUpload.parseRequest( req );
			// 6. 파싱된 자료들을 반복문으로 하여 하나씩 조회하여 첨부파일 찾기. 
			for( FileItem item : fileList ) { // 향상된 for문 , for( 타입 반복변수명 : 리스트변수명 ){ }
				// 7. 만약에 조회중인 자료가 일반 텍스트 이면 
				if( item.isFormField() ) {
				}else { // 아니면 , 조회중인 자료가 첨부파일 이면 
					if( !item.getName().isEmpty() ) { // 첨부파일이 비어있지 않으면 
						// 8. UUID 이용한 첨부파일명 조합하기.  예] uuid-파일명  , 주의할점 : 파일명에 -하이픈을 모두 _언더바 로 변경 
						filename = UUID.randomUUID().toString() +"-"+item.getName().replaceAll("-", "_");
						// 9. 업로드할 경로 와 파일명 조합하여 경로 만들기
						File uploadFile = new File( uploadPath +"/"+ filename);
						// 10. 지정한 경로에 업로드하기
						item.write( uploadFile );
					}
				}
			} // for end 
			
		// 11. 첨부파일 아닌 일단 텍스트/값 dto로 직접 파싱 
		MemberDto memberDto = new MemberDto();
		memberDto.setMid( fileList.get(0).getString() ); // fileList.get(0).getString() : 첫번째 필드의 텍스트/값  가져오기
		memberDto.setMpwd( fileList.get(1).getString() ); // 첫번째 필드의 텍스트/값  가져와서  dto 넣기 
		memberDto.setMname( fileList.get(2).getString() ); // 두번째 필드의 텍스트/값  가져와서 dto 넣기 
		memberDto.setMphone(fileList.get(3).getString() ); // 세번째 필드의 텍스트/값  가져와서 dto 넣기 
		memberDto.setMimg(filename); // 업로된 파일명을 dto 넣기 
		System.out.println( memberDto );
		
		// 12.
		int mno = MemberDao.getInstance().signup(memberDto);
		boolean result = false;
		if( mno > 0 ) {
			// * 회원성공시 포인트 지급 
			PointDto pointDto = new PointDto();
			pointDto.setMno( mno );
			pointDto.setPocomment("회원가입 축하");
			pointDto.setPocount( 100 );
			MemberDao.getInstance().setPoint( pointDto );
			result = true;
		}
		// 13.
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		}catch (Exception e) { System.out.println("업로드 실패 : " + e ); }
		
	} // f end 
	
	
	
	// [ 프로필 등록이 불가능한 회원가입 ]
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println(" signup POST OK ");
//		// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
//		ObjectMapper mapper = new ObjectMapper();
//		MemberDto memberDto = mapper.readValue( req.getReader() , MemberDto.class);
//		System.out.println( "memberDto : " + memberDto );
//		// 2.[ 데이터 유효성검사 ]
//		// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
//		boolean result = MemberDao.getInstance().signup(memberDto);
//		// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
//		// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]
//		resp.setContentType("application/json");
//		resp.getWriter().print(result);
//	}
	
	
}


// 1.[HTTP 요청의 header body 자료(JSON)를 자바(DTO)로 받는다.]
// 2.[ 데이터 유효성검사 ]
// 3.[ DAO 에게 데이터 전달 하고 응답 받기 ]
// 4.[ 자료(DTO/자바)타입을 JS(JSON)타입으로 변환한다.]
// 5.[ HTTP 응답의 header body 로 application/json 으로 응답/반환하기]