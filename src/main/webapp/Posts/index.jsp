<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 板块名 -->
<%
String blockID = request.getParameter("block");
out.print("blockid:"+blockID);
%>
<title><%=blockID%></title>
</head>
<body>

</body>
</html>