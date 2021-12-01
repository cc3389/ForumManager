<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>论坛注册</title>
</head>
<body>
	<form method="post"action="/ForumManager/RegisterServlet">
		昵称：<input name="uname" type="text"><br/>
		密码：<input name="upwd"type="password"><br/>
		确认密码：<input type="password"><br/>
		邮箱：<input type="email" name = "email"><br/>
		性别：
		男<input type="radio" name="sex" value="男">
		女<input type="radio" name="sex" value="女">
		非二元性别<input type="radio" name="sex" value="未知"><br/>
		<input type = "submit"value="注册">
	</form>
	<a href = "../index.jsp">注册</a>
</body>
</html>