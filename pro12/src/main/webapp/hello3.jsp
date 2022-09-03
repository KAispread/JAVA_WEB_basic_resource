<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	String name = "Kai";
	public String getName(){return name;}
%>
<% String age=request.getParameter("age"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식 연습</title>
</head>
<body>
	<h1>Hello <%=name %>!!</h1><br>
	<h1>Your age is <%=age %>!!</h1><br>
	<h1>Your are <%=180 %> centimeters tall!!</h1><br>
	<h1>Plus 10 of your age is <%=Integer.parseInt(age)+10 %>!!</h1><br>
</body>
</html>