package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// hidden 값으로 들어온 요청을 받지 않고, 들어온 요청의 주소를 직접 인식시킨다.
		String requestURI = request.getRequestURI();
		//System.out.println(requestURI);   // /regiser.do, /login.do 등으로 표시됨
		String[] requestURIList = requestURI.split("/");
		//System.out.println(Arrays.toString(requestURIList));   // [, login.do]
		
		String command = requestURIList[requestURIList.length -1];
		
		
	}


	// 2. 로그인
	protected String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		// 1. 폼 값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DAO
		MemberDAO dao = new MemberDAO();

		Member member = dao.login(id, password);

		// 3. 바인딩 - session
		HttpSession session = request.getSession();
		session.setAttribute("login", member);

		return "/views/login_result.jsp";
	}

	// 2-1. 회원 검색
	protected String search(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		// 1. 폼 값 받기
		String id = request.getParameter("id");

		// 2. DAO
		MemberDAO dao = new MemberDAO();

		Member member = dao.find(id);

		if (member != null) {
			// 3. 바인딩
			request.setAttribute("find", member);
			// 4. 네비게이션
			return "/views/find_ok.jsp";
		} else {
			return "/views/fail_fail.jsp";
		}

		// 삼항연산자로도 가능
		//if(member != null) request.setAttribute("find", member);
		//return member != null ? "/views/find_ok.jsp" : "/views/fail_fail.jsp";
	}

	// 2-2. 전체회원보기
	protected String allShow(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		// 1. 폼값 받기 - 필요 없음

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;

		list = dao.allShowMember();

		// 3. 바인딩
		request.setAttribute("list", list);

		return "/views/allShow.jsp";
	}

	// 2-3. 로그아웃
	protected String logout(HttpServletRequest request, HttpServletResponse response) {

		// 로그아웃 : 세션 죽여서 로그아웃하고 index.jsp로 오면 됨

		// 3. session 죽이기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("login");

		if (member != null) {
			session.invalidate();
		}

		return "index.jsp";
	}
}
