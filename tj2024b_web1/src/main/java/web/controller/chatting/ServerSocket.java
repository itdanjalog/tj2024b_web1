package web.controller.chatting;

import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

// 서블릿 클래스가 아닌 웹소켓 클래스로 사용할 예정
// - @WebServlet HTTP vs -@ServerEndpoint WS
@ServerEndpoint("/chatsocket")
public class ServerSocket {
	
	@OnOpen
	public void onOpen( Session session ) {
	// Session : [import] jakarta.websocket.Session 
		System.out.println("클라이언트가 서버에 접속 성공");
		System.out.println( session );
	} // f end 
	
} // c end 
