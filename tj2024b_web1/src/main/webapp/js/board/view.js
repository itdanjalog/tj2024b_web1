
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
			
			document.querySelector('.btitlebox').innerHTML = data.btitle;
			document.querySelector('.bcontentbox').innerHTML = data.bcontent;
						
		})
		.catch( e =>{ console.log(e) })
}

onView();