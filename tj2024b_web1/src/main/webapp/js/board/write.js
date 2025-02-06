
$(document).ready(function() {

	$('#summernote').summernote({
		height: 500,
		lang: 'ko-KR' // default: 'en-US'
	});

});


const onWrite = () => {
	
	// [1] 
	const btitle = document.querySelector('.btitle').value
	const bcontent = document.querySelector('.bcontent').value
	
	const obj = { btitle : btitle , bcontent : bcontent , cno : 1 }
	// [2]
	const option = {
		method : 'POST',
		headers : { 'Content-Type' : 'application/json'} ,
		body : JSON.stringify( obj )
	}
	// [3] 
	fetch( '/tj2024b_web1/board' , option )
		.then( r => r.json() )
		.then( data =>{
			if( data == true ){
				alert('글쓰기 성공');
				location.href="board.jsp";
			}else{
				alert('글쓰기 실패');
			}
			
		})
		.catch( e =>{ console.log(e) })
}