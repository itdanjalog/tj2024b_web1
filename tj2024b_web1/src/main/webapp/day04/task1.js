// * 함수명 만들때 JS내장함수와 겹치는 경우
// 1. 등록 함수 , 실행조건 : 등록버튼 클릭했을때.
const visitWrite = ( ) => {
	// 1. HTML 으로 부터 input dom 가져오기 
	// - document.querySelector(선택자) : 선택자 마크업을 객체로 반환함수.
	let contentInput = document.querySelector('.contentInput' )
	let ageInput = document.querySelector('.ageInput' )
	// 2. 입력받은 값 가져오기 
	// - .value : 마크업의 value 속성 
	let content = contentInput.value;
	let age = ageInput.value;
	// 3. 객체화 
	// - { 속성명 : 값 , 속성명 : 값 }
	let dataObj = { 'content' : content , 'age' : age };
	// 4. fetch 통신 
	let option = { 
		method : 'POST',	// HTTP METHOD 방법 선택 
		headers : { 'Content-Type' : 'application/json'}, // HTTP 요청 HEADERS CONTENT-TYPE 설정
		body : JSON.stringify( dataObj ) // 본문에 보낼 자료를 문자열타입으로 변환 
	} // o end 
	fetch( `/tj2024b_web1/day03/visit2` , option )
		.then( r => r.json() )	// - 응답받은 body 자료를 json 타입으로 변환 
		.then( data => {  // - 변환된 body 자료 
			// 5. 결과에 따른 화면 구현
			if( data == true ){ alert('등록성공'); visitFindAll(); }  // 만약에 받은 자료가 true 이면 성공 
			else{ alert('등록실패');} 
		}) // then2 end 
		.catch( e => { console.log(e);} )
} // f end 

// 2. 전체 조회 함수 , 실행조건 : 1.JS열릴때 2.등록/수정/삭제 성공했을때.
const visitFindAll = ( ) => { 
	// 1. 어디에 , tbody  
	let tbody = document.querySelector('tbody') 
	// 2. 무엇을 , fetch 으로 받은 자료들을 
	let html = '';
	// 2-1 fetch 이용한 서블릿에게 자료를 HTTP GET METHOD 요청 
	const option = { method : 'GET' }
	// 2-2 fetch 
	fetch( '/tj2024b_web1/day03/visit2' )
		.then( r => r.json() ) // 통신 응답 성공시 json타입으로 변환
		.then( data => { 
			// 방법1 : for( let index = 0 ; index <= data.length -1 ; index++ ){ }
			// 방법2 : data.forEach( obj => { } )
			data.forEach( obj => { 
				html += `<tr> 
							<td> ${ obj.num } </td>
							<td> ${ obj.content }</td>
							<td> ${ obj.age }</td>
							<td> </td>
						</tr>`
			}) // for end 
			// 3. 출력  // .innerHTML : 지정한 마크업의 html문자열 속성 
			tbody.innerHTML = html;
		}) // then2 end 
		.catch( e => { console.log(e); } ) // 통신 응답 오류/실패 시
} // f end 
visitFindAll(); //  1.JS열릴때

// 3. 수정 함수 

// 4. 삭제 함수 


























