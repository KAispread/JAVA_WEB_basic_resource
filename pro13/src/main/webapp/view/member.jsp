<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="sec01.ex01.*"
    import="java.util.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="bean" class="sec01.ex01.MemberBean" scope="page"/>
<jsp:useBean id="dao" class="sec01.ex01.MemberDAO" scope="page"/>
<jsp:setProperty name="bean" property="*"/>
<%
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
					<jsp:getProperty name="bean" property="id" />
				</td>
				<td>
					<jsp:getProperty name="bean" property="pwd" />
				</td>
				<td>
					<jsp:getProperty name="bean" property="name" />
				</td>
				<td>
					<jsp:getProperty name="bean" property="email" />
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