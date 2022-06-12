<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
  
     %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- /.website title -->
<title>게시판 | 상세보기</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<meta charset="UTF-8" />
<!-- CSS Files -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="fonts/icon-7-stroke/css/pe-icon-7-stroke.css"
	rel="stylesheet">
<link href="css/animate.css" rel="stylesheet" media="screen">
<link href="css/owl.theme.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">

<!-- Colors -->
<!-- <link href="css/css-index-blue.css" rel="stylesheet" media="screen"> -->
<!-- <link href="css/css-index-green.css" rel="stylesheet" media="screen"> -->
<!-- <link href="css/css-index-purple.css" rel="stylesheet" media="screen"> -->
<!-- <link href="css/css-index-red.css" rel="stylesheet" media="screen"> -->
<!-- <link href="css/css-index-orange.css" rel="stylesheet" media="screen"> -->
<link href="css/stacktable.css" rel="stylesheet" media="screen">
<link href="css/css-index-yellow.css" rel="stylesheet" media="screen">

<!-- Google Fonts -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />

<!-- jQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"
	defer></script>
<style type="text/css">
a{
    color: #d1b702;
    outline: 0;
    font-weight: bold;
    -webkit-transition: all .8s ease;
    transition: all .8s ease;
} 
</style>

<script type="text/javascript">
function setThumbnail(event){//미리보기
    let file = event.target.files[0];
    if (!file.type.match("image.png")&&!file.type.match("image.jpg")&&!file.type.match("image.jpeg")) {
        alert("jpg/jpeg/png 이미지 파일만 업로드 가능합니다.");
        $(inputId).val("");
        return;
    }//end if
	if(file){
		var reader = new FileReader();
		reader.onload = function(event){
			$("#thumbnail").attr("src",event.target.result);//포스터 보이기
		}//onload
		reader.readAsDataURL(file);
	}//end if
}//setThumbnail

function modifyBoard(){
	if($("#bdTitle").val()==""){
		alert("제목을 입력해주세요");
		$("#bdTitle").focus();
		return;
	}
	if($("#textDesc").val()==""){
		alert("본문을 입력해주세요");
		$("#textDesc").focus();
		return;
	}
	if(confirm("게시글을 수정하시겠습니까?")){
	
		var formData = new FormData();
		  
		formData.append("bd_id",${detailData.bd_id});
		formData.append("title",$("#bdTitle").val());
		formData.append("description",$("#textDesc").val());
		formData.append("userid",'${detailData.userid}');
		formData.append("cat_num",${detailData.cat_num})
		if($("#img").get(0).files[0] != null){//파일 수정이 있을 경우 
			formData.append("img_s3",$("#img").get(0).files[0]);
			formData.append("img_file",$("#img").val());
		}//end if
	$.ajax({
		url:"modifyBoard.do",
		type:"post",
		processData:false,
		contentType: false,
		dataType:"text",
		data:formData,
		success:function(msg){
			if(msg == 1){
				alert("게시글 수정이 완료되었습니다.");
				location.reload();
			}else if(msg >1 || msg < 0){
				alert("게시글 수정 중 오류 발생");
			}else{
				alert(msg);
			}
		},
		error:function(xhr){
			alert(xhr.status);
		}
	});//ajax
		
	}//end if
	
}//modifyBoard

function deleteBoard(){
	if(confirm("게시글을 삭제하시겠습니까?")){
		
		var formData = new FormData();
		  
		formData.append("bd_id",${detailData.bd_id});
		formData.append("userid",'${detailData.userid}');
		formData.append("img_file",$("#hidImg").val());
		formData.append("isdeleted",'y');
		
	$.ajax({
		url:"modifyBoard.do",
		type:"post",
		processData:false,
		contentType: false,
		dataType:"text",
		data:formData,
		success:function(msg){
			if(msg == 1){
				alert("게시글 삭제가 완료되었습니다.");
				location.href="board.do";
			}else if(msg >1 || msg < 0){
				alert("게시글 삭제 중 오류 발생");
			}else{
				alert(msg);
			}
		},
		error:function(xhr){
			alert(xhr.status);
		}
	});//ajax
		
	}//end if
}
function addComm(){
	if(confirm("댓글을 추가하시겠습니까?")){
		
		var formData = new FormData();
		  
		formData.append("bd_id",${detailData.bd_id});
		formData.append("reply_userid",'${detailData.userid}');
		formData.append("reply_description",$("#reply_description").val());
		
	$.ajax({
		url:"insertComm.do",
		type:"post",
		processData:false,
		contentType: false,
		dataType:"text",
		data:formData,
		success:function(msg){
			if(msg == 1){
				alert("댓글 추가가 완료되었습니다.");
				location.reload();
			}else if(msg >1 || msg < 0){
				alert("댓글 추가 중 오류 발생");
			}else{
				alert(msg);
			}
		},
		error:function(xhr){
			alert(xhr.status);
		}
	});//ajax
		
	}//end if
}
</script>
</head>

