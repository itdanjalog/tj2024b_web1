
// [1] 마이페이지 에서 (로그인된)내정보 불러오기.
const getMyInfo = ( ) => {
    // 1. fetch 이용한 내정보 서비스 요청 과 응답 받기 
    fetch( '/member/info' , { method : 'GET'} )
    .then( response => response.json() )
    .then( data =>{
        if( data != null ){// 응답 결과가 존재하면 
            // 응답 결과를 각 input value 에 각 정보들을 대입하기.
            document.querySelector('.midInput').value = data.mid;
            document.querySelector('.mnameInput').value = data.mname;
            document.querySelector('.mphoneInput').value = data.mphone;
			document.querySelector('.mimg').src = `/upload/${data.mimg}`;
        }
    }).catch( e => { console.log(e)})
} // f end 
getMyInfo(); // info.html 이 열릴때 내정보 불러오기 함수 실행 

// [2] 마이페이지 에서 (로그인된)회원탈퇴 요청하기
const onDelete = ( ) => {
    // * 예/아니요 형식으로 탈퇴 여부를 묻고 아니요 이면 탈퇴를 중지한다.
    let result = confirm('정말 탈퇴 하실건가요?');
    if( result == false ) { return; }
    // 1. fetch 이용한 회월탈퇴 서비스 요청 과 응답 받기 
    fetch( '/member/info' , { method : "DELETE"} )
    .then( response => response.json() )
    .then( data => {
        if( data == true ){ alert('탈퇴 성공'); location.href='/index.jsp'; }
        else{ alert('탈퇴 실패'); }
    }).catch( e => { console.log(e); })
} // f enmd 

