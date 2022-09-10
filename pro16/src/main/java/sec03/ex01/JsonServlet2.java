package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet2
 */
@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		JSONObject totalObject = new JSONObject();
		JSONArray memberArray = new JSONArray();
		JSONObject member = new JSONObject();
		member.put("name", "이기우");
		member.put("age", "25");
		member.put("gender", "남자");
		member.put("nickname", "KAI");
		memberArray.add(member);
		
		member = new JSONObject();
		member.put("name", "김강훈");
		member.put("age", "25");
		member.put("gender", "여자");
		member.put("nickname", "킹강훈");
		memberArray.add(member);
		
		totalObject.put("members", memberArray);
		
		String jsonInfo = totalObject.toJSONString();
		out.print(jsonInfo);
		out.close();
	}
}
