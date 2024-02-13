package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@WebServlet("/register")  // web.xml에 등록한거랑 같은 의미 (index.html연결)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Controller - 비즈니스 로직 작성 공간
		// 1. 폼 값 받아온다. 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		// 2. VO 작성 
		Member member = new Member(id, pwd, name);
		
		// 3. DAO 리턴 받기 
		MemberDAO dao = new MemberDAO();
		
		try {
			dao.registerMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 4. 바인딩 : 결과 페이지에 서버에서 받은 값을 보낼 때 
		request.setAttribute("name", name);   //(key, value) 작성 
		
		// 5. 네비게이션 : 결과 페이지 지정
		// request.getRequestDispatcher("result.jsp").forward(request, response);
		// -> 만약에 회원가입이 끝나고 view 페이지를 보여주고 싶다
		// view 페이지는 폼 값 받는 로직X 
		response.sendRedirect("view");
		
	}

}
