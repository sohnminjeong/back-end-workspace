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
		// 회원가입 기능 구현!
		// member 테이블에 데이터 추가!(insert)
		// 로그인 기능 구현이 먼저 되어야 함!
		// login 결과값이 null이 아닌 경우만 구현! 그게 아닐 때는 false만 리턴
		try {
			if (login(m.getId(), m.getPassword()) == null) {

				Connection conn = getConnect();

				String query = "INSERT INTO member(id, password, name) VALUES(?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(query);

				ps.setString(1, m.getId());
				ps.setString(2, m.getPassword());
				ps.setString(3, m.getName());

				int result = ps.executeUpdate();

				closeAll(ps, conn);
				return true;
			} else {
				return false;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			return false;
		}
	}

	public String login(String id, String password) {
		// 로그인 기능 구현
		// --> member 테이블에서 id와 password로 정보 하나 가져오기! (select)
//		if (id.equals(m.getId()) && password.equals(m.getPassword())) {

		try {
			Connection conn;
			conn = getConnect();

			String query = "SELECT * FROM member WHERE id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, id);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			ArrayList<Member> list = new ArrayList<>();

			while (rs.next()) {
				list.add(new Member(rs.getString("id"), rs.getString("password"), rs.getString("name")));
				// System.out.println(rs.getString("name"));
				String name = rs.getString("name");
				return name;
			}
			return null;
//				int i = list.indexOf(rs);
//				return list.get(1).getName();
//				closeAll(rs, ps, conn);
//			} else {
//				return null;
//			}

		} catch (SQLException e) {
			return null;
		}

	}

	public boolean changePassword(String id, String oldPw, String newPw) {
		// 비밀번호 바꾸기 기능 구현 --> (update)
		// -> login 메서드 활용 후 사용자 이름이 null 이 아니면 해당UPDATE 문 구현!
		// --> member 테이블에서 id로 새로운 패스워드로 변경(update)
		try {
//			if(id&password가 전부 기록과 같아야 한다고 이씨)
			if(id.equals(m.getId())) {
				Connection conn = getConnect();

				String query = "UPDATE member SET password = ? WHERE id = ?";
				PreparedStatement ps = conn.prepareStatement(query);

				ps.setString(1, newPw);
				ps.setString(2, id);

				int result = ps.executeUpdate();

				closeAll(ps, conn);

				return true;
			} else {
				return false;  // 여기가 문제 
			}
			
		}
		catch (SQLException e) {
			return false;
		}

	}

	public void chageName(String id, String changeName) {
		// 이름 바꾸기 기능 구현! --> (update)
		// --> member 테이블에서 id로 새로운 이름으로 변경(update)

	}
}
