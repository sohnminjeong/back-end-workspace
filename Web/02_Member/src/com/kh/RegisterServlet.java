package com.kh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.html에서 /register로 요청을 하여 
		// 요청 받은 이름, 나이, 주소를 받아서 
		// result.jsp 파일로 해당 정보 출력
		// <a href='result.jsp'>결과 확인</a>  <-- 이 링크를 눌렀을 시 
		// 해당 result.jsp 페이지에서
		// '주소'에 사는 '나이'세인 '이름'가입 완료 <-- h1태그!
		//[EncodingFilter를 생성하여 web.xml에서 연결]
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		
		
		PrintWriter pw = response.getWriter();
//		pw.println("<h2>이름 : " + name + "</h2>");
//		pw.println("<h2>나이 : " + age + "</h2>");
//		pw.println("<h2>주소 : " + addr + "</h2>");
		//윗부분은 링크 누르기 전에 페이지에서 이름, 나이, 주소가 바로 나옴 
		pw.println("<a href='result.jsp?name=" + name + "&age=" + age + "&addr=" +addr + "'>결과 확인</a>");
		
		pw.close();
		
	}

}
