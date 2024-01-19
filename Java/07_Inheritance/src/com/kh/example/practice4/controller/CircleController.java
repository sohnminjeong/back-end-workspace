package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Circle;

public class CircleController {
	
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		// 필드 초기화하고 초기화한 정보와 면적 반환
		// 면적 : pi * 반지름 * 반지름
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double area = Math.PI * radius * radius;
		// 겹치는 부분을 to.string()으로 처리하고 다른 부분만 따로 적기 -> 겹치는 부분은 to.string에 작성
		return c + "넓이 : " +area;
	}
	
	public String calcCircum(int x, int y, int radius) {
		// 필드 초기화하고 초기화한 정보와 둘레 반환
		// 둘레 : pi * 반지름 * 2
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double circum = Math.PI * radius * 2;
		return c + "둘레 : " +circum;
	}
}
