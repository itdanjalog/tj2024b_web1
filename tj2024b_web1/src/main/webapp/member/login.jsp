<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page = "/header.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>


    <!-- 부트스트랩의 로그인 예시 붙여넣기 -->
    <div class="container col-xl-10 col-xxl-8 px-4 py-5">
        <div class="row align-items-center g-lg-5 py-5">
            <!-- 왼쪽 구역 -->
            <div class="col-lg-7 text-center text-lg-start">
                <h1 class="display-4 fw-bold lh-1 text-body-emphasis mb-3"> KOR IT WEB LOGIN </h1>
                <p class="col-lg-10 fs-4"> 다양한 서비스를 제공 합니다.</p>
            </div>

            <!-- 오른쪽 구역 -->
            <div class="col-md-10 mx-auto col-lg-5">
                <form class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control midInput" id="floatingInput" placeholder="ID">
                        <label for="floatingInput">계정아이디</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control mpwdInput" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword">계정비밀번호</label>
                    </div>
                    <div class="checkbox mb-3">
                        <label>
                            <input type="checkbox" value="remember-me"> 자동로그인
                        </label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" onclick="onLogin()" type="button"> 로그인 </button>
                    <hr class="my-4">
                    <small class="text-body-secondary"> SNS 1초 로그인 </small>
                </form>
            </div>
        </div>
    </div>

    <script src="/js/member/login.js"></script>

</body>
</html>