
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
function onDay2Examp1Get(){
	fetch( '/tj2024b_web1/day02/example1', { method : "get" }  )
}
// [2] fetch 함수를 이용한 POST 요청 , 임의의 게시물 저장/쓰기 요청
function onDay2Examp1Post(){
	fetch( '/tj2024b_web1/day02/example1' , { method : "post" }  )
}
// [3] fetch 함수를 이용한 PUT 요청 , 임의 게시물 수정 요청 
function onDay2Examp1Put(){
	fetch( '/tj2024b_web1/day02/example1' , { method : "put" }  )
}
// [4] fetch 함수를 이용한 DELETE 요청 , 임의의 게시물 삭제 요청
function onDay2Examp1Delete(){
	fetch( '/tj2024b_web1/day02/example1' , { method : "delete" }  )
}

// [1] fetch 함수를 이용한 GET 요청 , 샘플 게시물 1개 요청 , 3번 게시물 
function onDay2Examp2Get(){
	fetch( `/tj2024b_web1/day02/example2?name=${'유재석'}&age=${40}`, { method : "get" }  )
}
// [2] fetch 함수를 이용한 POST 요청 , 임의의 게시물 저장/쓰기 요청
function onDay2Examp2Post(){
	fetch( `/tj2024b_web1/day02/example2?name=${'유재석'}&age=${40}` , { method : "post" }  )
}
// [3] fetch 함수를 이용한 PUT 요청 , 임의 게시물 수정 요청 
function onDay2Examp2Put(){
	fetch( `/tj2024b_web1/day02/example2?name=${'유재석'}&age=${40}` , { method : "put" }  )
}
// [4] fetch 함수를 이용한 DELETE 요청 , 임의의 게시물 삭제 요청
function onDay2Examp2Delete(){
	fetch( `/tj2024b_web1/day02/example2?name=${'유재석'}&age=${40}` , { method : "delete" }  )
}






