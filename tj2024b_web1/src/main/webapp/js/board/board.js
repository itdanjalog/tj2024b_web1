

const findAll = ( ) => {
	
	// [1] 
	let cno = new URL( location.href ).searchParams.get('cno'); console.log( cno );
	
	// [2]
	const option = {
		method : 'GET'
	}
	
	fetch( `/tj2024b_web1/board?cno=${cno}&page=1` , option )
		.then( r => r.json() )
		.then( data => { 
			console.log( data );
			
			const boardlist = document.querySelector('.boardlist > tbody');
			
			let html = ``;
			
			data.forEach( board =>{
				
				html += `<tr>
							<td> ${ board.bno } </td>
							<td> <a class="nav-link" href="view.jsp?bno=${ board.bno }">${ board.btitle }</a> </td>
							<td> ${ board.mid } </td>
							<td> ${ board.bview } </td>
							<td> ${ board.bdate } </td>
						</tr>`
			} )
			
			boardlist.innerHTML = html;
			
			
			
		})
		.catch( e => { console.log(e); })
	
	
} // f end 
findAll();
