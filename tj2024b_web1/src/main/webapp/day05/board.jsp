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
		<h3> 더조은 커뮤니티 </h3>
		<a href="write.jsp"> 글쓰기 </a>
		<table border="1">
			<thead>
				<tr>
					<th> 번호 </th>
					<th> 제목 </th>
					<th> 작성자 </th>
					<th> 작성일 </th>
					<th> 조회수 </th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td> 1 </td>
					<td> <a href="view.jsp?bno=1">제목이 들어가는곳</a> </td>
					<td> 유재석 </td>
					<td> 2025-01-22 </td>
					<td> 3 </td>
				</tr>
			</tbody>
		</table>
	</div>


</body>
</html>