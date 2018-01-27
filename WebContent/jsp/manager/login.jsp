<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manager login</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/manager/ManagerServlet?method=login" method="POST">
		用户名：<input type="text" name="username"><br/>
		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br/>
		<input type="submit"><br/>
		<font color="red" size="30px">${requestScope.message }</font>
		
	</form>
</body>
</html>