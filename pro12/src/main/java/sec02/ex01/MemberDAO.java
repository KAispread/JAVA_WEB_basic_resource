package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");

			// context.xml에 설정한 name 값으로 톰캣이 미리 연결한 DataSource를 받아옴
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public boolean isExist(MemberVO memberVO) {
		boolean result = false;
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		try {
			con = dataFactory.getConnection();
			String query = "select decode(count(*),1,'true','false') as result from t_member" + " where id=? and pwd=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result = " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();

		try {
			con = dataFactory.getConnection(); // DataSource를 이용해 데이터베이스에 연결

			String query = "select * from t_member ";
			System.out.println(query);

			pstmt = con.prepareStatement(query); // query를 전달하여 PreparedStatement 객체를 생성.
			ResultSet rs = pstmt.executeQuery(query);

			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<MemberVO> listMembers(String member_name) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo = new MemberVO();

		try {
			con = dataFactory.getConnection(); // DataSource를 이용해 데이터베이스에 연결

			String query = "select * from t_member where name=" + "'" + member_name + "'";
			System.out.println(query);

			pstmt = con.prepareStatement(query); // query를 전달하여 PreparedStatement 객체를 생성.
			ResultSet rs = pstmt.executeQuery(query);

			if (rs.next()) {
				System.out.println("Print specified Member");
				bindingMember(rs, list);
			} else {
				System.out.println("Print All Member");
				query = "select * from t_member";
				rs = pstmt.executeQuery(query);
				bindingMembers(rs, list);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();

			String query = "insert into t_member";
			query += "(id,pwd,name,email)";
			query += "values(?,?,?,?)";
			System.out.println("prepareStatement: " + query);

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();

			String query = "delete from t_member where id=?";
			System.out.println("prepareStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void bindingMember(ResultSet rs, List<MemberVO> list) throws Exception {
		String id = rs.getString("id");
		String pwd = rs.getString("pwd");
		String name = rs.getString("name");
		String email = rs.getString("email");
		Date joinDate = rs.getDate("joinDate");
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setEmail(email);
		vo.setJoinDate(joinDate);
		list.add(vo);
	}

	private void bindingMembers(ResultSet rs, List<MemberVO> list) throws Exception {
		while(rs.next()) {	
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			vo.setJoinDate(joinDate);
			list.add(vo);
		}
	}
}
