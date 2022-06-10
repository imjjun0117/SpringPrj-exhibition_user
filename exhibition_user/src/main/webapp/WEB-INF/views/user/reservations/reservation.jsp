<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <!-- /.website title -->
        <title>전시 예약</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta charset="UTF-8" />
        <!-- CSS Files -->
        <link href="http://localhost/sist/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="http://localhost/sist/css/font-awesome.min.css" rel="stylesheet">
        <link href="http://localhost/sist/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="http://localhost/sist/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="http://localhost/sist/css/animate.css" rel="stylesheet" media="screen">
        <link href="http://localhost/sist/css/owl.theme.css" rel="stylesheet">
        <link href="http://localhost/sist/css/owl.carousel.css" rel="stylesheet">
        <link href="http://localhost/sist/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

        <!-- Colors -->
        <!-- <link href="css/css-index-blue.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-green.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-purple.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-red.css" rel="stylesheet" media="screen"> -->
        <!-- <link href="css/css-index-orange.css" rel="stylesheet" media="screen"> -->
        <link href="http://localhost/sist/css/css-index-yellow.css" rel="stylesheet" media="screen"> 

        <!-- Google Fonts -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />

    </head>
    


    <body data-spy="scroll" data-target="#navbar-scroll">

        <!-- /.preloader -->
        <div id="preloader"></div>
        <div id="top"></div>


        <!-- /.parallax full screen background image -->
        <div class="fullscreen landing parallax" >

            <div class="overlay">
                <div class="container" >
                    <div class="row">
                      <div class="col-md-7">

                            <!-- /.logo -->
                            <div class="logo wow fadeInDown">
                                <a href="index.do">Exhibition</a>
                            </div>

                            <!-- /.main title -->
                            <h1 class="wow fadeInLeft">
                                 <span class="color">전시 예약하기</span> 
                            </h1>

                                  
                            <!-- /.header paragraph -->
                            <div class="landing-text wow fadeInUp">
                            <ul style="color:#FFFFFF">
                            <c:forEach var="exInfo" items="${exInfo}">
                                <li><strong><c:out value="${exInfo.ex_name}"/></strong></li>
                                <li><img src="http://localhost/sist/img/${exInfo.exhibition_poster}" style="width: 40%; align-content: c"/></li>
                                <li><c:out value="${exInfo.ex_info}"/></li>
                            </c:forEach>
                            </ul>
                            </div>				  

                 

                        </div> 

                        <!-- /.signup form -->
                        <div class="col-md-5">

                            <div class="signup-header wow fadeInUp">
                                <h3 class="form-title text-center">예약</h3>
                                    <div id="booking_control" class="booking_control">
                                   		<form id="chooseExName" action="reservation.do" method="get">
                                           <div class="form-group">
                                            <select class="form-control input-lg" name="ex_num" id="exName">
                                           <c:forEach var="exName" items="${exName}">
                                            <option id="exName" value="${exName.ex_num}" ${(exName.ex_num eq param.ex_num)?"selected='selected'":""}>${exName.ex_name}</option>
                                            </c:forEach>
                                            </select>
                                        </div> 
                                        </form>
                                         
      									  <form action="rezProcess.do" method="POST" id="rezFrm" name="rezFrm">
      									  <input type="hidden" value="test1@test.com" name="userid"/>
      									  <c:forEach var="exName" items="${exName}">
      									  <input type="hidden" value="${exName.ex_num}" name="ex_num"/>
      									  </c:forEach>
      									  <div class="form-group">
      									  <c:forEach var="exInfo" items="${exInfo}">
	      									  <input class="form-control input-lg" type="text" value="${exInfo.ex_loc} / ${exInfo.address1}" readonly="readonly"/>
      									  </c:forEach>
      									  </div>
                                           <div id="date_time" class="form-group">
                                           <input class="form-control input-lg" name="visit_date" class="pick_up_date" id="pick_up_date" type="text" placeholder="방문날짜선택" required>
                                            <a class="add-on btn-geolocation btn-calendar" href="#"><i class="pe-7s-date" style="margin-top: 58px"></i></a>
                                        </div>
                                        <div class="form-group">
										<input class="form-control input-lg" type="number" name="rez_count" value="3" />
                                            
                                        </div>
      									  </form>
                                        <div class="form-group last">
                                         <input type="button" id="rezBtn" class="btn btn-warning btn-block btn-lg" value="예약하기"/>
                                        </div>
                                    </div>
                                    </div>
             
                            </div>				

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
                        <a class="navbar-brand site-name" href="index.jsp">Exhibition</a>
                    </div>

                    <div id="navbar-scroll" class="collapse navbar-collapse navbar-backyard navbar-right">
                        <ul class="nav navbar-nav">
                             <li><a href="list.jsp">전체 전시 보기</a></li>
                            <li><a href="loc.jsp">지역별 전시 보기</a></li>
                            <li><a href="reservation.jsp">예약하기</a></li>
                                    <li><a href="board.jsp">게시판</a></li>
                        
                        </ul>
                    </div>
                 </div>  
        </div>
        

 <!-- /.footer -->
        <footer id="footer">
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
        <script src="http://localhost/sist/js/jquery.js"></script>
        <script src="http://localhost/sist/js/bootstrap.min.js"></script>
        <script src="http://localhost/sist/js/bootstrap-datetimepicker.min.js" ></script>
        <script src="http://localhost/sist/js/bootstrap-datetimepicker.kr.js" charset="UTF-8"></script>
        <script src="http://localhost/sist/js/custom.js"></script>
        <script src="http://localhost/sist/js/jquery.sticky.js"></script>
        <script src="http://localhost/sist/js/wow.min.js"></script>
        <script src="http://localhost/sist/js/owl.carousel.min.js"></script>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script>
        <script src="http://localhost/sist/js/google.js"></script> 
        <script src="http://localhost/sist/js/booking.js"></script> 
        <script src="http://localhost/sist/js/bootstrap-hover-dropdown.js"></script> 
        <script src="http://localhost/sist/js/jquery.validate.min.js"></script> 
        <script type="text/javascript" src="http://localhost/sist/js/ko.js"></script>
        <script src="http://localhost/sist/js/snap.svg-min.js"></script> 

        <script>
      
        
                                                new WOW().init();
                                                $('#date_time').datetimepicker({
                                                	
                                                    format: 'yyyy-MM-dd ',
                                                    language:'kr',
                                                    todayHighlight : true,
                                                    startDate: new Date(),
                                                    endDate :(new Date($("#deadline").val()))
                                                });
                                               
                                                
                                               
                                                   
        </script>

        <script>
            (function () {
                function init() {
                    var speed = 250,
                            easing = mina.easeinout;
                    [].slice.call(document.querySelectorAll('#carssections > a')).forEach(function (el) {
                        var s = Snap(el.querySelector('svg')), path = s.select('path'),
                                pathConfig = {
                                    from: path.attr('d'),
                                    to: el.getAttribute('data-path-hover')
                                };

                        el.addEventListener('mouseenter', function () {
                            path.animate({'path': pathConfig.to}, speed, easing);
                        });

                        el.addEventListener('mouseleave', function () {
                            path.animate({'path': pathConfig.from}, speed, easing);
                        });
                    });
                }
                init();
            })();
        </script>

<script type="text/javascript">

	$("#exName").on('change',function(){
		var exName= $("#exName").val();
		$("#chooseExName").submit();
	});
	$("#exhibition").on('change',function(){
		$("#exFrm").submit();
	});

	

	$("#rezBtn").click(function(){
	var reser=document.getElementById("pick_up_date").value;
	if(reser==""){
		alert("날짜를 선택해주세요.");
		return;
	} 
   $("#rezFrm").submit();
	});//click
	
</script>


    </body>
</html>