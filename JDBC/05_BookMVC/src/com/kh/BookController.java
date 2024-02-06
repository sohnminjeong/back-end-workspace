package com.kh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Book;
import com.kh.model.Member;
import com.kh.model.Rent;

public class BookController {

	Member m = new Member();
	
	public BookController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234");
		return conn;
	}

	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		close(ps, conn);
	}

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection conn = getConnect();
		// 반복문을 이용해서 책 리스트 출력
		String query = "SELECT * FROM tb_book";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<>();

		while (rs.next()) {
			list.add(new Book(rs.getInt("bk_no"), rs.getString("bk_title"), rs.getString("bk_author"),
					rs.getInt("bk_price"), rs.getInt("pub_no")));
		}
		closeAll(rs, ps, conn);
		return list;

	}

	// 2. 책 등록
	public boolean registerBook(String title, String author) throws SQLException {
		
			Connection conn = getConnect();

			if (!bookCheck(title, author)) {
				String query = "INSERT INTO tb_book(bk_title, bk_author) VALUES(?, ?)";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, title);
				ps.setString(2, author);
				ps.executeUpdate();

				close(ps, conn);
				return true;
			}
			return false;
		}

	// 책 중복 등록 확인
	public boolean bookCheck(String title, String author) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_book WHERE bk_title = ? AND bk_author = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		ResultSet rs = ps.executeQuery();
		String bookCheck = null;
		if (rs.next())
			bookCheck = rs.getString("bk_title") + rs.getString("bk_author");
		closeAll(rs, ps, conn);
		if (bookCheck != null)
			return true;
		return false;
	}

	// 책 삭제
	public boolean sellBook(int num) throws SQLException {
	if(!sellCheck(num)) {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_book WHERE bk_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, num);
		ps.executeUpdate();
		close(ps, conn);
		return true;
	}
		return false;
	}
	// 책 삭제 - 책 번호 확인
	public boolean sellCheck(int num) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_book WHERE bk_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, num);
		ResultSet rs = ps.executeQuery();
		int sellCheck = 0;
		if(rs.next()) {
			sellCheck = rs.getInt("bk_no");
		}
		closeAll(rs, ps, conn);
		if(sellCheck==0) return true;
		return false;
	}

	
	public boolean registerMember(String id, String pwd, String name) throws SQLException {
		if(!registerCheck(id)) {
			Connection conn = getConnect();
			String query = "INSERT INTO tb_member(member_id, member_pwd, member_name) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);
			ps.executeUpdate();
			close(ps, conn);
			return true;
		}
		return false;
	}

	// 회원가입 - 중복 확인
	public boolean registerCheck(String id) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_member WHERE member_id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		String registerCheck = null;
		if(rs.next()) registerCheck = rs.getString("member_id");
		closeAll(rs, ps, conn);
		if(registerCheck!=null) return true;
		return false;
	}
	
	int memNo = 0;
	public String login(String id, String pwd) throws SQLException {
		// 반환값은 이름
		Connection conn = getConnect();
		String query = "SELECT member_name, member_no FROM tb_member WHERE member_id = ? AND member_pwd = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		String name = null;
		
		if(rs.next()) {
			name = rs.getString("member_name");
			memNo = rs.getInt("member_no");
		};
		closeAll(rs, ps, conn);
		if(name!=null) {
			m.setMemberId(id);
			m.setMemberPwd(pwd);
			return name;
		}
		return null;
	}

	// 1. 책 대여 
	
	public boolean rentBook(int num) throws SQLException {
		if(!sellCheck(num)) {
			Connection conn = getConnect();
			String query = "INSERT INTO tb_rent(bk_no, member_no) VALUES(?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, num);
			ps.setInt(2, memNo);
			int rentBook = 0;
			rentBook = ps.executeUpdate();
//			if(rs.next()) {
//				rentBook = rs.getInt("bk_no");
//			}
			close(ps, conn);
			if(rentBook != 0) return true;
			return false;
		}
		return false;
	}

	// 2. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook() throws SQLException {
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
		// join 필요 
		Connection conn = getConnect();
		String query = "SELECT bk_no, rent_no, bk_title, bk_author, rent_date, adddate(rent_date, 7) '반납 기한' FROM tb_rent JOIN tb_book USING(bk_no) WHERE member_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, memNo);
		ResultSet rs = ps.executeQuery();
		ArrayList<Rent> rentList = new ArrayList<>();
		while(rs.next()){
			rentList.add(new Rent(rs.getInt("rent_no"), rs.getString("bk_title"), rs.getString("bk_author"),
				rs.getDate("rent_date"), rs.getDate("반납 기한")));
		}
		closeAll(rs, ps, conn);
		return rentList;
	}
	
	// 3. 대여 취소
	public boolean deleteRent(int num) throws SQLException {
		if(deleteRentCheck(num)) {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_rent WHERE rent_no = ? AND member_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, num);
		ps.setInt(2, memNo);
		ps.executeUpdate();
		close(ps,conn);
		return true;
		}
		return false;
	}
	// 대여 목록 중복 체크
	public boolean deleteRentCheck(int num) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT bk_no FROM tb_rent WHERE rent_no = ? AND member_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, num);
		ps.setInt(2, memNo);
		ResultSet rs = ps.executeQuery();
		int deleteRentCheck = 0;
		if(rs.next()) deleteRentCheck = rs.getInt("bk_no");
		closeAll(rs, ps, conn);
		if(deleteRentCheck!=0) return true;
		return false;
	}
	
	
	// 4. 회원 탈퇴
	public boolean deleteMember() throws SQLException {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_member WHERE member_no = ? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, memNo);
		ps.executeUpdate();
		close(ps, conn);
		return true;
	}
		
	
}
