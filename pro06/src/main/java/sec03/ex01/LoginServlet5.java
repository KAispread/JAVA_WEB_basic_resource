package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
    public LoginServlet5() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method has been occured");
	}
	public void destroy() {
		System.out.println("destroy method has been occured");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);
		
		StringBuilder data = new StringBuilder();
		data.append("<html>");
		data.append("<body>");
		data.append("아이디 : "+ id);
		data.append("<br>");
		data.append("패스워드 : "+ pw);
		data.append("<br>");
		data.append("주소 : "+ address);
		data.append("</body>");
		data.append("</html>");
		out.print(data.toString());
	}

}
