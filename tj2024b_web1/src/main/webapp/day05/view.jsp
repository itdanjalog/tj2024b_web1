<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	﻿<%@ include file="/day05/header.jsp" %>

	<div>
		<h3> 글쓰기 </h3>
		<form>
			<div> <span> 작성자 </span> <span> 작성일 </span> <span> 조회수 </span></div>
			<div> 제목이 들어가는 곳 </div>
			<div> 내용이 들어가는 곳 </div>
			<div>
				<button type="button"> 수정 </button>
				<button type="button"> 삭제 </button>
			</div>
		</form>
	</div>


</body>
</html>