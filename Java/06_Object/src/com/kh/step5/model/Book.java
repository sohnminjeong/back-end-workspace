package com.kh.step5.model;

public class Book {
	
	/*
	 * 캡슐화(Encapsulation)
	 * - 정보은닉 : 외부에서 객체 접근하는데 있어서 정보를 숨기고 객체의 연산을 통해서만 접근이 가능하게 하는 것
	 * - 객체 내 정보손상, 오용을 방지하고, 데이터가 변경되어도 다른 객체에 영향을 주지 X 
	 * - 독립성이 좋고, 하나의 모듈처럼 사용이 가능 
	 * */
	
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	
	// alt+shift+S => generate constructor from superclass
	public Book() {
		super();
		// TODO Auto-generated constructor stub
		// 하지 않을 경우 : 부모 클래스에서 Book b = new Book(); 에러 발생 
	}


	// alt+shift+S => generate constructor using fields
	public Book(String title, int price, double discountRate, String author) {
		super();
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}

	// getter, setter 
	// setter 메서드 : 값 담을 때, getter 메서드 : 담은 값을 출력할 때 

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// 할인된 가격 적용
	/* : 가급적으로 모델은 건들이지 않음 
	public int getPrice() {
		return (int) (price - (price * discountRate));
	} -> 출력시 sysout(b.getPrice());
	*/
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getdiscountRate() {
		return discountRate;
	}

	public void setdiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
		
	
	
	@Override  // alt+shift+S => GeneratetoString
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", discountRate=" + discountRate + ", author=" + author
				+ "]";
	}
	
	
}

