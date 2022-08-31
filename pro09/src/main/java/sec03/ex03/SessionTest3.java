package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest3
 */
@WebServlet("/sess3")
public class SessionTest3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		
		out.println("세션 아이디 :" + session.getId() + "<br>");
		out.println("세션 최초 생성 시간 :" + new Date(session.getCreationTime()) + "<br>");
		out.println("세션 최근 접근 시간 :" + new Date(session.getLastAccessedTime()) + "<br>");
		out.println("세션 유효 시간 :" + session.getMaxInactiveInterval() + "<br>");
		if (session.isNew()) {
			out.println("새 세션이 생성되었습니다.");
		}
		session.invalidate();
	}

}
