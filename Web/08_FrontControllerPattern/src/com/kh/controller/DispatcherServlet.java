package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청이 어디에서 들어오는 요청인지 구분할 command 값 같이 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";

		try {

			if (command.equals("register")) {
				path = register(request, response); // = index.jsp

			} else if (command.equals("login")) {
				path = login(request, response);
			} else if (command.equals("search")) {
				path = search(request, response);
			} else if (command.equals("allShow")) {
				path = allShow(request, response);
			} else if (command.equals("logout")) {
				path = logout(request, response);
			}

		} catch (SQLException e) {
		}

		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
	}

	// 1. 회원가입
	protected String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		// 1. 폼 값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		// 2. VO 작성
		Member member = new Member(id, password, name);

		// 3. DAO 리턴 받기
		MemberDAO dao = new MemberDAO();
		dao.register(member);

		// 모든 로직이 네비게이션이 마지막임으로 if문 아예 없애고 return을 네비게이션으로!
		return "index.jsp";
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
		// if(member != null) request.setAttribute("find", member);
		// return member != null ? "/views/find_ok.jsp" : "/views/fail_fail.jsp";
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
