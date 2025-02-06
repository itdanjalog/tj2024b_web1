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
		
		
		<a href="write.jsp"> 글쓰기 </a>
		
		<table class="table boardlist">
			<thead>
				<tr>
					<th> 번호 </th>
					<th style="width: 50%"> 제목 </th>
					<th> 작성자 </th>
					<th> 조회수 </th>
					<th> 작성일 </th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		
		</table>
		
	</div>

	<script src="/tj2024b_web1/js/board/board.js"></script>
	
</body>
</html>