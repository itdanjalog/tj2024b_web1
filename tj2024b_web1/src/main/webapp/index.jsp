<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page = "/header.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <!-- 캐러셀 코드 넣어주기 -->
    <div id="carouselExample" class="carousel slide">
        <div class="carousel-inner">
            <!-- [1] 캐러셀 에 적용될 이미지 1개 -->
            <div class="carousel-item active">
                <img src="/img/mainbanner1.jpg" class="d-block w-100" alt="...">
            </div>

            <!-- [1] 캐러셀 에 적용될 이미지 1개 -->
            <div class="carousel-item">
                <img src="/img/mainbanner2.jpg" class="d-block w-100" alt="...">
            </div>

            <!-- [1] 캐러셀 에 적용될 이미지 1개 -->
            <div class="carousel-item">
                <img src="/img/mainbanner3.jpg" class="d-block w-100" alt="...">
            </div>

        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <div class="container"> <!-- 부트스트랩에서 제공하는 class (container : 반응형(디바이스크기에따라 자동크기조절) 박스/구역 ) -->
        <h3> 여기는 메인페이지 </h3>
    </div>

</body>
</html>