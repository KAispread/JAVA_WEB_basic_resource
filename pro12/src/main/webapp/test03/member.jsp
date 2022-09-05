<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="sec02.ex01.*"
    import="java.util.*"
    pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>
<head>
	<style>
		h1 {
			text-align: center;
		}
	</style>
	<meta charset="UTF-8">
	<title>회원 정보 출력</title>
</head>
<body>
	<h1>회원 정보 출력</h1><br>
	<%
		String name=(String) request.getParameter("user_name");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMembers(name);
		
		if (! list.get(0).getName().equals(name)) {
	%>	
			<h1>해당 회원을 찾을 수 없습니다.</h1><br>
			<h1>전체 회원 목록</h1><br>
	<% 
		} else {
	%>
			<h1><%=name %>님의 정보입니다.</h1>
	<% 
		}
	%>
	<table border=1 width=800 align=center>
		<tr align=center bgcolor="#FFFF66">
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>가입일자</td>
		</tr>	
		<%
			for (MemberVO memberVO : list) {
				String id = memberVO.getId();
				String pw = memberVO.getPwd();
				String memName = memberVO.getName();
				String email = memberVO.getEmail();
				Date joinDate = memberVO.getJoinDate();
		%>
			<tr align=center>
				<td><%=id %></td>
				<td><%=pw %></td>
				<td><%=memName %></td>
				<td><%=email %></td>
				<td><%=joinDate %></td>
			</tr>
		<%
			}
		%>
	</table>
	
</body>
</html>