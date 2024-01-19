package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Rectangle;

public class RectangleController {
	
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		//  필드 초기화하고 면적 반환
		// 면적 : 너비 * 높이
		 
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int area = height * width;
//		return "위치 : (" +x+ ", " +y+ "), 너비 : " +width+ ", 높이 : " + height+ " 넓이 : " + area;
		// 겹치는 부분은 toString()에 작성하고 r 사용하여 불러오기 
		return r + " 넓이 : " + area;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		// 필드 초기화하고 정보와 둘레 반환
		// 둘레 : 2 * (너비+넓이)
		
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int perimeter = 2 * (width+height);
//		return "위치 : (" +x+ ", " +y+ "), 너비 : " +width+ ", 높이 : " + height+ " 둘레 : " + perimeter;
		return r + " 넓이 : " + perimeter;
	}
}
