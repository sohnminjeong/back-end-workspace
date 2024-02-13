package com.kh.controller;

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

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// 폼 값 받아오기, VO 작성 생략
		// 1. DAO 리턴 받기
		// dao.showAllMember() 메서드 : ArrayList<Member> 리턴 타입 <-- list로 담아서 
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;
		try {
			list = dao.showAllMember();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		 
		// 2. 바인딩 : list 전체 
		// setAttribute로 
		request.setAttribute("list", list);  //"키", 보낼값
		
		// 3. 네비게이션 : view.jsp에다가 보내기 
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
