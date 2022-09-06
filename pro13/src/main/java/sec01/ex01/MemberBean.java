package sec01.ex01;

import java.util.Date;

public class MemberBean {
	String id;
	String pwd;
	String email;
	String name;
	Date joinDate;
	
	
	
	public MemberBean() {
		super();
	}

	public MemberBean(String id, String pwd, String email, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
	}

	public MemberBean(String id, String pwd, String email, String name, Date joinDate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
		this.joinDate = joinDate;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
