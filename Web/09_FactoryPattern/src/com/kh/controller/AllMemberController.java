package com.kh.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class AllMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1. 폼값 받기 - 필요 없음

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;

		list = dao.allShowMember();

		// 3. 바인딩
		request.setAttribute("list", list);

		return new ModelAndView("/views/allShow.jsp");
	}

}
