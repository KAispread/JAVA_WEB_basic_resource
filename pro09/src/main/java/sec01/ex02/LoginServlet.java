package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet1", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = (String) request.getParameter("user_id");
		String pwd = (String) request.getParameter("user_pwd");
		String address = (String) request.getParameter("user_address");
		String email = (String) request.getParameter("user_email");
		String hp = (String) request.getParameter("user_hp");
		
		out.println("<html><body>");
		out.println("id = " + id + "<br>");
		out.println("pwd = " + pwd + "<br>");
		out.println("address = " + address + "<br>");
		out.println("email = " + email + "<br>");
		out.println("hp = " + hp + "<br>");
		out.print("<br> <a href='/pro09/secondLogin?user_id="+id+"&user_pwd="+pwd+"&user_address="+address+"'>두번째 서블릿으로 이동</a>");
		out.println("</body></html>");
	}

}
