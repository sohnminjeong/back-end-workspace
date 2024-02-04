package com.kh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.kh.model.Member;

public class MemberController {

	Member m = new Member();
	ArrayList<Member> list = new ArrayList<>();

	public MemberController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		return conn;
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		ps.close();
		conn.close();
	}



	public boolean signUp(Member m) throws SQLException {
		try{
//		if(login(m.getId(), m.getPassword())==null) {
			
			Connection conn = getConnect();

			String query = "INSERT INTO member(id, password, name) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);

			
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());

			int result = ps.executeUpdate();

			closeAll(ps, conn);
			return true;
		}
//			return true;
//		} else {
//			return false;
//		}
//		} 
	catch(SQLIntegrityConstraintViolationException e) {
			return false;
		}
		
		

		// 회원가입 기능 구현 --> Member 테이블에 데이터 추가 (insert)
//		list.add(m);
//
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).i(m.getId())) {
//				return false;
//			} else {
//				return true;
//			}
//		}

	}

	public String login(String id, String password) throws SQLException {
		// 로그인 기능 구현 --> member 테이블에서 id와 password로 정보 하나 가져오기! (select)
		if (id.equals(m.getId()) && password.equals(m.getPassword())) {
			
			Connection conn = getConnect();

			String query = "SELECT name FROM member WHERE id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
			}
			
			
			closeAll(rs, ps, conn);
			
			
		}
		return "짜증";
	}

	public boolean changePassword(String id, String oldPw, String newPw) {
		// 비밀번호 바꾸기 기능 구현 --> (update)
		// -> login 메서드 활용 후 사용자 이름이 null 이 아니면 해당UPDATE 문 구현!
		// --> member 테이블에서 id로 새로운 패스워드로 변경(update)
		return false;
	}

	public void chageName(String id, String changeName) {
		// 이름 바꾸기 기능 구현! --> (update)
		// --> member 테이블에서 id로 새로운 이름으로 변경(update)

	}
}
