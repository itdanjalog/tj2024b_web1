console.log( 'info.js open');

// [1] 현재 로그인된 회원정보 요청 함수 
const getMyInfo = ( ) => {
	
	// fetch 옵션 
	const option = { method : 'GET' }
	// fetch 실행 
	fetch( '/tj2024b_web1/member/info' , option )
		.then( r => r.json() )
		.then( data => { 
			if( data != null ){ // 로그인 상태이면 
				// 특정한 dom 에 정보 대입하기.
				document.querySelector('.mid').value = data.mid
				document.querySelector('.mname').value = data.mname
				document.querySelector('.mphone').value = data.mphone
				/* img 마크업에 이미지 경로 대입하는 방법 .src 속성 이용 */
				document.querySelector('.mimg').src = `/tj2024b_web1/upload/${ data.mimg }`
				
			}
		})
		.catch( e => { console.log(e) } )
}// f end 

getMyInfo(); // JS가 열렸을때 최초 1번 실행 
