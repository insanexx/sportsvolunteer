<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>首页</title>

    <link href="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/jumbotron.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/offcanvas.css" rel="stylesheet">
    <style type="text/css">
	    .input-group-lg>.form-control {
	   		font-size: 1rem;
	    }
	    .input-group-lg{
	   		padding-bottom: 2px;
	    }
    </style>
    <script type="text/javascript">
    	function sure(){
    		return confirm("确定删除吗？");
    	}
    </script>
  </head>

  <body class="bg-light">
  
  
  		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="max-width: 600px">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">
							发布新赛事
						</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
					</div>
					<form action="${pageContext.request.contextPath }/GameServlet?method=addgame" method="POST">
						<div class="modal-body">
								<div class="input-group input-group-lg">
								  <span class="input-group-addon" style="margin-top: 10px;">赛事名称：</span>
								  <input type="text" class="form-control" placeholder="赛事名称" name="name" required="required">
								</div>
								<div class="input-group input-group-lg">
								  <span class="input-group-addon" style="margin-top: 10px;">赛事描述：</span>
								  <textarea class="form-control" placeholder="赛事描述" name="description" required="required"></textarea>
								</div>
								<div class="input-group input-group-lg">
								  <span class="input-group-addon" style="margin-top: 10px;">工作描述：</span>
								  <textarea class="form-control" placeholder="工作描述" name="jobdescription" required="required"></textarea>
								</div>
								<div class="input-group input-group-lg">
								  <span class="input-group-addon" style="margin-top: 10px;">开始时间：</span>
								  <input class="form-control" type="date" name="begintime" required="required">
								  <span class="input-group-addon" style="margin-top: 10px;">结束时间：</span>
								  <input class="form-control" type="date" name="endtime" required="required">
								</div>
								<div class="input-group input-group-lg">
								  <span class="input-group-addon" style="margin-top: 10px;">赛事地点：</span>
								  <input type="text" class="form-control" placeholder="赛事地点" name="address" required="required">
								</div>
								<div class="input-group input-group-lg">
								  <span class="input-group-addon" style="margin-top: 10px;">
								 <!--  工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资： -->
								 工资（元）
								  </span>
								  <input type="number" class="form-control" placeholder="工资" name="salary" required="required">
								</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭
							</button>
							<input type="submit" class="btn btn-primary" value="发布"></input>
						</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		  </div>

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">志愿者管理系统(${sessionScope.manager.username })</a>
      
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath }/manager/ManagerServlet?method=logout" method="POST">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">注销</button>
        </form>
      </div>
    </nav>

    <main role="main">

      <div class="container">
      
		  <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded box-shadow">
	        <img class="mr-3" src="${pageContext.request.contextPath }/img/2.png" alt="" width="48" height="48">
	        <div class="lh-100">
	          <h6 class="mb-0 text-white lh-100">SportsVolunteer</h6>
	        </div>
      	  </div>
	      <div class="my-3 p-3 bg-white rounded box-shadow">
	        <a class="btn btn-outline-success my-2 my-sm-0" href="#" data-toggle="modal" data-target="#myModal">添加 <span class="sr-only">(current)</span></a>
	        <c:forEach items="${gameList }" var="game">
		       <div class="media text-muted pt-3">
		          <img src="${pageContext.request.contextPath }/img/3.png" alt="" class="mr-2 rounded">
		          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
		            <div class="d-flex justify-content-between align-items-center w-100">
		              <strong class="text-gray-dark">标题：${game.name }</strong>
		              <a onclick="return sure()" href="${pageContext.request.contextPath }/GameServlet?method=deletegame&id=${game.id}">删除</a>
		            </div>
		            	<span class="d-block">赛事描述：${game.description }</span>
		            	<span class="d-block">工作描述：${game.jobdescription }</span>
		            	<span class="d-block">工作地点：${game.address }</span>
		            <span>
		            	<fmt:formatDate value="${game.begintime }" pattern="yyyy-MM-dd"/>
		            	--&gt;<fmt:formatDate value="${game.endtime }" pattern="yyyy-MM-dd"/>
		            </span>
		          </div>
		        </div>
	        </c:forEach>
	      </div>
      </div>
    </main>

    <footer class="container">
      <p>&copy; Company 2017-2018</p>
    </footer>

   <script src="/SportsVolunteer/jquery-3.1.0/jquery-3.2.1.slim.min.js"></script>
   <script src="/SportsVolunteer/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
   <script src="/SportsVolunteer/js/popper.min.js"></script>
  </body>
</html>
