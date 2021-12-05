<%@page import="entirety.Block"%>
<%@page import="java.util.List"%>
<%@page import="entirety.Permission"%>
<%@page import="entirety.Identify"%>
<%@page import="entirety.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>论坛后台管理系统</title>
</head>
<body>
<%//判断登录状态
	User user= (User)request.getSession().getAttribute("user");
	if (user == null) {//没登陆
		System.out.println("正在尝试用cookie登录");
		request.getRequestDispatcher("../GetCookieServlet").forward(request, response);
		return;
	}
	Identify identify = (Identify)session.getAttribute("identify");
	String username = user.getUserName();
	String identifyName = (String)session.getAttribute("identifyName");
	if (identifyName.equals("user")) {
		System.out.println("没有权限");
		response.sendRedirect("Error/403.html");
		return;
	}
	Permission permission = (Permission)session.getAttribute("permission");
	
%>
欢迎您,<%=identifyName%> <%=username%>!<br/>
<a href = "/ForumManager/LogoutServlet">登出</a><br/>
<%
	if (permission.isAllowSentAnnounce()) {
%>		
<label>公告区</label>
	<form action="../AnnServlet?userID=<%=user.getUserID()%>" method="post">
		<input placeholder="公告标题" name="annTitle"><br/>
		<textarea placeholder="公告内容" name="annContent"></textarea><br/>
		<input type="submit" value="发布"><br/>
	</form>
	<a href="../AnnServlet?type=del">删除公告</a><br/>
	<label>板块区</label>
<%
	}
	if (permission.isAllowOperateUser()) {//作为增删板块的权限
		List<Block> blocks = (List<Block>)request.getAttribute("blocks");
		if (blocks == null) {
			request.getRequestDispatcher("../QueryBlockServlet?from=manage").forward(request, response);
			return;
		}
		for (int i = 0; i <blocks.size(); ++i) {
%>
		<table>
			<tr>
				<td>
					<label><%=blocks.get(i).getType()%></label>
				</td>
				<td>
					<a href="../DeleteServlet?id=<%=blocks.get(i).getBlockID()%>&type=block" style="color:red">删除</a>
				</td>
			</tr>		
<%	
		}
%>
		</table>
		<form action="/ForumManager/AddBlockServlet?userID=<%=user.getUserID()%>" method="post">
			<input placeholder="板块名" name="blockName">
			<input type="submit" value="添加板块">
		</form>
<%

	}	
%>
</body>
</html>