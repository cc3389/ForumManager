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
%>
<title><%=blockName%>区</title>
</head>
<body>
<%
	if (isGetPost != null) {
		if (isGetPost) {
			posts = (List<Post>)request.getAttribute("posts");
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
				<a href="Profile/index.jsp?writer=<%=posts.get(i).getWriter()%>"><%=posts.get(i).getWriter()%></a>
			</td>
			<td>
				<%=posts.get(i).getPublishTime()%>
			</td>
		</tr>
<%		
		}
		out.print("</table>");
	} else {
		request.getRequestDispatcher("/PostsServlet").forward(request, response);	
	}
%>
</body>
</html>