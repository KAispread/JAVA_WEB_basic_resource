package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input2")
public class InputServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Enumeration enu = req.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = String.valueOf(enu.nextElement());
			String[] values = req.getParameterValues(name);
			for (String value : values) {
				System.out.println(name + " : " + value);
			}
		}
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
}
