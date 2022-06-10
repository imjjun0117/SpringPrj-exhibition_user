<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userId check</title>  
<style>
:root { -
	-input-padding-x: 1.5rem; -
	-input-padding-y: .75rem;
}

body {
	background-color: white;
}

.card-signin {
	border: 0;
	border-radius: 1rem;
	box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
	overflow: huserIdden;
}

.card-signin .card-title {
	margin-bottom: 2rem;
	font-weight: 300;
	font-size: 1.5rem;
}

.card-signin .card-body {
	padding: 2rem;
}

.form-signin {
	wuserIdth: 100%;
}

.form-signin .btn {
	font-size: 80%;
	border-radius: 5rem;
	letter-spacing: .1rem;
	font-weight: bold;
	padding: 1rem;
	transition: all 0.2s;
}

.form-label-group {
	position: relative;
	margin-bottom: 1rem;
}

.form-label-group input {
	height: auto;
	border-radius: 2rem;
}

.form-label-group>input, .form-label-group>label {
	padding: var(- -input-padding-y) var(- -input-padding-x);
}

.form-label-group>label {
	position: absolute;
	top: 0;
	left: 0;
	display: inline_block;
	wuserIdth: 100%;
	margin-bottom: 0;
	/* OverruserIde default `<label>` margin */
	line-height: 1.5;
	color: #495057;
	border: 1px soluserId transparent;
	border-radius: .25rem;
	transition: all .1s ease-in-out;
}
</style>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/modern-business.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="jquery/jquery.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<script type="text/javascript">
		function userIdok() {
			opener.joinform.userId.value = "dd";
			opener.joinform.reuserId.value = "dd";
			self.close();
		}
		
		function check(){
			console.log()
			$("#button").css({
				display : ""
			});
		}
		
	</script>

	<form method="post" class="form-signin" action="http://localhost/user/login/idcheck.do" name="joinform">
		<div class="form-label-group">
			<input type="text" id="userId" name="userId" class="form-control" value="${userId}"/>
		</div>

		<!-- 아이디가 존재할 때 -->
		<c:if test="${check == 1}">
			<script>
				opener.document.joinform.userId.value = "";
			</script>
			${userId}는 사용중인 아이디입니다.
		</c:if>

		<!-- 아이디가 존재하지 않을 때 -->
		<c:if test="${check == 0 }">
		${userId}는 사용가능한 아이디입니다.
		</c:if>
		<div class="form-label-group">
			<input class="btn btn-lg btn-secondary btn-block text-uppercase"
				type="submit" value="check" onclick="check()">
		</div>

		<div class="form-label-group">
				<input class="btn btn-lg btn-secondary btn-block text-uppercase"
					type="button"  id="button" style="display:none" value="사용할수있는아이디입니다." onclick="userIdok()">
			</div>

	</form>

</body>
</html>