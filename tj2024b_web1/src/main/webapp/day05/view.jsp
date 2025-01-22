<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="/day05/header.jsp"></jsp:include>
	
	<div>
		<h3> 게시물 개별 조회 : 상세페이지로 선택한 특정 게시물을 조회 합니다. </h3>
		<div> 
			작성일:<span class="bdatebox">  </span>
			작성자:<span class="bwriterbox">  </span>
			조회수:<span class="bviewbox">  </span>
		</div>
		<div class="btitlebox">  </div>
		<div class="bcontentbox"> </div>
		
		<div class="etcbtns">
			<button onclick="boardDelete()">삭제</button>
			<button onclick="boardUpdate()">수정</button>
		</div>
	</div>
	
	<script src="view.js"></script>
	
	<jsp:include page="/day05/footer.jsp"></jsp:include>

</body>
</html>













