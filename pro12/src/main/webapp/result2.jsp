<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String user_id=request.getParameter("user_id");
	String user_pw=request.getParameter("user_pw");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 .2</title>
</head>
<body>
	<%
		if(user_id.length() != 0 && user_id != null) {
	%>
		<h1>환영합니다. <%=user_id %> 님!!!</h1>
	<%
		} else {
	%>
		<p>아이디를 입력하세요. <br>
		<a href='/pro12/login.html'>로그인 하러가기</a>
	<%
	 }
	%>
</body>
</html>