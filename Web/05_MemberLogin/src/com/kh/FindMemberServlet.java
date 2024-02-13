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


@WebServlet("/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		//Member member = new Member(id, "", "");
		
		MemberDAO dao = new MemberDAO();
		Member member = null;
		try {
			member = dao.find(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		request.setAttribute("find", member);
		
		
		if(member!=null) {
		request.getRequestDispatcher("/views/find_of.jsp").forward(request, response);
		}else {
		request.getRequestDispatcher("/views/fail_fail.jsp").forward(request, response);
		}
		

	
	
	}
	


}
