package day07;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day07/example7")
public class Example7 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// [1] 톰캣 안에 있는 객체 호출 및 (첫 HTTP 요청)생성 
		HttpSession httpSession = req.getSession();
		System.out.println( httpSession ); // HTTP 요청한 클라이언트 브라우저의 세션 객체 주소 
		// 1요청시 : org.apache.catalina.session.StandardSessionFacade@34905823
		// 2요청시 : org.apache.catalina.session.StandardSessionFacade@34905823

		// [2] 세션 객체의 주요 메소드 
			// 1. 세션 객체내 모든 속성 반환 함수.
			System.out.println( httpSession.getAttributeNames() ); 	// 세션 객체내 모든 속성 반환 함수.
			//1요청시 : java.util.Collections$3@3a57b0c1
			//2요청시 : java.util.Collections$3@629fba6a
	
			// 2. 
			System.out.println( httpSession.getCreationTime() );	// 세션 객체가 만들어진 시간
			//1요청시 : 1737705649335
			//2요청시 : 1737705649335
			// 3. 
			System.out.println( httpSession.getId() );				// 세션 객체의 아이디/식별자
			//1요청시 : 111C8507BFA3C2CCED6F1B8C76C86ED8
			//2요청시 : 111C8507BFA3C2CCED6F1B8C76C86ED8
			// 4. 
			System.out.println( httpSession.getLastAccessedTime() );// 마지막으로 세션 객체 사용한 시간 반환
			//1요청시 : 1737705649335
			//2요청시 : 1737705649337
			// 5. 
			System.out.println( httpSession.isNew() );				// 새로 만들어진 세션 인지 여부 반환 
			//1요청시 : true
			//2요청시 : false
			
			//6. 세션 객체의 속성명 과 값 저장 
			httpSession.setAttribute( "세션속성1", "유재석" );
			
			//7. 세션 객체의 지정한 속성명의 값 호출 
			Object object = httpSession.getAttribute("세션속성1") ;
			System.out.println( (String)object );
			
			//8. 세션 객체의 지정한 속성 제거 
			httpSession.removeAttribute("세션속성1");
		
			//9.
			httpSession.invalidate();
			
			//10. 세션 객체의 시간주기
			httpSession.setMaxInactiveInterval( 60 * 60 ); // 단 이 경우 유효시간 단위는 분 단위가 아닌 초(second) 단위입니다.
/*
 httpSession.setMaxInactiveInterval(60 * 60) 코드는 HTTP 세션의 비활성 상태 타임아웃을 설정하는 것으로, 
 세션이 활성화되지 않은 상태로 지정된 시간(초 단위) 동안 유지되면 세션이 만료됩니다.

따라서, 클라이언트가 요청을 보내는 경우에는 세션이 활성화되므로 타임아웃 카운트가 리셋됩니다. 클라이언트가 지속적으로 요청을 보내는 동안에는 세션이 종료되지 않습니다.

정리:
비활성 상태란 세션이 갱신되지 않는 상태를 의미합니다. (예: 클라이언트가 요청을 보내지 않는 경우)
클라이언트가 요청을 보낼 때마다 세션이 갱신되며, 타임아웃 카운트는 다시 시작됩니다.
클라이언트가 1시간 동안 아무 요청도 하지 않으면 세션이 만료됩니다.
 */
			
		
	} // f end
	
} // class end 









