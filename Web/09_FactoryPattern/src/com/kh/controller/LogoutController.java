package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Member;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 로그아웃 : 세션 죽여서 로그아웃하고 index.jsp로 오면 됨

		// 3. session 죽이기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("login");

		if (member != null) {
			session.invalidate();
		}

		return new ModelAndView("index.jsp", true);
		
	}

}
