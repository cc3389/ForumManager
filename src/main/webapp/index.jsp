<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主要页面</title>
</head>
<body>
<%
	String username = (String)request.getAttribute("username");
	if (username==null) {
		username = "None";
	}
%>
欢迎您!<%=username%>
<!-- 首先得到用户名，然后得到板块名，根据板块名可以进入相应的板块区 -->
<%
	List<String> block = null;
	block = (List<String>)request.getAttribute("blocks");
	if (block!=null) {
		for (int i = 0; i < block.size(); ++i) {
			String str = "<a href=\"queryBlockServelt.java\"name="+block.get(i)+">"+block.get(i)+"</a>";
			out.print(str);
		}
	}
%>
</body>
</html>
