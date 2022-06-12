<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONArray"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
	

<!DOCTYPE html>
<html>
    <head>

        <!-- /.website title -->
        <title>전시 상세</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

        <meta charset="UTF-8" />
        <!-- CSS Files -->
        <link href="/exhibition_user/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="/exhibition_user/css/font-awesome.min.css" rel="stylesheet">
        <link href="/exhibition_user/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="/exhibition_user/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="/exhibition_user/css/animate.css" rel="stylesheet" media="screen">
        <link href="/exhibition_user/css/owl.theme.css" rel="stylesheet">
        <link href="/exhibition_user/css/owl.carousel.css" rel="stylesheet">
        <link href="/exhibition_user/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

        <!-- Colors -->
        <!-- <link href="css/css-index-blue.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-green.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-purple.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-red.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-orange.css" rel="stylesheet" media="screen"> -->
        <link href="/exhibition_user/css/css-index-yellow.css" rel="stylesheet" media="screen"> 

        <!-- Google Fonts -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />
<style type="text/css">
	.wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .desc {position: relative;margin: 13px 0 0 20px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
</style>
    </head>



    <body data-spy="scroll" data-target="#navbar-scroll">


        <!-- /.preloader -->
        <div id="preloader"></div>
        <div id="top"></div>

        <!-- /.parallax full screen background image -->
        <div class="fullscreen landing parallax blog-page" style="background-image:url('http://localhost/exhibition_user/images/bg-baner.jpg');" data-img-width="2000" data-img-height="1333" data-diff="100">

            <div class="overlay">
                <div class="container">
                    <div class="col-md-10 col-md-offset-1 text-center">

                        <!-- /.logo -->
                        <div class="logo wow fadeInDown" style="margin-top: 50px"> 
                            <a href="index.do">Exhibition</a>
                        </div>

                        <!-- /.main title -->
                      

                    </div>
                </div> 
            </div> 
        </div>
        
        
             <!-- NAVIGATION -->
        <div id="menu">
               <div class="container"> 
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-backyard">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand site-name" href="index.do">Exhibition</a>
                    </div>

                    <div id="navbar-scroll" class="collapse navbar-collapse navbar-backyard navbar-right">
                        <ul class="nav navbar-nav">
                               <li><a href="list.do">전체 전시 보기</a></li>
                            <li><a href="loc.do">지역별 전시 보기</a></li>
                            <li><a href="reservation.do">예약하기</a></li>
                                    <li><a href="list.do">게시판</a></li>
                        
                        </ul>
                    </div>
                 </div>  
        </div>
          <c:forEach var="exhibitionView" items="${ exhibitionView }">
         <div id="carssection">
            <div class="container">
              
          <div class="row carssections">
                        <div class="screen wow fadeInUp" data-path-hover="m 180,34.57627 -180,0 L 0,0 180,0 z">
                            <figure >
                                <div class="screen wow fadeInUp" style="position:absolute; left:350px; width: 900px; height: 400px"><strong>${ exhibitionView.ex_num }. ${ exhibitionView.ex_name}</strong><br/>${ exhibitionView.ex_intro }</div>
                                <img src="http://localhost/exhibition_user/img/${ exhibitionView.exhibition_poster }" style="width:300px"/>
                             <a href="list.do"><input type="button"  value="예약" style="width:260px; background-color: #F0AD4E;color:#ffffff; border:0px ;margin-left: 500px"></a> 
                               <%--  <a href="catBoard.do?cat_num=${ exhibitionView.cat_num }"> --%>
                               <a href="catBoard.do?pageNum=1&cat_num=${ exhibitionView.cat_num }"><input type="button"   value="후기" style="width:260px; margin-left: 15px ;background-color: #F0AD4E;color:#ffffff; border:0px"></a> 
                            
                            </figure>
                        </div>   
                        </div>
                        </div>
                        </div>
                        <!-- 전시 상세 -->
             	<div class="container" style="width: 1200px; height: 1500px; background-color: #ffffff ;border:1px solid #E5E5E5">
             	
             	<img src="http://localhost/exhibition_user/img/${ exhibitionView.add_Img }" style="width:100%; height:500px; "/><br/><br/>
             	<div id="output"></div>${ exhibitionView.ex_info }

             	<div id="map" style="width:70%;height:350px; margin-left: 150px; margin-top: 100px"></div>
             	</div>
          </c:forEach>
             	
           <!-- /.footer -->
        <footer id="footer" >
            <div class="footer-top">
                <div class="container">
                    <div class="">
                        <div class="col-md-4 col-sm-6">
                            <h4>고객 센터</h4>
                            <p><strong>3조</strong>
                                <br>전화 번호 :081) 123-1234  
                                <br>상담 가능 시간: AM 10:00~PM 05:00
                                <br>관련 이메일: exhibition@naver.com
                            </p>
                            <hr class="hidden-md hidden-lg">
                        </div> 

                        
                        <!-- /.col-md-4 -->
                        
                        <div class="col-md-4 col-sm-6">
                            <h4>사업자 등록번호</h4>
                            <div class="newsletter-box">
                                <div class="newsletter">  
                                    <div class="newsletter-content"> 
                                        <p>123-1234-1234</p>
                                    </div> 
                                    
                                    <div class="clear"> </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col-md-4 -->

                    </div>
                    </div>
                    </div>
                    </footer>
       


        <!-- /.javascript files -->
        <script src="/exhibition_user/js/jquery.js"></script>
        <script src="/exhibition_user/js/bootstrap.min.js"></script>
        <script src="/exhibition_user/js/bootstrap-datetimepicker.min.js"></script>
        <script src="/exhibition_user/js/custom.js"></script>
        <script src="/exhibition_user/js/jquery.sticky.js"></script>
        <script src="/exhibition_user/js/wow.min.js"></script>
        <script src="/exhibition_user/js/owl.carousel.min.js"></script>
           <script src="/exhibition_user/js/jquery.validate.min.js"></script> 



	 	<script>
		new WOW().init();
		$('#date_time').datetimepicker({
			format : 'dd/MM/yyyy hh:mm:ss',
			language : 'en-US',
			pickDate : true, // disables the date picker
			pickTime : true
		});
	</script>

		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=33a56ba20c73caaac66039b100edcde8"></script>

 		<script>
 		
 		<c:forEach var="mapView" items="${ mapView }">
 		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
 	    mapOption = { 
 	        center: new kakao.maps.LatLng(${ mapView.latitude }, ${ mapView.longitude }), // 지도의 중심좌표
 	        level: 8 // 지도의 확대 레벨
 	    };

 	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 	 
 	// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
 	var positions = [

 	    {
 	        content: 
 	        '<div class="wrap">' + 
 	         '    <div class="info">' + 
 	          '        <div class="title">' + 
 	          '            <c:out value="${ mapView.ex_hall_name }"/>' + 
 	          '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
 	          '        </div>' + 
 	          '            <div class="desc">' + 
 	          '                <div class="ellipsis">주소: <c:out value="${ mapView.address1 }"/></div>' + 
 	          '                <div class="ellipsis"> <c:out value="${ mapView.address2 }"/></div><br/>' + 
 	          '                <div class="jibun ellipsis">우)<c:out value="${ mapView.zipcode }"/></div>' + 
 	          '            </div>' + 
 	          '        </div>' + 
 	          '    </div>' +    
 	          '</div>',
 	        latlng: new kakao.maps.LatLng(${ mapView.latitude }, ${ mapView.longitude })
 	    },
 	   </c:forEach>
 	];

 	for (var i = 0; i < positions.length; i ++) {
 	    // 마커를 생성합니다
 	    var marker = new kakao.maps.Marker({
 	    	
 	        map: map, // 마커를 표시할 지도
 	        position: positions[i].latlng // 마커의 위치
 	    });
 	   var overlay = new kakao.maps.CustomOverlay({
 		  content: positions[i].content ,
 		    map: map,
 		    position: marker.getPosition()       
 		});
 	   
 	    // 마커에 표시할 인포윈도우를 생성합니다 

 	    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
 	    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
 	    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
 	   kakao.maps.event.addListener(marker, 'click', function() {
 		    overlay.setMap(map);
 		});

 
 	}

 	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
 			// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
 		function closeOverlay() {
 		    overlay.setMap(null);     
 		}
 	function makeOverListener(map, marker) {
 	    return function() {
 	        infowindow.open(map, marker);
 	    };
 	}

 	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
 	function makeOutListener(infowindow) {
 	    return function() {
 	        infowindow.close();
 	    };
 	} 
 	</script>

    </body>
</html>