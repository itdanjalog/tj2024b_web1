
// [ 수정 하기 전 정보를 조회 ] 게시물 개별 조회
const boardView = ( ) => {
	let bno = new URL( location.href ).searchParams.get('bno');
	const option = { method : 'GET' }
	fetch( `/tj2024b_web1/day05/board/view?bno=${ bno }` , option )
		.then( response => response.json() )
		.then( data => {
			// 4. fetch 응답에 따른 화면 출력 
			document.querySelector('.titleInput').value = `${ data.btitle }`
			document.querySelector('.contentInput').value = `${ data.bcontent }`
		})
		.catch( error => { console.log(error) })
} // f end 
boardView() ; 

// [ 수정 처리 ]
const boardUpdate = ( ) => {
	// 1. 수정할 게시물 번호 
	let bno = new URL( location.href ).searchParams.get('bno');
	// 2. input DOM 객체 가져오기 
	let titleInput = document.querySelector('.titleInput')
	let contentInput = document.querySelector('.contentInput')
	// 3. 갸져온 DOM 객체로 부터 value(입력값속성) 값 가져오기
	let btitle = titleInput.value;
	let bcontent = contentInput.value;
	// 4. 객체화 
	let dataObj = { bno : bno , btitle : btitle , bcontent : bcontent }
	// 5. fetch 
	const option = { 
		method : 'PUT', 
		headers : { 'Content-Type' : 'application/json' },
		body : JSON.stringify( dataObj )
	}// o end 
	fetch( '/tj2024b_web1/day05/board' , option )
		.then( response => response.json() )
		.then( data => {
			if( data == true ){ 
				alert('수정성공'); 
				location.href=`view.jsp?bno=${ bno }`;
			}else{ alert('수정실패'); }
		})
		.catch( e => { console.log(e); })
} // f end 

// 마크업 주요 속성 
// 1. innerHTML	: 시작마크업과 끝마크업 사이에 <마크업> innerHTML </마크업> HTML문자열 대입/호출
	// --> div , span, table 등등 , 불가능 : <input/> <img/> 
// 2. value : 마크업의 입력 속성값 <마크업 value="" /> 대입/호출 
	// --> input , select , textarea , 불가능 : 레이아웃 div , span , table 등등

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	