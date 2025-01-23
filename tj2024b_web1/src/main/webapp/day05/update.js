
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
	
}

// 마크업 주요 속성 
// 1. innerHTML	: 시작마크업과 끝마크업 사이에 <마크업> innerHTML </마크업> HTML문자열 대입/호출
	// --> div , span, table 등등 , 불가능 : <input/> <img/> 
// 2. value : 마크업의 입력 속성값 <마크업 value="" /> 대입/호출 
	// --> input , select , textarea , 불가능 : 레이아웃 div , span , table 등등
