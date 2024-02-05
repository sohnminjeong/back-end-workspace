package com.kh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Member;

public class MemberController {

	Member m = new Member();
	ArrayList<Member> list = new ArrayList<>();

	public MemberController() {
		//1. 드라이버 로딩 - 생성자로!
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		// 2. DB 연결 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		return conn;
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}

	public boolean signUp(Member m) throws SQLException {
		Connection conn = getConnect();
		// 회원가입 기능 구현!
		// -> 아이디가 기존에 있는지 체크 여부! - idCheck();
		// member 테이블에 데이터 추가!(insert)
		
		if(!idCheck(m.getId())) {
				String query = "INSERT INTO member(id, password, name) VALUES(?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(query);

				ps.setString(1, m.getId());
				ps.setString(2, m.getPassword());
				ps.setString(3, m.getName());

				ps.executeUpdate();  // query문 실행 : executeUpdate 필요 

				closeAll(ps, conn);
				return true;
		}
		return false;
	}

	public boolean idCheck(String id) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT id FROM member WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		String checkId = null;
		if(rs.next()) checkId = rs.getString("id");
		closeAll(rs, ps, conn);
		if(checkId!=null) return true;
		return false;
	}
	
	public String login(String id, String password) throws SQLException {
		// 로그인 기능 구현
		// --> member 테이블에서 id와 password로 정보 하나 가져오기! (select)

			Connection conn = getConnect();
			
			String query = "SELECT name FROM member WHERE id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, id);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			String name = null;
			if (rs.next()) name = rs.getString("name");
			closeAll(rs, ps, conn);
			return name;
	}

	
	public boolean changePassword(String id, String oldPw, String newPw) throws SQLException {
		// 비밀번호 바꾸기 기능 구현 --> (update)
		Connection conn = getConnect();
		// -> login 메서드 활용 후 사용자 이름이 null 이 아니면 해당 UPDATE 문 구현!
		PreparedStatement ps = null;
		boolean result = false;
		if(login(id, oldPw)!=null) {

			// --> member 테이블에서 id로 새로운 패스워드로 변경(update)
			String query = "UPDATE member SET password = ? WHERE id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, newPw);
			ps.setString(2, id);	
			ps.executeUpdate();
			result = true;
		}
		
		closeAll(ps, conn);  
		// if밖에서도 사용했기 때문에 if문 밖에서 close처리하며 맨 위에서 각 rs,conn 등이 null이 아닌 경우라는 조건 걸어야 함
		return result;
	}

	public void chageName(String id, String newName) throws SQLException {
		// 이름 바꾸기 기능 구현! --> (update)
		// --> member 테이블에서 id로 새로운 이름으로 변경(update)
		Connection conn = getConnect();
		String query = "UPDATE member SET name = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, newName);
		ps.setString(2, id);
		ps.executeUpdate();
		closeAll(ps, conn);
	}
	
/*
	public void delete(String id) throws SQLException {
		Connection conn = getConnect();
		String query = "DELETE FROM member WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.executeUpdate();
		closeAll(ps, conn);
	}
*/
	
}
