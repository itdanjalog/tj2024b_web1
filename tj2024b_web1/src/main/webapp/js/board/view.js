
const onView = () => {
	
	const bno = new URL( location.href ).searchParams.get('bno');
	
	// [2]
	const option = {
		method : 'GET'
	}
	// [3] 
	fetch( `/tj2024b_web1/board/view?bno=${ bno }` , option )
		.then( r => r.json() )
		.then( data =>{
			
			document.querySelector('.btitlebox').innerHTML = `<img src="/tj2024b_web1/upload/${ data.mimg }" style="width:30px;     border-radius: 10px;"/> ${data.btitle}`;
			document.querySelector('.bcontentbox').innerHTML = data.bcontent;
			
			
			onRply( bno );
								
		})
		.catch( e =>{ console.log(e) })
}

onView();

const onRply = ( bno ) => {
	
	
	// [2]
	const option = {
		method : 'GET'
	}
	// [3] 
	fetch( `/tj2024b_web1/reply?bno=${ bno }` , option )
		.then( r => r.json() )
		.then( data =>{
			console.log( data );					
			
			
			const replybox = document.querySelector('.replybox')
			
			let html = ``;
			
			data.forEach( reply =>{
				
				html += `<div class="card mt-4">
				  <div class="card-header" style="display: flex;justify-content: space-between;">
				  	<div>
						<img src="/tj2024b_web1/upload/${ reply.mimg }" style="width:30px;     border-radius: 10px;"/> 
						<span> ${ reply.mid } </span> 
					</div>
				    <div>
						<span> ${ reply.rdate } </span>
					</div>
				  </div>
				  <div class="card-body">
				    ${ reply.rcontent } 
				  </div>
				</div>`	
				
			})
			
			replybox.innerHTML = html; 
			
		})
		.catch( e =>{ console.log(e) })
	
}

const onRplyWrite = ( ) => {
	
	const bno = new URL( location.href ).searchParams.get('bno');
	
	const rcontent = document.querySelector('.rcontent').value;
	
	let obj = { bno : bno , rcontent : rcontent }
	// 4. fetch option 
	const option = { 
		method : 'POST', 
		headers : { 'Content-Type' : 'application/json'} ,
		body : JSON.stringify( obj ) // - JSON형식(모양)의 문자열 타입으로 변환
	}
	// 5.
	fetch( '/tj2024b_web1/reply' , option )
		.then( r => r.json() )
		.then( data => {
			console.log( data );
			if( data == true ){
				alert('댓글 성공');
				onRply( bno );
			}else{
				alert('댓글 실패');
			}
		})
		.catch( e => { console.log(e); })
		
}








