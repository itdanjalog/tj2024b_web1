<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<h5> [1] 클릭 이벤트로 람다식 함수 호출 </h5>
		<button onclick="func1()"> func1 </button>
		
		<h5> [2] Fetch 함수 이용한 HTTP METHOD 통신 </h5>
		<button onclick="func2()"> func2(GET) </button>
		<button onclick="func3()"> func3(POST) </button>
		<button onclick="func4()"> func4(PUT) </button>
		<button onclick="func5()"> func5(DELETE) </button>
	
		<h5> [3] Fetch 함수 이용한 HTTP queryString </h5>
		<button onclick="func6()"> func6(GET) </button>
		<button onclick="func7()"> func7(POST) </button>
		<button onclick="func8()"> func8(PUT)</button>
		<button onclick="func9()"> func9(DELETE)</button>
	</div>
	



	<!-- JS 호출 -->
	<script src="example2.js"></script>
	
</body>
</html>




















