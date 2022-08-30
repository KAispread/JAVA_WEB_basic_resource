package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 */
@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		LocalDateTime now = LocalDateTime.now();
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍 입니다.", "utf-8"));
		
		c.setMaxAge(24 * 60 * 60); // 쿠키의 유효기간을 정해줌으로써 Persistence Cookie로 만듦 (24시간의 유효기간을 가진)
		response.addCookie(c);
		out.println("현재시간 : "+ now);
		out.println("문자열을 Cookie에 저장합니다.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
