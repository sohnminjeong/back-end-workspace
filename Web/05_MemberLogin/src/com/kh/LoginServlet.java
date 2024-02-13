package com.kh;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 폼 값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// DAO
		MemberDAO dao = new MemberDAO();
		
		
		try {
			dao.login(id, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Member member = new Member(id, password, "로그인");
		
		// session
		HttpSession session = request.getSession();
		session.setAttribute("login", member);
		
		//views/login_result.jsp로 이동해서 정보 출력
		response.sendRedirect("/views/login_result.jsp"); // 경로설정 : /views부터 작성 필요 
		 
	}

}
