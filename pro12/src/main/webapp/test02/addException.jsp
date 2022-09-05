<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>
	============ toString() 내용 ============ <br>
	<h1><%=exception.toString() %></h1>
	============ getMessage() 내용 ============ <br>
	<h1><%=exception.getMessage() %></h1>
	============ printStackTrace() 내용 ============ <br>
	<h1><% exception.printStackTrace(); %></h1> <br>
	<h2>
		숫자만 입력 가능합니다. 다시 시도하세요 <br>
		<a href="add.jsp">다시하기</a>
	</h2>
</body>
</html>