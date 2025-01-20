

// 1.  등록 
function _write(){
	// 1. 
	let content = document.querySelector('.content').value;
	let age = document.querySelector('.age').value;
	// 2. 
	let json = {
		content : content , 
		age : age 
	}
	// 3. 
	const option = {
		method : "post",
		header : { "Content-Type" : "application/json"},
		body : JSON.stringify( json )
	}
	fetch('/tj2024b_web1/day03/visit2' , option )
		.then( response => response.json() )
		.then( data => { console.log( data ); _findAll(); })
		.catch( error => { console.log(error) } )
	
}

// 2. 전체 조회 
_findAll();
function _findAll(){
	
	// 1. 
	let tbody = document.querySelector('tbody')
	
	// 2.
	let html = ``;
	
	// 3. 
	fetch( '/tj2024b_web1/day03/visit2' , { method : "get" } )
		.then( response => response.json() )
		.then( data => {
			data.forEach( d => {
				html += `<tr>
					<th> ${ d.num } </th> <th> ${ d.content }  </th> 
					<th> ${ d.age }  </th> 
					<th> 
						<button onclick="_delete(${ d.num })">삭제</button> 
						<button onclick="_update(${ d.num })">수정</button> 
					</th>
				</tr>`
			})
			tbody.innerHTML = html;
		})
		.catch( error => {console.log(error)})
	
}

// 3. 수정 
function _update( num ){
	
	let content = prompt('new content');
	let age = prompt('new age');
	
	let json = {
		num : num ,
		content : content , 
		age : age 
	}
	// 3. 
	const option = {
		method : "put",
		header : { "Content-Type" : "application/json"},
		body : JSON.stringify( json )
	}
	fetch('/tj2024b_web1/day03/visit2' , option )
		.then( response => response.json() )
		.then( data => { console.log( data ); _findAll(); })
		.catch( error => { console.log(error) } )
	
}

// 4. 삭제 
function _delete( num ){ 
	fetch( `/tj2024b_web1/day03/visit2?num=${num}` , { method : "delete" } )
		.then( response => response.json() )
		.then( data => {
			if( data == true ){ alert('삭제성공'); _findAll(); }
			else{ alert('삭제실패'); }
		})
		.catch( error => {console.log(error)})
}
















