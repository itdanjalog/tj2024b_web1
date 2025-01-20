// [1] 람다식 함수 정의하기.
    // 선언적 함수 선언
function method1( a , b ){  return a + b; }
    // 람다식 함수 선언 , => 
( a , b ) => { return a + b; }
    // 람다식 함수 선언 하고 상수에 저장 
const method2 = ( a , b ) => { return a+ b; }
    
// [2] 람다식 함수 호출하기.
    // 선언적 함수 호출 
console.log( method1( 2 , 3 )  )    // 5
    // 람다식 함수 호출 , 함수명이 없어서 호출X
    // 람다식 함수를 호출하기 위해 상수를 호출O
console.log( method2( 2 , 3 ) )     // 5

// [3] 람다식 함수의 매개변수 와 리턴값 
const getName = name => {
    return `안녕,${name}`
}
console.log( getName("유재석") ) // 안녕,유재석

const isEven = num => console.log( num )
isEven( 2025 )  // 2025



// [4] 람다식 함수의 활용처
const words = [ '사과' , '수박' , '딸기' , '오렌지']
    // - 배열내 모든 요소를 하나씩 출력하시오.
    // 방법1
for( let index = 0 ; index <= words.length-1 ; index++ ){
    console.log( words[index] );
} // f end 

    // 방법2 , forEach 람다함수를 바로 forEach 적용.
words.forEach( ( element) => {  console.log( element ) } );

    // 방법2 , forEach 다른시점 , 람다함수를 상수에 대입하고 forEach 적용.
const method3 = element => console.log( element )
words.forEach( method3 );

    // 방법3 : map
words.map(  element => console.log( element ) );

    // 방법3 : forEach 와 map 차이점
let newWords = words.map( element => { return `${element}과일` } )
console.log( newWords ); // ['사과과일', '수박과일', '딸기과일', '오렌지과일']

// 실습1 :  x와 y를 매개변수를 받아서 뺄셈의 결과를 반환하는 람다 함수 만들기 , 호출
// ( 매개변수1 , 매개변수2 ) => { 실행문; }

const 실습1함수 = ( x , y ) => { return x - y }
console.log( 실습1함수( 5 , 2 ) ) // 3 
console.log( 실습1함수( 10, 5) ) // 5

// 실습2 : const scores = [ 92 , 72 , 35 , 86 ] 
// 의 모든 요소를 하나씩 출력하는 forEach 함수로 구현하기
const scores = [ 92 , 72 , 35 , 86 ]
// 배열변수명.forEach( (반복변수) => {  } ) 
scores.forEach( (val) => { console.log(val); } )

// 실습3 : const scores = [ 92 , 72 , 35 , 86 ] 
// 의 모든 요소에 5점씩 추가한 새로운 배열을 map 함수로 구현하기
// 배열변수명.map( (반복변수) => { return } )
let newScores = scores.map( (val) => { return val + 5 ; } )
console.log( newScores ) // [97, 77, 40, 91]