package com.kh.test2.model;

public class Rectangle {
	// 1. (-)라 표시되어 있기 때문에 + 변수는 public이 아닌 private으로 지정
	private int width;
	private int height;
	
	// 2. public Rectangle()이 빠져 있음
	public Rectangle() {}
	
	// 3. (+)로 표시되어 있기 때문에 Rectangle(int width, int height)은 protected가 아닌 public
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	// (+)로 표시되어 있기 때문에 getter와 setter는 public
	// getter는 return 형식이 int인 return 값이 필요하기 때문에 이를 명시해야 함.
	// setter는 return 형식이 void로 return 값이 없고 값을 저장하는 것이기 때문에 return 을 사용하지 않고 
	// this.width = width; , this.height=height;을 사용해야 함.
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	// (+)이기 때문에 public 형태인 toString이 빠져 있다.
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
}
