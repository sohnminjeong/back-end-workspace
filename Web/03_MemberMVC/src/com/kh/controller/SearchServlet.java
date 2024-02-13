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


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼 값 받아오기
		String name = request.getParameter("name");
		
		// 2. VO 작성 생략
		
		// 3. DAO 리턴 받기
		MemberDAO dao = new MemberDAO();
		Member member = null;
		try {
			member = dao.searchMember(name);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		// 4. 바인딩 : 보여줄 결과 페이지에 내가 가져온 정보 담기 
		request.setAttribute("info", member);  // member정보를 info라는 키로 담기
		
		//5. 네비게이션 : 어디로 보여줄지  (만약에 멤버 정보가 없으면.. 이라는 것 추가!)
		if(member!=null) {			
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} else {
			response.sendRedirect("fail.jsp");
		}
		// 내가 있는 바인딩 정보가 있을 경우 getrequestdispatcher사용 & 없을 경우 sendRedirect
		// 바인딩이 있기 때문에 .forward(request, response)사용
	}

}
