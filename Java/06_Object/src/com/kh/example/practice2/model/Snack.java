package com.kh.example.practice2.model;
// model 기본 구조 : 변수 선언, 생성자(2개), setter&getter, override)
public class Snack {
	// private : 같은 클래스 내에서만 사용 가능 -> 생성자 또는 setter, getter 사용)
	private String kind;
	private String name;
	private String flavor;
	private int numOf;
	private int price;
	
	//Q : 왜 기본 세팅이 기본생성자와 꽉 채워진 생성자 두개 다 필요한가 
	// 기본생성자 : 모든 클래스에 다 있음
	public Snack() {}
	
	// 꽉 채워진 생성자
	public Snack(String kind, String name, String flavor, int numOf, int price) {
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;
	}
	
	// setter : 그때마다의 각 값을 저장, getter : 하나하나 넣은 값을 가지고 올 때 
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public int getNumOf() {
		return numOf;
	}
	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	@Override     // 주소값나오는 것 방지 
	public String toString() {
		return "Snack [kind=" + kind + ", name=" + name + ", flavor=" + flavor + ", numOf=" + numOf + ", price=" + price
				+ "]";
	}
	
	
	
}
