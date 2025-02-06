<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.css" integrity="sha512-rDHV59PgRefDUbMm2lSjvf0ZhXZy3wgROFyao0JxZPGho3oOuWejq/ELx0FOZJpgaE5QovVtRN65Y3rrb7JhdQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

	<jsp:include page="/header.jsp"></jsp:include>
	
	<div class="container mt-5">
		

		<form method="post" style="margin: 50px 0px;">
			<input type="text" class="form-control btitle" /> <br/>
			<textarea id="summernote" name="editordata" class="bcontent"></textarea> <br/>
			<button class="btn btn-primary" type="button" onclick="onWrite()"> 글등록 </button>
		</form>

	</div>
	
		
	  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.js" integrity="sha512-qTQLA91yGDLA06GBOdbT7nsrQY8tN6pJqjT16iTuk08RWbfYmUz/pQD3Gly1syoINyCFNsJh7A91LtrLIwODnw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/lang/summernote-ko-KR.min.js" integrity="sha512-npFeJw8MO1QVbeFuD7rqVR1CpAbOnUMoYnZIxDbz58biKU52Unq7Av3cn+SZ2KD4yOLWj4bOcjIV1+d4aEXAyg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
	
	<script src="/tj2024b_web1/js/board/write.js"></script>
</body>
</html>