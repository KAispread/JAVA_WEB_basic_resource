package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
      
    public LoginServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출 ");
	}

	
	public void destroy() {
		System.out.println("destroy 메서드 호출 ");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_password");

		System.out.println("아이디 : " + userId);
		System.out.println("비밀번호 : " + userPw);
	}

}
