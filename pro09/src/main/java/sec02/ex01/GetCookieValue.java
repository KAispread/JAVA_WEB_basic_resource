package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieValue
 */
@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] c = request.getCookies();
		
		for(Cookie cookie : c) {
			if (cookie != null && cookie.getName().equals("cookieTest")){
				out.println("cookie value : " + URLDecoder.decode(cookie.getValue(), "utf-8") + "<br>");
				out.println("cookie age : " + cookie.getMaxAge() + "<br>");
			}
		}
	}
}
