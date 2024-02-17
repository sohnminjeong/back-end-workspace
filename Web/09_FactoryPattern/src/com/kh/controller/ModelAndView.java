package com.kh.controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect;
	
	public ModelAndView() {}

	// 생성자 - path만 있는 거
	public ModelAndView(String path) {  // 네비게이션 forward 방식일 때 사용
		this.path = path;
	}
	// 생성자 - 둘다 있는 거 
	public ModelAndView(String path, boolean isRedirect) {  // 네비에기션 sendRedirect 방식일 때 사용~ true 값 같이 넘겨서 
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
