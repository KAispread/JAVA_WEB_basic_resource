package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user=0;
	
	public LoginImpl() {}
	
	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("Create Session");
        ++total_user;
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    	System.out.println("Destroy Session");
    	total_user--;
    }
}
