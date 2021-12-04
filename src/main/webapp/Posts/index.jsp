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
	request.setAttribute("blockID",blockID);
	Boolean isGetPost = (Boolean)request.getAttribute("isGetPost");
%>
<title><%="板块名"%></title>
</head>
<body>
<%
	if (isGetPost != null) {
		if (isGetPost) {
			posts = (List<Post>)request.getAttribute("posts");
		} else if (!isGetPost) {
			System.out.println("getPostFail");
		}
		out.print("<table>");
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