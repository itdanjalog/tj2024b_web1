
// [1] 수정페이지 들어왔을때 수정 하기전 기존 정보 보여주기
const getMyInfo = ( ) => {

    fetch('/member/info' , { method : 'GET' } )
    .then( response => response.json() )
    .then( data => {
		console.log( data );
        if( data != null ){
            document.querySelector('.midInput').value = data.mid;
            document.querySelector('.mnameInput').value = data.mname;
            document.querySelector('.mphoneInput').value = data.mphone;
			document.querySelector('.mimg').src = `/upload/${data.mimg}`;
        }
    }).catch( e => { console.log(e) })
};
getMyInfo(); // update.html 이 열릴때 내정보 조회 함수 

// [2] 수정 버튼 클릭했을때. 수정처리 
const onUpdate = ( ) => {
	/*
	// 1. 입력받은 input value 값 가져오기.
    let mname = document.querySelector('.mnameInput').value;
    let mphone = document.querySelector('.mphoneInput').value;
	let mpwd = document.querySelector('.mpwdInput').value;
    // 2. 객체화
    let dataObj = { mname : mname , mphone : mphone , mpwd : mpwd }
    // 3. fetch 
    const option = {
        method : 'PUT' , 
        headers : {'Content-Type' : 'application/json'},
        body : JSON.stringify( dataObj )
    }// o end 
    */
	// 1. 폼DOM 가져온다.
	let memberUpdateForm = document.querySelector( '#memberUpdateForm');
	console.log(memberUpdateForm);
	// 2. 폼 바이트(바이너리) 객체 변환[ 첨부파일 보낼때는 필수 ]
	let memberUpdateFormData = new FormData( memberUpdateForm );
	console.log(memberUpdateFormData);

	const option = {
	    method: 'PUT',
	    body : memberUpdateFormData
	}
	
	fetch( '/member/info' , option )
    .then( response => response.json() )
    .then( data => {
        if( data ){ alert('수정 성공'); location.href="/member/info.jsp"; }
        else{ alert('수정 실패');}
    }).catch( e => { console.log(e); } )
} // f end 