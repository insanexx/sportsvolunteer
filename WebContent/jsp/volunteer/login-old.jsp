<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>volunteer login</title>
    <link href="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
  </head>
  <body class="text-center">
  	<label id="msg" style="display:none">${requestScope.message }</label>
    <form class="form-signin" action="${pageContext.request.contextPath }/volunteer/VolunteerServlet?method=login" method="POST">
      <img class="mb-4" src="${pageContext.request.contextPath }/img/2.png" alt="" width="72" height="72">
 	  <h1 class="jumbotron-heading">志愿者报名系统</h1>
 	  <h3>志愿者登录</h3>
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">用户名</label>
      <input type="text" id="inputEmail" class="form-control" placeholder="用户名" value="${v.username }" required autofocus name="username">
      <label for="inputPassword" class="sr-only">密码</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="密码" required name="password">
      <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      <br/>
      <a href="${pageContext.request.contextPath }/jsp/volunteer/register.jsp">立即注册</a>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
  <script>
  	/* var msg = $("#msg");
  	if(msg.text()){
  		alert(msg.text());
  	} */
  </script>
</html>