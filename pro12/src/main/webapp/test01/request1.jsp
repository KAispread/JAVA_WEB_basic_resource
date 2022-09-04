<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("name", "기웅");
	request.setAttribute("address", "경기 부천");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 내장 객체</title>
</head>
<body>

<%
	RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
	dispatch.forward(request, response);
%>
</body>
</html>