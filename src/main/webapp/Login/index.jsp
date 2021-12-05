<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<%
	String fail = (String)request.getAttribute("loginFail");
	if (fail != null && fail != "") {
		if (fail == "Fail") {
%>
<script>
	alert("登录失败，请重新登录");
</script>
<%
		}
	}
%>
	<form method="post" action="/ForumManager/LogInServlet">
	用户名:<input type="text"name="uname"/><br/>
	密码:<input type="password"name="upwd"/><br/>
	<input type="submit" value="登录">
	</form>
	<a href="/ForumManager/Register/index.jsp">注册</a>
</body>
</html>