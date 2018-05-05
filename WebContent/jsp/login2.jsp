<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
	<meta name="renderer" content="webkit">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" type="text/css" />
    <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
    <style type="text/css">
    	body{
    		background: url(../img/login.png) repeat center 0px;
    	}
    </style>
</head>
<body >
	<div class="page-con">
		<div>
			<span id="logo-text">Process<label>On<span class="logo-dot rotate"></span></label></span>
		</div>
		<div>
			<form name="loginform" id="loginform" action="#" method="post">
				<div style="margin-top: 25px; position: relative;">
					<input id="username" name="username" value="" class="txt" type="text" placeholder='账号' />
				</div>
				<div class="login-input" style="margin-top: 20px; position: relative;">
					<input name="password" id="password" class="txt" type="password" placeholder='密码' />
				</div>
				<div style="margin-top: 20px;">
					<span id="signin_btn" onclick="login()" class="button">立即登录</span>
				</div>
				<input id="loginsubmit" type="submit" style="display:none;">
			</form>
		</div>
		<div class="signup">
			<a href="#">注册</a>
		</div>
	</div>
</body>
<script>
	function login(){
		$("#loginsubmit").click();
	}
</script>
</html>
