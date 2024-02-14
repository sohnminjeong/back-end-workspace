package com.kh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Member;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃 : 세션 죽여서 로그아웃하고 index.jsp로 오면 됨 
		
		// 3. session 죽이기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("login");
		
		if(member!=null) {
			session.invalidate();
		}
		
		// 4. 네비게이션
		response.sendRedirect("index.jsp");				
	}

}
