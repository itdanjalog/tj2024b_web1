<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page = "/header.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
   	<link href="/css/member/info.css" rel="stylesheet" />
</head>
<body>

    <div class="container col-xl-10 col-xxl-8 px-4 py-5">
        <div class="row g-lg-5 py-5">
            <div class="col-md-10 mx-auto col-lg-5">
                <form class="p-4 p-md-5 border rounded-3 bg-body-tertiary">

                    <div class="form-floating mb-3">
                        <h5> 내정보 </h5>
                    </div>
                    
                    <div class="form-floating mb-3 mimgbox">
                        <img src="" class="mimg" />
                    </div>
                    
                    <div class="form-floating mb-3">
                        <input type="text" readonly value="" class="form-control midInput" id="floatingInput" placeholder="ID">
                        <label for="floatingInput">계정아이디</label>
                    </div>

                    <div class="form-floating mb-3">
                        <input type="text" readonly value="" class="form-control mnameInput" id="floatingInput" placeholder="Name">
                        <label for="floatingInput">닉네임</label>
                    </div>

                    <div class="form-floating mb-3">
                        <input type="text" readonly value="" class="form-control mphoneInput" id="floatingInput" placeholder="phone">
                        <label for="floatingInput">연락처</label>
                    </div>

                    <button class="w-100 btn btn-lg btn-primary" type="button" onclick="location.href='/member/update.jsp'"> 회원수정 </button>
                    <hr class="my-4">
                    <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onDelete()"> 회원탈퇴 </button>
                </form>
            </div>
        </div>
    </div>

    <script src="/js/member/info.js"></script>

</body>
</html>