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
    	var msg = "${message}";
    	if(msg){
    		alert(msg);
    	}
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
							志愿者信息
						</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
					</div>
					<form method="post" action="${pageContext.request.contextPath }/volunteer/VolunteerServlet?method=updatevolunteer">
						<input type="hidden" id="id" name="id" value="${volunteer.id }">
						<div class="modal-body">
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">姓　　名：</span>
							  <input type="text" class="form-control" id="username" name="username" value="${volunteer.username }">
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">性　　别：</span>
							  <input class="form-control" type="text" id="gender" name="gender" value="${volunteer.gender }"></input>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">年　　龄：</span>
							  <input class="form-control" type="number" id="age" name="age" value="${volunteer.age }"></input>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">地　　址：</span>
							  <textarea class="form-control" id="address" name="address">${volunteer.address }</textarea>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">身份证号：</span>
							  <input class="form-control" type="number" id="idcardnumber" name="idcardnumber" value="${volunteer.idcardnumber }"></input>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">手机号码：</span>
							  <input class="form-control" type="number" id="phonenumber" name="phonenumber" value="${volunteer.phonenumber }"></input>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">特　　长：</span>
							  <textarea class="form-control" id="specialskill" name="specialskill" >${volunteer.specialskill }</textarea>
							</div>
							
						</div>
						<div class="modal-footer">
							<button  class="btn btn-primary" type="submit">确定</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		  </div>

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">志愿者信息系统(${sessionScope.volunteer.username })</a>
      
      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <button class="btn btn-outline-success my-2 my-sm-0" onclick="showvolunteermessage('${v.username}','${v.gender }','${v.age }','${v.address }','${v.idcardnumber }','${v.phonenumber }','${v.specialskill }','${v.registertime }')" data-toggle="modal" data-target="#myModal">个人信息</button>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath }/volunteer/VolunteerServlet?method=logout" method="POST">
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
	        <c:forEach items="${gameList }" var="game">
		       <div class="media text-muted pt-3">
		          <img src="${pageContext.request.contextPath }/img/3.png" alt="" class="mr-2 rounded">
		          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
		            <div class="d-flex justify-content-between align-items-center w-100">
		              <strong class="text-gray-dark">标题：${game.name }</strong>
		              <c:if test="${!game.entered }">
			          	<a href="${pageContext.request.contextPath }/volunteer/VolunteerServlet?method=entergame&id=${game.id}">报名</a>
		              </c:if>
		              <c:if test="${game.entered }">
		             	<a href="#">已报名</a>
		              </c:if>
		            </div>
		            	<span class="d-block">公司：${game.enterprisename }</span>
		            	<span class="d-block">赛事描述：${game.description }</span>
		            	<span class="d-block">工作描述：${game.jobdescription }</span>
		            	<span class="d-block">工作地点：${game.address }</span>
		            	<span class="d-block">工资（元）：${game.salary }</span>
		            	<span class="d-block">招募人数：${game.personcount }(剩余名额:${game.restcount })</span>
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

   <script src="${pageContext.request.contextPath }/jquery-3.1.0/jquery-3.2.1.slim.min.js"></script>
   <script src="${pageContext.request.contextPath }/bootstrap-4.0.0-dist/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
  </body>
</html>
