<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>企业列表</title>

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
					<form >
						<div class="modal-body">
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">姓　　名：</span>
							  <input type="text" class="form-control" disabled id="username">
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">性　　别：</span>
							  <input class="form-control" type="text" disabled id="gender"></input>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">年　　龄：</span>
							  <input class="form-control" type="number" disabled id="age"></input>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">地　　址：</span>
							  <textarea class="form-control" disabled id="address"></textarea>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">身份证号：</span>
							  <input class="form-control" type="number" disabled id="idcardnumber"></input>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">手机号码：</span>
							  <input class="form-control" type="number" disabled id="phonenumber"></textarea>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">特　　长：</span>
							  <textarea class="form-control" disabled id="specialskill"></textarea>
							</div>
							<div class="input-group input-group-lg">
							  <span class="input-group-addon" style="margin-top: 10px;">注册时间：</span>
							  <input class="form-control" disabled type="text" id="registertime">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		  </div>
  
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">志愿者报名系统(${sessionScope.manager.username })</a>
      
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
	        <c:forEach items="${list }" var="v">
	        	<div class="media text-muted pt-3">
		          <img src="${pageContext.request.contextPath }/img/4.jpg" width="32" height="32" alt="" class="mr-2 rounded">
		          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
	            	<span class="d-block"><a href="#" onclick="showvolunteer('${v.username}','${v.gender }','${v.age }','${v.address }','${v.idcardnumber }','${v.phonenumber }','${v.specialskill }','${v.registertime }')" data-toggle="modal" data-target="#myModal">志愿者：${v.username}</a></span>
	            	<span class="d-block">性别：${v.gender }</span>
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
    <script>
	   function showvolunteer(username,gender,age,address,idcardnumber,phonenumber,specialskill,registertime){
		   console.log(username);
		   console.log(gender);
		   console.log(age);
		   console.log(address);
		   console.log(idcardnumber);
		   console.log(phonenumber);
		   console.log(specialskill);
		   console.log(registertime);
		   $("#username").val(username);
		   $("#gender").val(gender);
		   $("#age").val(age);
		   $("#address").val(address);
		   $("#idcardnumber").val(idcardnumber);
		   $("#phonenumber").val(phonenumber);
		   $("#specialskill").val(specialskill);
		   $("#registertime").val(registertime);
	   }
   </script>
  </body>
</html>
