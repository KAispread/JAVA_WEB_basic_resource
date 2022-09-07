<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="sec01.ex01.*"
    import="java.util.*"
    pageEncoding="UTF-8"%>

<%
	String id = (String) request.getParameter("id");
	String pwd = (String) request.getParameter("pwd");
	String name = (String) request.getParameter("name");
	String email = (String) request.getParameter("email");
	MemberBean bean = new MemberBean(id, pwd, name, email);
	MemberDAO dao = new MemberDAO();
	dao.addMember(bean);
	List<MemberBean> memberList = dao.getListMembers();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
	<table align="center" width="70%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="5%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>
		<%
			if (memberList.size() == 0) {
		%>
		<tr>
			<td colspan="5">
				<p align="center"><b><span style="font-size:9pt;">
			</td>	
		</tr>
		<%
			} else {
				for (MemberBean mem: memberList) {
					
		%>
			<tr align="center">
				<td>
					<%=mem.getId() %>
				</td>
				<td>
					<%=mem.getPwd() %>
				</td>
				<td>
					<%=mem.getName() %>
				</td>
				<td>
					<%=mem.getEmail() %>
				</td>
				<td>
					<%=mem.getJoinDate() %>
				</td>
			</tr>
		<%
				}
			}
		%>
			<tr height="1" bgcolor="#99ccff">
				<td colspan="5"></td>
			</tr>
	</table>
</body>
</html>