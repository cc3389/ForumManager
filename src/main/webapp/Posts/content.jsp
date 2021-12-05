<%@page import="entirety.Permission"%>
<%@page import="entirety.User"%>
<%@page import="java.util.List"%>
<%@page import="entirety.Review"%>
<%@page import="entirety.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%//判断登录状态
User user= (User)request.getSession().getAttribute("user");
	if (user == null) {//没登陆
		System.out.println("正在尝试用cookie登录");
		request.getRequestDispatcher("/GetCookieServlet").forward(request, response);
		return;
	}
	String username = user.getUserName();
	String identifyName = (String)session.getAttribute("identifyName");
	Permission permission = (Permission)session.getAttribute("permission");
%>
<%
	Post post = (Post)request.getAttribute("post");
	String writerID = (String)request.getAttribute("writerID");
	List<Review> reviews = (List<Review>)request.getAttribute("reviews");
	List<String> reviewers = (List<String>)request.getAttribute("reviewers");
	if (post == null) {
		System.out.println("请求转发寻找帖子内容...");
		request.getRequestDispatcher("/BrowseServlet").forward(request, response);
		return;
	} else {
		System.out.println("帖子信息找到了...");
%>

<title><%=post.getTitle()%></title>
</head>
<body>
	<table>
		<tr>
			<td>用户</td>
			<td>内容</td>
			<td>评论时间</td>
		</tr>
		<tr>
			<td><a href="/ForumManager/Profile/index.jsp?id="+<%=writerID%>><%=post.getWriter()%></a></td>
			<td><%=post.getPostContent() %></td>
			<td><%=post.getPublishTime()%></td>
		</tr>
	
<%
	for (int i = 0; i < reviews.size(); ++i) {
%>
		<tr>
			<td><a href="/ForumManager/Profile/index.jsp?id="+<%=reviews.get(i).getReviewID()%>><%=reviewers.get(i)%></a></td>
			<td><%=reviews.get(i).getContent()%></td>
			<td><%=reviews.get(i).getReviewTime()%></td>
<%			if (permission.isAllowSetPost()) {
%>
			<td>
				<a href="../DeleteServlet?id=<%=reviews.get(i).getReviewID()%>&type=review"style="color:red;" >删除</a>
			</td>
<%	
}
%>
		</tr>
<%
	}
%>
<%
	}
%>
	</table>
	<form method="post" action="/ForumManager/ReviewServlet">
		<textarea placeholder="在这里输入评论"name="content"></textarea>
		<%
			//request.setAttribute("postID", post.getPostID());
			System.out.println(post.getPostID());
		%>		
		<button type="submit" name ="postID"value=<%=post.getPostID()%>>发表评论</button>
	</form>	
</body>
</html>