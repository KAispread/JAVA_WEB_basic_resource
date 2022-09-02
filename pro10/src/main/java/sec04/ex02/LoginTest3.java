package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sec04.ex02.LoginImpl;

@WebServlet("/login")
public class LoginTest3 extends HttpServlet {
	ServletContext context = null;
	List<String> userList = new ArrayList<>(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			userList.add(user_id);
			context.setAttribute("userList", userList);
		}
		
		List<String> list = (ArrayList<String>) context.getAttribute("userList");
		
		out.print("<html>");
		out.print("<head>");
		out.print("<script type='text/javascript'>");
		out.print("setTimeout('history.go(0);', 5000)");
		out.print("</script>");
		out.print("</head>");
		out.print("<body>");
		out.print("접속 아이디 " + loginUser.user_id + "<br>");
		out.print("총 접속자수 " + LoginImpl.total_user + "<br>");
		for (String id : list) {
			out.print("접속 아이디 : " + id + "<br>");
		}
		out.print("<a href='logout?user_id="+user_id+"'>로그아웃</a>");
		out.print("</body></html>");
	}

}
