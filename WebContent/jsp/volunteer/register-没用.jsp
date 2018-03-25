<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>用户注册</title>
    <link href="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
    
  </head>
  <body class="text-center">
    <form class="form-signin" action="${pageContext.request.contextPath }/volunteer/VolunteerServlet?method=register" method="POST">
      <img class="mb-4" src="${pageContext.request.contextPath }/img/2.png" alt="" width="72" height="72">
 	  <h1 class="jumbotron-heading">志愿者管理系统</h1>
 	  <h1 class="jumbotron-heading">用户注册</h1>
      <label for="inputEmail" class="sr-only">用户名</label>
      <input type="text" id="inputEmail" class="form-control" placeholder="用户名(15字以内)" required autofocus name="username">
      <label for="inputPassword" class="sr-only">密码</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="密码" required name="password">
      <label for="inputPassword2" class="sr-only">确认密码</label>
      <input type="password" id="inputPassword2" class="form-control" placeholder="密码2" required name="password2">
      
      <label for="age" class="sr-only">年龄</label>
      <input type="number" id="age" class="form-control" placeholder="年龄" required autofocus name="age">
      <label for="gender" class="sr-only">性别</label>
      <select name="gender" class="form-control" required autofocus>
      	<option value="男">男</option>
      	<option value="女">女</option>
      </select>
      
      
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
  <script>
  	$(function(){
  	});
  </script>
</html>