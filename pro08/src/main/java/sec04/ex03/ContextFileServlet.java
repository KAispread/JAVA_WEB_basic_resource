package sec04.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		InputStream stream = context.getResourceAsStream("/WEB-INF/bin/init.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		String menu = null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;
		while ((menu = reader.readLine()) != null) {
			StringTokenizer token = new StringTokenizer(menu, ",");
			menu_member = token.nextToken();
			menu_order = token.nextToken();
			menu_goods = token.nextToken();
			
		}
		out.print("<html><body>");
		out.print(menu_member + "<br>");
		out.print(menu_order + "<br>");
		out.print(menu_goods + "<br>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
