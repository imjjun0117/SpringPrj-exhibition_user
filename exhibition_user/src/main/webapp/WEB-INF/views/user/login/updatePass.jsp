<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="/error.jsp"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>

        <!-- /.website title -->
        <title>VTC Theme | FQA Page</title>
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

    </head>
<c:if test="${msg eq 1}">
	<script type="text/javascript">
		alert("죄송합니다. 다시 변경해주세요.");
	</script>
</c:if>

    <body data-spy="scroll" data-target="#navbar-scroll">

        <!-- /.preloader -->
        <div id="preloader"></div>
        <div id="top"></div>

        <!-- /.parallax full screen background image -->
        <div class="fullscreen landing parallax blog-page" style="background-image:url('images/bg-baner.jpg');" data-img-width="2000" data-img-height="1333" data-diff="100">

            <div class="overlay">
                <div class="container">
                    <div class="col-md-10 col-md-offset-1 text-center">

                        <!-- /.logo -->
                        <div class="logo wow fadeInDown" style="margin-top: 50px"> 
                            <a href="index.jsp">Exhibition</a>
                        </div>

                        <!-- /.main title -->
                        <h2 class="wow fadeInUp" style="margin-bottom: 50px">
                           비밀번호 재설정
                        </h2>

                    </div>
                </div> 
            </div> 
        </div>
            <!-- NAVIGATION -->
        <!-- /.Cars section -->
        <div id="sign-in" style="margin-left: 30%">
            <div class="container">
                <div class="col-sm-6">
                    <div class="text-center">
                        <h2 class="wow fadeInLeft">비밀번호 수정</h2>
                        <div class="title-line wow fadeInRight"></div>
                    </div>
                    <div class="row sign-in">

                        <form action="http://localhost/exhibition_user/updatePass.do" method="post" name="findform" id="findform" >
                         <div>
							<label>비밀번호를 변경해주세요.</label>
						</div>
						<div class="form-label-group">
						<input type="hidden" id="id" name="updateid" value="${updateid }">
						
							<input type="password" id="password" name="password" class="form-control"/>
							<label for="password">비밀번호</label>
						</div>
						
						<div class="form-label-group">
							<input type="password" id="confirmpassword" name="confirmpassword" class="form-control"/>
							<label for="confirmpassword">비밀번호확인</label>
						</div>
						
						<div class="form-label-group">
								<input class="btn btn-lg btn-secondary btn-block text-uppercase"
									type="button" value="비밀번호 변경하기" onclick="updatePassword()">
							</div>
				         </form>
		
			<script type="text/javascript">
		function updatePassword(){
			if(document.findform.password.value==""){
				alert("비밀번호를 입력해주세요.");
				document.findform.password.focus();
			} else if(document.findform.password.value != document.findform.confirmpassword.value){
				alert("비밀번호가 일치하지 않습니다.");
				document.findform.confirmpassword.focus();
			} else {
				document.findform.submit();
			}
		}
			</script>
                    </div>
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
        <script src="/exhibition_user/js/jquery.js"></script>
        <script src="/exhibition_user/js/bootstrap.min.js"></script>
        <script src="/exhibition_user/js/bootstrap-datetimepicker.min.js"></script>
        <script src="/exhibition_user/js/custom.js"></script>
        <script src="/exhibition_user/js/jquery.sticky.js"></script>
        <script src="/exhibition_user/js/wow.min.js"></script>
        <script src="/exhibition_user/js/owl.carousel.min.js"></script>
            <script src="/exhibition_user/js/jquery.validate.min.js"></script> 



<script type="text/javascript">


/* $(function(){
	$("#pass_find").click(function(){
		var name=$("#name").val();
		var id=$("#userId").val();
		var phone=$("#tel").val();
		
		if(name==""){
			alert("이름을 입력하세요.");
			return;
		}else if(id==""){
			alert("아이디를 입력하세요.");
			return;
		}else if(phone==""){
			alert("휴대폰번호를 입력하세요.");
			return;
		}
		$("#frm").submit();
	});
}); */
</script>
        <script>
            new WOW().init();

        </script>

    </body>
</html>