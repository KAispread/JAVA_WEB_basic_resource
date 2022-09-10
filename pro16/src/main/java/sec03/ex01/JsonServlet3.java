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
 * Servlet implementation class JsonServlet3
 */
@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
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
		
		JSONObject book = new JSONObject();
		JSONArray bookArray = new JSONArray();
		book.put("title", "초보자를 위한 자바 프로그래밍");
		book.put("author", "이병승");
		book.put("price", "30000");
		book.put("genre", "IT");
		book.put("image", "http://localhost:8080/pro16/image/image1.jpg");
		bookArray.add(book);
		
		book = new JSONObject();
		book.put("title", "모두의 파이썬");
		book.put("author", "이승찬");
		book.put("price", "12000");
		book.put("genre", "IT");
		book.put("image", "http://localhost:8080/pro16/image/image2.jpg");
		bookArray.add(book);

		totalObject.put("books", bookArray);
		
		String jsonInfo = totalObject.toJSONString();
		out.print(jsonInfo);
		out.close();
	}

}
