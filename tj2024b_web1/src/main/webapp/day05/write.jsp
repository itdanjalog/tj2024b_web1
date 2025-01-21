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
			<input type="text" placeholder="작성자" />		
			<input type="password" placeholder="비밀번호" />		<br/>
			<input type="text" placeholder="제목">			<br/>
			<textarea rows="10" cols="50" placeholder="내용"></textarea> <br/>
			<button type="button"> 등록 </button>
		</form>
	</div>


</body>
</html>