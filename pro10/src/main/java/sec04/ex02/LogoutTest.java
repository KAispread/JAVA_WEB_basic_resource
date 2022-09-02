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

/**
 * Servlet implementation class LogoutTest
 */
@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		ServletContext context = getServletContext();
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		session.invalidate();
		List<String> userList = (ArrayList<String>)context.getAttribute("userList");
		
		userList.remove(user_id);
		context.removeAttribute("user_list");
		context.setAttribute("userList", userList);
		out.println("<br> 로그아웃 했습니다.");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
