<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page = "/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div class="container">

        <div>
            <h3> 카카오 지도 </h3>
            <div id="map" style="width:100%;height:600px;"></div> <!-- 먼저 지도를 담기 위한 영역 -->
            
        </div>

        <h3> 공공데이터 : 안산시 원곡동 일반음식점 </h3>
        <table class="table">
            <thead>
                <tr>
                    <th> 공원명 </th>
                    <th> 공원 주소 </th>
                    <th> 전화번호 </th>
                    <th> 공원 면적(제곱킬로미터) </th>
                </tr>
            </thead>
            <tbody class="apiTable2">

            </tbody>
        </table>

    </div>

	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd&libraries=clusterer"></script>
    <script src="/js/api/data.js"></script>
    

</body>
</html>