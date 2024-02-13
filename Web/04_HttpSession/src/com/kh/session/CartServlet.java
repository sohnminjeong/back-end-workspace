package com.kh.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Member;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("info"); //loginServlet에서 담은 것
		
		// request
		String product = (String) request.getAttribute("product");  // ProductServlet에서 담은 것 
		
		System.out.println(member);  //입력값에 따라 Member [id=test, password=1234, name=테스트]
		// session은 죽이기 전까지 정보가 살아있음
		System.out.println(product); 
		// ProductServlet에서 response.sendRedirect("CartServlet")일 경우 null 나옴 -> request는 딱 그때만 남아있고 사라짐
		// ProductServlet에서 request.getRequestDispatcher("CartServlet").forward(request, response)일 경우 : notebook
	
		// 로그아웃! 즉 세션 정보 죽여버리기!
		session.invalidate();
		response.sendRedirect("index.html");
		
	}

}
