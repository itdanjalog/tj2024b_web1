<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<jsp:include page="/header.jsp"></jsp:include>
	
	<div class="container mt-5">
		
		
		<div class="btitlebox">
		
		</div>
		
		<div class="bcontentbox" style="min-height: 500px;">
		
		</div>
		
		<div>
			<textarea class="form-control rcontent"></textarea>
			<button onclick="onRplyWrite()" type="button" class="btn btn-primary"> 댓글게시 </button>
		</div>
		<div class="replybox">
			
		</div>
		
	</div>

	<script src="/tj2024b_web1/js/board/view.js"></script>
	
</body>
</html>