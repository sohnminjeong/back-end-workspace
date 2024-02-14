package com.kh;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 폼 값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		// 2. VO 작성
		Member member = new Member(id, password, name);
		
		// 3. DAO 리턴 받기
		MemberDAO dao = new MemberDAO();
		
		try {
			int result = dao.register(member);
			
			// 4. 바인딩 - 필요X
			//바인딩 할 것 없고 바로 index.jsp로 이동
			
			if(result==1) {
				// 5. 네비게이션
				response.sendRedirect("index.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 바인딩
		//request.setAttribute("register", member);
		
		// 네비게이션
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
