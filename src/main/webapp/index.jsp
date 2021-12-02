<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XXX论坛</title>
</head>
<body>
<%
	String username = (String)request.getAttribute("username");
	if (username==null) {
		username = "None";
	}
%>
<%//利用Cookie自动登录
Cookie[] cookies = request.getCookies();
String password = null;
for(Cookie cookie : cookies) {
	if (cookie.getName().equals("username")) {
		username = cookie.getValue();
	} else if (cookie.getName().equals("password")) {
		password = cookie.getValue();
	}
}
//与数据库中的比对，成功即可登录
%>
欢迎您!<%=username%>
<!-- 首先得到用户名，然后得到板块名，根据板块名可以进入相应的板块区 -->
<%
	List<String> block = (List<String>)session.getAttribute("blocks");
	if (block != null) {
		for (int i = 0; i < block.size(); ++i) {
%>
<a href="/ForumManager/queryBlockServelt" name=<%=block.get(i)%> ><%=block.get(i)%></a>
<% 
			//String str = "<a href=\"queryBlockServelt.java\"name="+block.get(i)+">"+block.get(i)+"</a>";
			//out.print(str);
		}
	} 
%>
</body>
</html>
