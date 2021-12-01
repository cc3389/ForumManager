<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<form method="post" action="/ForumManager/LogInServlet">
	用户名:<input type="text"name="uname"/><br/>
	密码:<input type="password"name="upwd"/><br/>
	<input type="submit" value="登录">
	</form>
</body>
</html>