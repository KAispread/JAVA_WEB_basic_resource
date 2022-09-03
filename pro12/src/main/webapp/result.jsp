<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 .1</title>
</head>
<body>
	<h1>결과 출력</h1><br>
	<h1>아이디 : <%=request.getParameter("user_id") %></h1><br>
	<h1>비밀번호 : <%=request.getParameter("user_pw") %></h1><br>
</body>
</html>