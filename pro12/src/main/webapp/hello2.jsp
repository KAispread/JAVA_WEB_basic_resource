<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- scriptlet 선언문 -->
<%!
	String name = "Kai";
	public String getName() { return name;}
%>
<% String age=request.getParameter("age"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello <%=name %>!!! your age is <%=age %>.</h1>
</body>
</html>