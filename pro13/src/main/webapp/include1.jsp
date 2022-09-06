<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 요청 페이지 1</title>
</head>
<body>
	안녕하세요 쇼핑몰 JSP 입니다!! <br>
	<jsp:include page="git_image.jsp" flush=ture>
		<jsp:param name="name" value="GIT" />
		<jsp:param name="imgName" value="git.png" />
	</jsp:include>
	안녕하세요 쇼핑몰 JSP 끝 부분입니다. 
</body>
</html>