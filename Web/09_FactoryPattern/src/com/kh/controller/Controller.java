package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 공장 기계 역할! 죽, 틀!이라고 보면 됨
public interface Controller {
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
