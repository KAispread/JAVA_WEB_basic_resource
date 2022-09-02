package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter extends HttpFilter implements Filter {
	ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 encoding...");
		context = fConfig.getServletContext();
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		
		String path = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String realPath = request.getRealPath(pathinfo);
		
		String mesg = "Context 정보 : " + context
						+ "\n URI 정보 : " + pathinfo
						+ "\n 물리적 경로 : " + realPath;
		System.out.println(mesg);
		long begin = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		
		System.out.println("작업 시간 : " + (end - begin) + "ms");
	}
}
