package com.kh;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@WebServlet("/AllMemberServlet")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼값 받기 - 필요 없음
		
		// 2. DAO
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;
		try {
			list = dao.allShowMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. 바인딩
		request.setAttribute("list", list);
		
		// 4. 네비게이션
		request.getRequestDispatcher("/views/allShow.jsp").forward(request, response);
		// request에 있는게 있기 때문에 .getRequestDispatcher사용 
		
	}

}
