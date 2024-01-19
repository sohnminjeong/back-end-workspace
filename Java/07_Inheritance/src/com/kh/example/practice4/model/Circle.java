package com.kh.example.practice4.model;

public class Circle extends Point{
	private int radius;

	public Circle() {}

	public Circle(int x, int y) {
		super(x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		// 겹치는 부분을 toString()에 적고 이를 controller return에서 부르기 
		return "위치 : (" + super.getX() + ", " + super.getY() + "), 반지름 : " +radius+ " / ";
	}
	
}
