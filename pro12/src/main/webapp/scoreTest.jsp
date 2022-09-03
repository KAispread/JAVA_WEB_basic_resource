<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int score = Integer.parseInt(request.getParameter("score"));
	char grade = 0;
%>
<%
if (score >= 90) {
	grade = 'A';
} else if (score < 90 && score >= 80){
	grade = 'B';
} else if (score < 80 && score >= 70){
	grade = 'C';
} else if (score < 70 && score >= 60){
	grade = 'D';
} else {
	grade = 'F';
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험점수</title>
</head>
<body>
	<h1>당신의 시험 점수는 <%=score %> 입니다.</h1>
	<h1>학점은 <%=grade %> 입니다.</h1>
	<a href='/pro12/scoreTest.html'>시험 점수 입력</a>
</body>
</html>