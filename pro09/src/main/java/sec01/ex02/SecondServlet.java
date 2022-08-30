package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/secondLogin")
public class SecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pwd");
		String address = request.getParameter("user_address");
		
		out.print("<html><body>");
		if(id != null && id.length() > 0 ) {
			
			out.println("<h1>이미 로그인 상태입니다!!</h1><br>");
			out.println("첫번째 서블릿에서 받은 id = " + id + "<br>");
			out.println("첫번째 서블릿에서 받은 pwd = " + pwd + "<br>");
			out.println("첫번째 서블릿에서 받은 address = " + address + "<br>");
		} else {
			out.println("<h1>로그인 하지 않았습니다</h1><br>");
			out.println("<a href='/pro09/login.html'>로그인</a>");
		} 
		
		out.print("<html><body>");
	}

}
