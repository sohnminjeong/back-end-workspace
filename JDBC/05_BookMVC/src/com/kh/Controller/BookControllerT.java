package com.kh.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.BookDAO;
import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;

public class BookControllerT {

	private BookDAO dao = new BookDAO();

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		try {
			return dao.printBookAll();
			// dao에서 throw해서 던지고 controller에서 try-catch로 잡기
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 2. 책 등록
	public boolean registerBook(String title, String author) {
		try {
			if (dao.registerBook(title, author) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 3. 책 삭제
	public boolean sellBook(int no) {
		
		try {
			if(dao.sellBook(no)==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	// 4. 회원가입부터는 MemberController로 분리!

}
