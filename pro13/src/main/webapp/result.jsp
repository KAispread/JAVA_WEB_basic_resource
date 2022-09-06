<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String) request.getParameter("userID");
		if (id.length() == 0) {
	%>
		<jsp:forward page="login.jsp">
			<jsp:param value="true" name="msg"/>
		</jsp:forward>
	<%
		}
	%>
	<h1>안녕하세요 <%=id %> 님 !!!</h1>
</body>
</html>