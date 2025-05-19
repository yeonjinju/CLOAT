<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>CLOAT, 이미지 클로킹 서비스</title>
	<link rel="stylesheet" href="resources/assets/css/style.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
	<% String address = "서울특별시 중구 을지로 11길 23 7층"; %>
	<div id="header"></div>
	<section class="main content">

	<div id="map" style="width: 100%; height: 350px;"></div>
	
	</section>
	<div id="footer"></div>
	
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=93ef0428acf91a435ff28bf23556f61d&libraries=services"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// JSP에서 넘어온 주소를 자바스크립트 변수로 선언
	    var address = "<%= address %>";	 
	    
	 	// JSP에서 넘긴 list를 자바스크립트 배열로 생성
	    var centers = [
	    	<c:forEach var="center" items="${mapvo}" varStatus="status">
   				 {
        			name: '${center.org_name}',
        			lat: ${center.lat},
        			lng: ${center.lon}
    			 }<c:if test="${!status.last}">,</c:if>
			</c:forEach>
	    ];

	    // 카카오 지도 마커용 객체 배열 생성
	    var positions = centers.map(function(center) {
	        return {
	            title: center.name,
	            latlng: new kakao.maps.LatLng(center.lat, center.lng)
	        };
	    });
	    
	    //마커 이미지의 이미지 주소입니다
	    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	  
		// 주소로 좌표를 검색합니다
		geocoder
				.addressSearch(
						address,
						function(result, status) {

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {

								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

		
								
								for (var i = 0; i < positions.length; i ++) {
								    
								    // 마커 이미지의 이미지 크기 입니다
								    var imageSize = new kakao.maps.Size(24, 35); 
								    
								    // 마커 이미지를 생성합니다    
								    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
								    
								    // 마커를 생성합니다
								    var marker = new kakao.maps.Marker({
								        map: map, // 마커를 표시할 지도
								        position: positions[i].latlng, // 마커를 표시할 위치
								        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
								        image : markerImage // 마커 이미지 
								    });
								}

								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
							}
						});
	</script>
	<script>
		function loadHTML(id, url) {
			fetch(url)
				.then(res => res.text())
				.then(data => {
					document.getElementById(id).innerHTML = data;
				});
		}

		loadHTML("header", "resources/assets/html/header.html");
		loadHTML("footer", "resources/assets/html/footer.html");
	</script>
</body>
</html>