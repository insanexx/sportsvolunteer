<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>首页</title>

    <link href="${pageContext.request.contextPath }/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/jumbotron.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/offcanvas.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.1.0.min.js"></script>
   <script src="${pageContext.request.contextPath }/bootstrap-3.3.7/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
    <style type="text/css">
    	body{
    		/* background: url(../img/bg.jpg) repeat center 0px; */
    		 background: url(../img/login.png) repeat center 0px; 
    	}
	    .input-group-lg>.form-control {
	   		font-size: 1rem;
	    }
	    .input-group-lg{
	   		padding-bottom: 2px;
	    }
    </style>
    <script type="text/javascript">
    	var msg = "${message}";
    	if(msg){
    		alert(msg);
    	}
    	function sure(){
    		return confirm("确定删除吗？");
    	}
    	$(function(){
            // 初始化轮播
            $(".start-slide").click(function(){
                $("#myCarousel").carousel('cycle');
            });
            // 停止轮播
            $(".pause-slide").click(function(){
                $("#myCarousel").carousel('pause');
            });
            // 循环轮播到上一个项目
            $(".prev-slide").click(function(){
                $("#myCarousel").carousel('prev');
            });
            // 循环轮播到下一个项目
            $(".next-slide").click(function(){
                $("#myCarousel").carousel('next');
            });
            // 循环轮播到某个特定的帧 
            $(".slide-one").click(function(){
                $("#myCarousel").carousel(0);
            });
            $(".slide-two").click(function(){
                $("#myCarousel").carousel(1);
            });
            $(".slide-three").click(function(){
                $("#myCarousel").carousel(2);
            });
            $('.carousel').carousel();
        });
    </script>
  </head>

  <body class="bg-light">
  
  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">志愿者信息系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath }/jsp/volunteer/login.jsp">志愿者登录</a></li>
            <li><a href="${pageContext.request.contextPath }/jsp/enterprise/login.jsp">企业登录</a></li>
            <li><a href="${pageContext.request.contextPath }/jsp/manager/login.jsp">管理员登录</a></li>
          </ul>
          
        </div>
      </div>
    </nav>
  
    <main role="main">
      <div class="container">
      	
      	<div id="myCarousel" class="carousel slide" style="width:76%;margin-left:auto;margin-right:auto;margin-top:40px;">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>   
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="${pageContext.request.contextPath }/img/a.jpg">
				</div>
				<div class="item">
					<img src="${pageContext.request.contextPath }/img/b.jpg">
				</div>
				<div class="item">
					<img src="${pageContext.request.contextPath }/img/c.jpg">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div> 
		  
      </div>
    </main>

   
  </body>
</html>
