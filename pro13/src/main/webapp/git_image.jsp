<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = (String) request.getParameter("name");
	String imgSrc = (String) request.getParameter("imgName");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 페이지</title>
</head>
<body>
	<br>
	<h1>이름은 <%=name %> 입니다.</h1>
	<img src="/image/<%=imgSrc %>" />
</body>
</html>