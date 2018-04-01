<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>志愿者注册</title>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
    
</head>
<body>
	 <label id="msg" style="display:none">${requestScope.message }</label>
	 <form class="form-horizontal" style="padding: 30px 100px 10px;" action="${pageContext.request.contextPath }/volunteer/VolunteerServlet?method=register" method="POST">
      <img class="mb-4" src="${pageContext.request.contextPath }/img/2.png" alt="" width="72" height="72">
      &nbsp;&nbsp;&nbsp;
 	  <span style="font-size:30px;" class="jumbotron-heading">志愿者管理系统-用户注册</span>

		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">用户名：</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="username" name="username" value="${v.username }" maxlength=15 placeholder="用户名(15字以内)" required autofocus>
			</div>
		</div>

		<div class="form-group">
			<label for="phonenumber" class="col-sm-2 control-label">手机号码：</label>
			<div class="col-sm-4">
				<input type="number" class="form-control" id="phonenumber" value="${v.phonenumber }" name="phonenumber" maxlength=20 placeholder="手机号" required autofocus>
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">密码：</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="password" name="password" placeholder="密码" required autofocus>
			</div>
		</div>

		<div class="form-group">
			<label for="password2" class="col-sm-2 control-label">再输一次：</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="password2" name="password2" placeholder="确认密码" required autofocus>
			</div>
		</div>

		<div class="form-group">
			<label for="address" class="col-sm-2 control-label">地址：</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="address"  name="address" value="${v.address }" placeholder="地址（100字以内）" maxlength=100 required autofocus>
			</div>
		</div>


		<div class="form-group">
			<label for="gender" class="col-sm-2 control-label">性别：</label>
			<div class="col-sm-4">
				&nbsp; &nbsp;<input type="radio" name="gender" id="gender_m" value="男" checked="checked"> 
				&nbsp;男 &nbsp; &nbsp; &nbsp; &nbsp;
				&nbsp; &nbsp;<input type="radio" name="gender" id="gender_w" value="女">
				&nbsp;女
			</div>
		</div>

		<div class="form-group">
			<label for="age" class="col-sm-2 control-label">年龄：</label>
			<div class="col-sm-4">
				<input type="number" class="form-control" id="age" name="age" value="${v.age }" maxlength=3 placeholder="年龄" autofocus>
			</div>
		</div>

		<div class="form-group">
			<label for="idcardnumber" class="col-sm-2 control-label">身份证号：</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="idcardnumber" name="idcardnumber" value="${v.idcardnumber }" maxlength=20 placeholder="身份证号" required autofocus>
			</div>
		</div>
		

		<div class="form-group">
			<label for="specialskill" class="col-sm-2 control-label">特长：</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="specialskill" name="specialskill" placeholder="特长（100字以内）" maxlength=100  value="${v.specialskill }" autofocus>
			</div>
		</div>

	<!-- 	<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
				<div class="checkbox">
					<label><input type="checkbox" required>我已阅读并接受</label> 
					<a href="#" style="text-decoration: underline;" target="_blank">注册条款</a>
				</div>
			</div>
		</div> -->
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-3">
				<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		$(function(){
			var msg = $("#msg");
		  	if(msg.text()){
		  		alert(msg.text());
		  	}
		});
	</script>
</body>
</html>