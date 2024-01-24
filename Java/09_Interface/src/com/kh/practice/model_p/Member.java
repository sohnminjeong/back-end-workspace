package com.kh.practice.model_p;

import java.util.Arrays;

// model class : 캡슐화 적용! 
// 캡슐화 원칙 : 변수는 private, 
public class Member {

	private String name = "";
	private int age = 0;
	private int coupon = 0;
	private Book[] bookList = new Book[3];   // 포함관계 
	
	
	public String getName() {  // String-매개변수x-return(보여줘야 하기 때문)
		return name;
	}
	public void setName(String name) { //void-매개변수-return없음
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public Book[] getBookList() {
		return bookList;
	}
	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}
	
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}
}

