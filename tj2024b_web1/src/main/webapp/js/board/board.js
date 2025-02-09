

const findAll = ( ) => {
	
	// [1] 
	let cno = new URL( location.href ).searchParams.get('cno'); console.log( cno );
	let page = new URL( location.href ).searchParams.get('page'); console.log( page );
	if( page == null ) page = 1;
	
	// [2]
	const option = {
		method : 'GET'
	}
	
	fetch( `/tj2024b_web1/board?cno=${cno}&page=${page}` , option )
		.then( r => r.json() )
		.then( data => { 
			console.log( data );
			
			const boardlist = document.querySelector('.boardlist > tbody');
			
			let html = ``;
			
			data.datalist.forEach( board =>{
				
				html += `<tr>
							<td> ${ board.bno } </td>
							<td> <a class="nav-link" href="view.jsp?bno=${ board.bno }">${ board.btitle }</a> </td>
							<td> <img src="/tj2024b_web1/upload/${ board.mimg }" style="width:20px;     border-radius: 10px;"/> ${ board.mid } </td>
							<td> ${ board.bview } </td>
							<td> ${ board.bdate } </td>
						</tr>`
			} )
			
			boardlist.innerHTML = html;
			getpage( cno , page , data.startbtn , data.endbtn , data.totalpage );
			
		})
		.catch( e => { console.log(e); })
	
	
} // f end 
findAll();

const getpage = ( cno , page , startbtn , endbtn , totalpage  ) => {
	
	page = parseInt(page);
	
	const pagebox = document.querySelector('.pagebox')
	let html = ``;
	
	html += `<li class="page-item"><a class="page-link" href="board.jsp?cno=${ cno }&page=${ page <= 1 ? 1 : page-1}"> 이전 </a></li>`;
	
	for( let index = startbtn ; index <= endbtn  ; index++ ){
		
		html += `<li class="page-item ${ page == index ? 'active' : '' }"><a class="page-link" href="board.jsp?cno=${ cno }&page=${index}"> ${ index } </a></li>`
		
	}
	
	html += `<li class="page-item"><a class="page-link" href="board.jsp?cno=${ cno }&page=${ page >= totalpage ? totalpage : page+1}"> 다음 </a></li>`;
	
	pagebox.innerHTML = html;
	
}


