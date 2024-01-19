package com.kh.example.practice4.model;

public class Rectangle extends Point{
	
	private int width;
	private int height;
	
	
	public Rectangle() {}
	public Rectangle(int x, int y) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
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
	@Override
	public String toString() {
//		return super.toString() +  "Rectangle [width=" + width + ", height=" + height + "]";
//		return "위치 : (" + super.getX() +  ", " + super.getY() + "), 너비 : " +width+ ", 높이 : " + height + " / ";
		// Point에 있는 toString()도 수정하여 super.toString()으로 표시!
		return super.toString() + "너비 : " +width+ ", 높이 : " + height + " / ";
	}
	
	
	
}
