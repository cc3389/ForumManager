<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册成功！</title>
</head>
<body>
注册成功！<br/>
现在您将在3秒钟后跳转到登录界面...<br/>
如果未能跳转，请点击<a href = "../Login/index.jsp">连接</a>手动跳转

<% response.setHeader("refresh", "3;URL=../Login/index.jsp"); %>
</body>
</html>