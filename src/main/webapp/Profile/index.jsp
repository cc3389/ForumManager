<%@page import="entirety.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人主页</title>
</head>
<body>
<%//判断登录状态
User user= (User)request.getSession().getAttribute("user");
	if (user == null) {//没登陆
		System.out.println("正在尝试用cookie登录");
		request.getRequestDispatcher("/GetCookieServlet").forward(request, response);
		return;
	}
	String username = user.getUserName();
	String identifyName = (String)session.getAttribute("identifyName");
%>

<%	
	User currentUser = (User)request.getAttribute("cuser");
	String identify = (String)request.getAttribute("identify");
	Boolean isGetUser = (Boolean)request.getAttribute("getUserFail");
	if (isGetUser != null) {
		if (isGetUser == true) {
			out.println("未找到该用户");
		}
	}
	if (currentUser == null && identify == null) {
		System.out.println("获取失败，请求转发。。。");
		request.getRequestDispatcher("/UserInfoServlet").forward(request, response);
		return;
	} else {
		System.out.println("index forfile");
		System.out.println("currentUser:"+currentUser);
		System.out.println("identify:"+ identify);
%>
	<table>
	<tr>
	<td>用户名</td>
	<td><%=currentUser.getUserName() %></td>
	</tr>
	<tr>
	<td>性别</td>
	<td><%=currentUser.getSex() %></td>
	</tr>
	<tr>
	<td>身份</td>
	<td><%=identify%></td>
	</tr>
	<tr>
	<td>注册时间</td>
	<td><%=currentUser.getRegisterDate() %></td>
	</tr>
	<tr>
	<td>邮箱</td>
	<td><%=currentUser.getMail() %></td>
	</tr>
	</table>
<%
	}
%>
</body>
</html>