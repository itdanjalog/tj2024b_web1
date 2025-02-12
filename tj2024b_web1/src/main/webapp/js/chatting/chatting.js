console.log('chatting.js open');

// [1] WebSocket 클래스 이용하여 클라이언스 소켓 구현 
// new WebSocket('서버소켓주소');
let clientSocket 
= new WebSocket('ws://localhost:8080/tj2024b_web1/chatsocket');
	