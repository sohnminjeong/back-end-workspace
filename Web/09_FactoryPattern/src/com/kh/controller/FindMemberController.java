package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class FindMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1. 폼 값 받기
		String id = request.getParameter("id");

		// 2. DAO
		MemberDAO dao = new MemberDAO();

		Member member = dao.find(id);

		if (member != null) {
			// 3. 바인딩
			request.setAttribute("find", member);
			// 4. 네비게이션
			return new ModelAndView("/views/find_ok.jsp");
		} else {
			return new ModelAndView("/views/fail_fail.jsp", true);
		}

	}

}