<body data-spy="scroll" data-target="#navbar-scroll">
	<!-- /.preloader -->
	<div id="preloader"></div>
	<div id="top"></div>


	<!-- /.parallax full screen background image -->
	<div class="fullscreen landing parallax blog-page"
		style="background-image: url('images/bg-baner.jpg');"
		data-img-width="2000" data-img-height="1333" data-diff="100">

		<div class="overlay">
			<div class="container">
				<div class="col-md-10 col-md-offset-1 text-center">

					<!-- /.logo -->
					<div class="logo wow fadeInDown" style="margin-top: 50px">
						<a href="index.do">Exhibition</a>
					</div>



				</div>
			</div>
		</div>
	</div>


	<!-- NAVIGATION -->
	<div id="menu">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-backyard">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand site-name" href="#top">Exhibition</a>
			</div>

			<div id="navbar-scroll"
				class="collapse navbar-collapse navbar-backyard navbar-right">
				<ul class="nav navbar-nav">
					<li><a href="list.do">전체 전시 보기</a></li>
					<li><a href="loc.do">지역별 전시 보기</a></li>
					<li><a href="reservation.do">예약하기</a></li>
					<li><a href="board.do">게시판</a></li>

				</ul>
			</div>
		</div>
	</div>


	<!-- /.pricing section -->
	<div id="myaccount">
		<div class="container">
			<div class="text-center ">
				<!-- /.pricing title -->
				<h2 class="wow fadeInLeft">상세 게시판</h2>
				<div class="title-line wow fadeInRight"></div>
			</div>
			<div class="row account-details">

				<!-- /.account-control -->
				<div
					class="panel panel-default sidebar-menu wow  fadeInLeft animated">
				</div>
				<div class="panel-heading">
					<h3 class="panel-title">제목</h3>
					<input class="form-control" type="text" ${(sessionScope.id eq detailData.userid or sessionScope.mgr == 'y')? "":"readonly"}
						style="background: #ffffff" value="${detailData.title}" id="bdTitle"/>
						<div style="border: 1px solid #A5A5A5; margin-top: 10px">
					<%--  <input type="hidden" value="${detailData.img_file}" id="hidImg"/> --%>
					 
					 <img id="thumbnail" <c:if test="${not empty detailData.img_file}">src='${detailData.img_file}'</c:if>/> 
					<textarea name="ta" ${(sessionScope.id eq detailData.userid) or (sessionScope.mgr == 'y')? "":"readonly"} id="textDesc"
						style="background: #ffffff;border: 0px ;resize: none; width: 100%; height1000px;margin-top: 10px;" >${detailData.description}</textarea> 
						</div>
					<c:if test="${(sessionScope.mgr == 'y')}">
						<input type="file" name="img" id="img" accept="image/jpg,image/jpeg,image/png" onchange="setThumbnail(event)"/>
					</c:if>
				</div>
				</div>
				
					<i class="fa fa-comment fa" ></i> 댓글
				<div class="card-body">
					<ul class="list-group list-group-flush">
						<li class="list-group-item">
							<div class="form-inline mb-2">
								<label for="replyId"><i	class="fa fa-user-circle-o fa-2x"></i></label>
							</div> 
							<c:if test="${not empty sessionScope.id }">
							<textarea class="form-control" id="reply_description" name="reply_description" style="width: 100%;resize: none;"
								rows="3"></textarea>
							<button type="button" class="btn btn-dark mt-3" style="margin-top:10px;" id="commentBtn" onclick="addComm()">댓글 작성</button>
							</c:if>
							<c:if test="${empty sessionScope.id }">
							<textarea class="form-control" id="ta"  readonly name="reply_description" style="width: 100%;resize: none;"
								rows="3">로그인 후에 이용 가능 합니다.
							</textarea>
							</c:if>
						</li>
						<c:forEach var="boardComment" items="${comList }">
						<li>
						<div>
							<input type="text" value="${boardComment.reply_userid }" style="border:none; text-align: center" readonly="readonly" disabled="disabled" />
							<input type="text" style="width: 50%; margin-top: 10px ; border:none" readonly="readonly" disabled="disabled" value="${boardComment.reply_description }"/>
							<input type="text" value="${boardComment.reply_input_date }"  style="border:none; text-align: center" readonly="readonly" disabled="disabled"/>
							
							<c:if test="${(sessionScope.id eq boardComment.reply_userid ||sessionScope.mgr == 'y')}"> 
								<a href="deleteComm.do?reply_id=${boardComment.reply_id  }&bd_id=${detailData.bd_id}"><button type="button" class="btn btn-dark mt-3" style="margin-top:10px;" id="commenDeltBtn">댓글 삭제</button></a>
							</c:if> 
						</div>
						</li>
						</c:forEach>
					</ul>
				</div>
				<br />
				<div>
				<a href="board.do">
				<input type="button" value="확인" id="btn" class="btn btn-warnil;;;;;;;;;hgng " style="width: 30%;margin-left:35% "/>
				</a>
				</div>
				
					<c:if test="${sessionScope.id eq detailData.userid or sessionScope.mgr == 'y'}">
					<div>
					 <div style="float:right;">
					 <input type="button" value="글 삭제"  class="btn btn-warning btn-block btn-lg" style="width:100% " onclick='deleteBoard()'/>
					 </div>
					 <div style="float:right;margin-right:20px;">
					<input type="button" value="글 수정"  class="btn btn-warning btn-block btn-lg" style=" width:100%;" onclick='modifyBoard()'/>
					 </div>
					</div>
					</c:if>
			</div>
			

		</div>





	<!-- /.footer -->
	<footer id="footer">
		<div class="footer-top">
			<div class="container">
				<div class="">
					<div class="col-md-4 col-sm-6">
						<h4>고객 센터</h4>
						<p>
							<strong>3조</strong> <br>전화 번호 :081) 123-1234 <br>상담 가능
							시간: AM 10:00~PM 05:00 <br>관련 이메일: exhibition@naver.com
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

								<div class="clear"></div>
							</div>
						</div>
					</div>
					<!-- /.col-md-4 -->

				</div>
			</div>
		</div>
	</footer>




	<!-- /.javascript files -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>

	<script>
		new WOW().init();
	</script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#btn").click(function() {
			$("#frm").submit();
		});
		$("#commentBtn").click(function(){
			$("#commentFrm").submit();
		});
		
	});
</script>

</body>
</html>