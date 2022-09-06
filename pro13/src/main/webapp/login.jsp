<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msgFlag = (String) request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (msgFlag != null) {
	%>
		<h1>아이디를 입력하지 않았습니다. 아이디를 입력해주세요.</h1>
	<%
		}
	%>
	<form action="result.jsp" method="post">
		아이디 : <input type="text" name="userID" />
		비밀번호 : <input type="password" name="userPW" />
		<input type="submit" value="로그인">
	</form>
</body>
</html>