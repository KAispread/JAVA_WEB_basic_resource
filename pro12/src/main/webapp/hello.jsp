<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<!-- 선언문 -->
<%! 
	String name = "기우";
	public String getName(){ return name; }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문 연습</title>
</head>
<body>
	<h1>Hello <%=name %>!!!</h1>
</body>
</html>