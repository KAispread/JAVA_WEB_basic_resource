package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* @WebServlet(name = "LoginTest2", urlPatterns = { "/login" }) */
public class LoginTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		LoginImpl loginUser = new LoginImpl(request.getParameter("user_id"), request.getParameter("user_id"));
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}
		out.print("<html>");
		out.print("<head>");
		out.print("<script type='text/javascript'>");
		/* out.print("setTimeout('history.go(0);', 5000)"); */
		out.print("</script>");
		out.print("</head>");
		out.print("<body>");
		out.print("아이디는 " + loginUser.user_id + "<br>");
		out.print("총 접속자수는 " + LoginImpl.total_user + "<br>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
