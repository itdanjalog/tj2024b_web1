<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title> WebShop </title>
    <link rel="shortcut icon" href="/img/favicon.ico">
    
    <!-- 부트스트랩 css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 내가 만든 css , static 폴더 이후 경로부터 작성. -->
    <link href="/css/index.css" rel="stylesheet" />
</head>
<body>
    <div >
        <!-- 네이게이션 바 코드 붙여넣기 -->
        <nav class="navbar navbar-expand-lg">
            <div class="container">
                <!-- [1] 헤더의 로고에 img 마크업 추가 하고 링크 "/" index페이지로 이동. -->
                <a class="navbar-brand" href="/index.jsp"> <img src="/img/logo.png" style="width: 60px;"/> </a>
                <!-- [2] 반응형 (콜렙스)버튼 : 특정한 브라우저(디바이스)가 작아질때 나타는 버튼 -->
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <!-- [3] 헤더 메뉴들 -->
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!-- 왼쪽 메뉴들 -->
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <!-- [4] 메뉴1개 -->
                        <li class="nav-item">  <a class="nav-link active" href="/index.jsp"> WebShop </a>  </li>
                        <li class="nav-item">    <a class="nav-link" href="#"> 게시판 </a>    </li>
                        <li class="nav-item">    <a class="nav-link" href="/api/data.jsp"> 공공데이터 </a>    </li>
                        <!-- [5] 드랍메뉴 -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                판매제품
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#"> 커피 </a></li>
                                <li><a class="dropdown-item" href="#"> 스무디 </a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#"> MD </a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- 오른쪽 메뉴들 -->
                    <ul class="navbar-nav me-end mb-2 mb-lg-0 memberBox" >

                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <!-- -->
    <script src="/js/header.js"></script>
    <!-- 부트스트랩 JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>