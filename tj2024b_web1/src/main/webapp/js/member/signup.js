
// JS자동완성 : 1. VSCODE 2. 플러그인 : tabnine

// [1] 회원가입 함수
const onSignUp = ( ) => { console.log('함수 실행됨.');
//    // (1) INPUT DOM 가져온다.
//    let midInput = document.querySelector('.midInput');     console.log( midInput )
//    let mpwdInput = document.querySelector('.mpwdInput');   console.log( mpwdInput )
//    let mpwdCheckInput = document.querySelector('.mpwdCheckInput'); console.log( mpwdCheckInput )
//    let mnameInput = document.querySelector('.mnameInput'); console.log( mnameInput )
//    let memailInput = document.querySelector('.memailInput'); console.log( memailInput )
//    // (2) DOM의 value(입력받은값) 반환 받는다.
//    let mid = midInput.value;               console.log( mid )
//    let mpwd = mpwdInput.value;             console.log( mpwd )
//    let mpwdCheck = mpwdCheckInput.value;   console.log( mpwdCheck )
//    let mname = mnameInput.value;           console.log( mname )
//    let memail = memailInput.value;         console.log( memail )
//    // (!!!생략) 다양한 유효성검사 코드 생략 .
//    // (3) 입력받은 값들을 서버에게 보낼 객체 만들기
//    let dataObj = { mid : mid , mpwd : mpwd , mname : mname , memail : memail }; console.log( dataObj );
//    // (4) fetch 옵션
//    const option = {
//        method : 'POST' ,   // - HTTP 통신 요청 보낼때 사용할 METHOD 선택
//        headers : { 'Content-Type' : 'application/json'} ,  // HTTP 통신 요청 보낼때 header body(본문) 타입 설정
//        body : JSON.stringify( dataObj )  // HTTP 통신 요청 보낼때 body(본문) 자료 대입하는데
//            // JSON.stringify( 객체 ) : 객체타입 --> 문자열타입 변환 , HTTP 는 문자열타입만 전송이 가능하다.
//    } // o end

    // 1. 폼DOM 가져온다.
    let memberSingUpForm = document.querySelector( '.memberSingUpForm');
    console.log(memberSingUpForm);
    // 2. 폼 바이트(바이너리) 객체 변환[ 첨부파일 보낼때는 필수 ]
    let memberSingUpFormData = new FormData( memberSingUpForm );
    console.log(memberSingUpFormData);

    const option = {
        method: 'POST',
        body : memberSingUpFormData
    }

    // (5) fetch 통신 
    fetch( '/member/signup' , option )   // fetch( '통신할URL' , 옵션 )
        .then( response => response.json() )    // .then( ) 통신 요청 보내고 응답 객체를 반환 받고 .json() 를 이용한 응답객체를 json타입으로 변환
        .then( data => {                        // .then( ) json으로 변환된 자료를 실행문 처리
            // (6) fetch 응답 에 따른 화면 구현 
            if( data == true ){ alert('가입등록 완료'); location.href="/member/login.jsp"; }  // 만일 응답 자료가 true이면 성공 안내, 로그인페이지로 이동
            else{  alert('가입실패 : 입력하신 정보가 올바르지 않습니다.') } // 만일 응답 자료가 false이면 실패 안내
        })
        .catch( error => { alert('가입오류 : 관리자에게 문의'); } ) // 통신 오류가 발생하면 오류 메시지 안내
} // f end








