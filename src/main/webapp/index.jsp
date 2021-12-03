<%@page import="entirety.Block"%>
<%@page import="entirety.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="entirety.User" %>
<%@ page import="entirety.Permission" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XXX论坛</title>
</head>
<body>
<%//判断登录状态
	User user = null;
	Permission permission = null;
	String identifyName = null;
	String username = null;
	session.setAttribute("Test", 1);
	System.out.println(session.getAttribute("1"));
	String loginStatus = (String)session.getAttribute("loginStatus");
	System.out.println("当前登陆状态："+loginStatus);
	if (loginStatus != null) {
		if (loginStatus.equals("success")) {
		user = (User)session.getAttribute("user");
		identifyName = (String)session.getAttribute("identifyName");
		permission = (Permission)session.getAttribute("permission");
		username = user.getUserName();
		} else if (loginStatus.equals("fail")) {
%>
	<script>
		alert("您还未登录，即将为您转入登录界面...");
		window.location.href="Login/index.jsp";
	</script>
<%
		}
	}else {
%>
	<script>
		window.location.href="/ForumManager/GetCookieServlet";//获取cookie
	</script>
<%	
	}
	
	if (identifyName==null) {
		identifyName = "None";
		username = "None";
}
%>
欢迎您!<%=identifyName%>:<%=username%>
<!-- 首先得到用户名，然后得到板块名，根据板块名可以进入相应的板块区 -->
<%
	List<Block> blocks = (List<Block>)session.getAttribute("blocks");
	if (blocks != null) {
		for (int i = 0; i < blocks.size(); ++i) {		
%>
<a href="/ForumManager/QueryBlockServelt" value=<%=blocks.get(i).getBlockID()%>name= "blcokIndex"><%=blocks.get(i).getType()%></a><br/>
<% 
		}
	} 
%>
</body>
</html>
