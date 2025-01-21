
// [1] 람다식 함수 정의
// const 상수명 = ( ) => { }
const func1 = ( ) => { 
	console.log( 'func1 execute' )
} // f end 

// [2] 람다식 함수 정의 안에서 fetch 함수 활용
const func2 = ( ) => {
	// ** fetch : HTTP 비동기 통신 제공하는 함수
	// day02의 example1 서블릿 클래스의 doget 메소드 매핑 
	fetch( `http://localhost:8080/tj2024b_web1/day02/example1` )
} // f end 

const func3 = ( ) => {
	// POST 메소드 매핑 
	fetch( `/tj2024b_web1/day02/example1` , { method : 'POST' } )
} // f end 

const func4 = ( ) => {
	fetch( `/tj2024b_web1/day02/example1` , { method : 'PUT'} )
} // f end 

const func5 = ( ) => {
	fetch( `/tj2024b_web1/day02/example1` , { method : 'DELETE'} )
} // f end 

const func6 = ( ) => {
	let name = '유재석'; let age = 20;
	fetch( `/tj2024b_web1/day02/example2?name=${ name }&age=${ age }`)
} // f end 

const func7 = ( ) => {
	let name = '신동엽'; let age = 30;
	const option = { method : 'POST' }
	fetch( `/tj2024b_web1/day02/example2?name=${ name }&age=${ age }` , option )
} // f end 

const func8 = ( ) => {
	let name = '서장훈'; let age = 10;
	const option = { method : 'PUT' }
	fetch( `/tj2024b_web1/day02/example2?name=${ name }&age=${ age }` , option )
} // f end 

const func9 = ( ) => {
	let name = "김희철"; let age = 50;
	const option = { method : 'DELETE'}
	fetch( `/tj2024b_web1/day02/example2?name=${ name }&age=${ age }` , option )
} // f end 



/*
	fetch( `HTTP URL` , {옵션} )
		URL 
			1. 통신할 서블릿의 URL 주소 
			2. 쿼리스트링 
		옵션
			1. METHOD 
			- GET : fetch( `HTTP URL` , { method: `GET` } )]
				-> GET METHOD는 기본값이므로 생략이 가능하다.
				
			- POST : fetch( `HTTP URL` , { method: `POST` } )
			- PUT : fetch( `HTTP URL` , { method: `PUT` } )
			- DELETE : fetch( `HTTP URL` , { method: `DELETE` } )
  	
	`` : 백틱 템플릿 : 문자열 사이에 변수/함수 호출 과 연산식을 넣을수 있는 템플릿 
		`문자열 ${ 변수명 } 문자열 ${ 함수명() } 문자열 ${ 연산 } `
*/










