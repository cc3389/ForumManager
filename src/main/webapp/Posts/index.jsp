<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entirety.Permission"%>
<%@page import="entirety.Identify"%>
<%@page import="entirety.User"%>
<%@page import="entirety.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 板块名 -->
<%
	List<Post> posts = null;
	String blockID = request.getParameter("id");
	String blockName = request.getParameter("type");
	request.setAttribute("blockID",blockID);	
	
	Boolean isGetPost = (Boolean)request.getAttribute("isGetPost");
	List<String> userIDs = null;
%>
<title><%=blockName%>区</title>
</head>
<body>
<%//判断登录状态
User user= (User)request.getSession().getAttribute("user");
	if (user == null) {//没登陆
		System.out.println("正在尝试用cookie登录");
		request.getRequestDispatcher("/GetCookieServlet").forward(request, response);
		return;
	}
	Permission permission = (Permission)session.getAttribute("permission");
	String username = user.getUserName();
	String identifyName = (String)session.getAttribute("identifyName");
	SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
%>
欢迎您,<%=identifyName%> <%=username%>!<br/>
<a href = "/ForumManager/LogoutServlet">登出</a>
<%
	if (isGetPost != null) {
		if (isGetPost) {
			posts = (List<Post>)request.getAttribute("posts");	
			userIDs = (List<String>)request.getAttribute("userids");
		} else if (!isGetPost) {
			System.out.println("getPostFail");
		}
%>	
		<table>
			<tr>
				<td>标题</td>
				<td>作者</td>
				<td>发表时间</td>
			</tr>
<%
		for (int i = 0; i < posts.size(); ++i) {			
%>		
		<tr>
			<td>
				<a href="content.jsp?id=<%=posts.get(i).getPostID()%>"><%=posts.get(i).getTitle()%></a>
			</td>
			<td>
				<a href="/ForumManager/Profile/index.jsp?id=<%=userIDs.get(i)%>"><%=posts.get(i).getWriter()%></a>
			</td>
			<td>
				<%=ft.format(posts.get(i).getPublishTime())%>
			</td>			
<%
			if (permission.isAllowSetPost()) {
%>
			<td>
				<a href="../DeleteServlet?id=<%=posts.get(i).getPostID()%>&type=post"style="color:red;" >删除</a>
			</td>
<%
			}			
%>			
		</tr>
<%		
		}
		out.print("</table>");
	} else {
		request.getRequestDispatcher("/PostsServlet").forward(request, response);
		return;
	}
%>
<form method="post" action="/ForumManager/AddPostServlet">
	<input name="title" placeholder="请输入标题"></br>
	<textarea name="content" placeholder="请输入帖子内容"></textarea></br>
	<button type="submit" name="blockID" value=<%=blockID%>>发布帖子</button>
</form>
</body>
</html>