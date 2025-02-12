console.log('chatting.js open');
// [1] WebSocket 클래스 이용하여 클라이언스 소켓 구현 , WebSocket 과 fetch는 비동기 통신
// new WebSocket('서버소켓주소'); 				, 비동기 통신은 요청하고 응답이 올때까지 JS 코드흐름을 대기하지 않는 구조
let clientSocket = new WebSocket('ws://localhost:8080/tj2024b_web1/chatsocket');

// [2] 접속/연결(상태유지)된 서버소켓에게 메시지 전송 , .send( "메시지" )
// clientSocket.send( '서버 소켓 안녕!' ); // 오류 발생 , 즉] 접속 요청후 응답 성공 전에 실행 했으므로 

// [전송] 버튼을 클릭했을때 실행 할 함수 정의
const onMsgSend = ( ) => {
	clientSocket.send( '서버 소켓 안녕!');
} // f end 

// [3] 서버 소켓이 클라이언트 소켓으로 부터 메시지를 보냈을때
clientSocket.onmessage = ( msgEvent ) => {
	console.log( clientSocket );
	console.log('서버소켓으로 부터 메시지 왔다.')
	console.log( msgEvent );
	console.log( msgEvent.data );
} // f end 



