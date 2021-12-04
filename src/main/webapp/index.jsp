<%@page import="java.util.Date"%>
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
User user= (User)request.getSession().getAttribute("user");
	if (user == null) {//没登陆
		System.out.println("正在尝试用cookie登录");
		request.getRequestDispatcher("GetCookieServlet").forward(request, response);
		return;
	}
	String username = user.getUserName();
	String identifyName = (String)session.getAttribute("identifyName");
%>
欢迎您,<%=identifyName%> <%=username%>!<br/>
<a href = "/ForumManager/LogoutServlet">登出</a>

<!-- 首先得到用户名，然后得到板块名，根据板块名可以进入相应的板块区 -->
<%
	out.print("论坛板块如下：<br/>");
	//System.out.println("用户权限如下\n"+permission+"\n以上");
	List<Block> blocks = (List<Block>)session.getAttribute("blocks");
	if (blocks != null) {
		for (int i = 0; i < blocks.size(); ++i) {		
			System.out.println("vlaue:"+blocks.get(i).getBlockID());
%>
<a href="Posts/index.jsp?id=<%=blocks.get(i).getBlockID()%>&type=<%=blocks.get(i).getType()%>"><%=blocks.get(i).getType()%></a><br/>
<% 
		}
	} else {
		System.out.println("正在获取板块");
		request.getRequestDispatcher("QueryBlockServlet").forward(request, response);//获取板块列表		
	}
%>
</body>
</html>
