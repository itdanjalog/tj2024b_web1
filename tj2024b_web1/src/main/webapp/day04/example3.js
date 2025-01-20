
// [1] fetch 함수를 이용한 GET 요청 , 샘플 게시물 전체 요청 
/*
    - fetch( '요청할URL' , 옵션 )                    <--- 자바의 컨트롤러URL 작성.
        .then( respone => respone.json() )  <--- 요청 결과를 JSON(JS객체) 형식으로 변환
        .then( data => { 실행문; } )        <--- 요청 결과후 실행할 코드 작성.
        .catch( error => { 실행문; } )      <--- 예외 발생시 실행할 코드 작성.

    - 옵션 
        { 
            method : 'GET'/'POST'/'PUT'/'DELETE',                   <---- 4중에 사용할 HTTP메소드를 작성한다. 생략시 GET 이 된다.
            headers : { 'Content-Type' : 'application/json'} ,      <---- 서버에게 보낼 자료를 json 형식으로 보내기.
            body : JSON.stringify( 전송할객체 ),                    <--- 서버에게 보낼 객체
        }
*/

// [1] fetch 함수를 이용한 GET 요청 , 샘플 게시물 1개 요청 , 3번 게시물 

// [2] fetch 함수를 이용한 POST 요청 , 임의의 게시물 저장/쓰기 요청
function onDay3Examp3Post(){
	
	const option = {
		method : "post",
		header : { "Content-Type" : "application/json"},
		body : JSON.stringify( { "data1" : "유재석" , "data2" : 40  } )
	}
	
	fetch( '/tj2024b_web1/day03/example3' , option  )
	
}
// [3] fetch 함수를 이용한 PUT 요청 , 임의 게시물 수정 요청 
function onDay3Examp3Put(){
	
	const option = {
		method : "put",
		header : { "Content-Type" : "application/json"},
		body : JSON.stringify( { "data1" : "유재석" , "data2" : 40  } )
	}
		
	fetch( '/tj2024b_web1/day03/example3' , option  )
}
// [4] fetch 함수를 이용한 DELETE 요청 , 임의의 게시물 삭제 요청

// [1] fetch 함수를 이용한 GET 요청 , 샘플 게시물 1개 요청 , 3번 게시물 
function onDay3Examp5Get(){
	const option = { method : "get" }
	fetch( '/tj2024b_web1/day03/example5' , option  )
	.then( response => response.json() )
	.then( data => { console.log( data ); })
}
// [2] fetch 함수를 이용한 POST 요청 , 임의의 게시물 저장/쓰기 요청
function onDay3Examp5Post(){
	const option = { method : "POST" }
	fetch( '/tj2024b_web1/day03/example5' , option  )
	.then( response => response.text() )
	.then( data => { console.log( data ); })
}
// [3] fetch 함수를 이용한 PUT 요청 , 임의 게시물 수정 요청 
function onDay3Examp5Put(){
	const option = { method : "PUT" }
	fetch( '/tj2024b_web1/day03/example5' , option  )
	.then( response => response.json() )
	.then( data => { console.log( data ); })
}
// [4] fetch 함수를 이용한 DELETE 요청 , 임의의 게시물 삭제 요청
function onDay3Examp5Delete(){
	const option = { method : "DELETE" }
	fetch( '/tj2024b_web1/day03/example5' , option  )
	.then( response => response.json() )
	.then( data => { console.log( data ); })
}






