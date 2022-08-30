package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ="/login1")
public class LoginServlet extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		out.println("</body></html>");
	}

}
