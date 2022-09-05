<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색창</title>
</head>
<body>
	<form name="frmSearch" action="member.jsp" method="get">
		<h1>찾고자하는 회원 이름을 입력하세요</h1><br>
		<input type="text" name="user_name">
		<input type="submit" value="확인">
	</form>
</body>
</html>