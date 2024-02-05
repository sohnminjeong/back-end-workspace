package com.kh.model;

public class Book {
	private int bkNo;
	private String bkTitle;
	private String bkAuthor;
	private int bkPrice;
	private int pubNo;
	
	public Book() {}
	public Book(int bkNo, String bkTitle, String bkAuthor, int bkPrice, int pubNo) {
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
		this.bkPrice = bkPrice;
		this.pubNo = pubNo;
	}
	public int getBkNo() {
		return bkNo;
	}
	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}
	public String getBkTitle() {
		return bkTitle;
	}
	public void setBkTitle(String bkTitle) {
		this.bkTitle = bkTitle;
	}
	public String getBkAuthor() {
		return bkAuthor;
	}
	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}
	public int getBkPrice() {
		return bkPrice;
	}
	public void setBkPrice(int bkPrice) {
		this.bkPrice = bkPrice;
	}
	public int getPubNo() {
		return pubNo;
	}
	public void setPubNo(int pubNo) {
		this.pubNo = pubNo;
	}
	@Override
	public String toString() {
//		return "Book [bkNo=" + bkNo + ", bkTitle=" + bkTitle + ", bkAuthor=" + bkAuthor + ", bkPrice=" + bkPrice
//				+ ", pubNo=" + pubNo + "]";
		return "책 번호 : " + bkNo + ", 책 제목 : " + bkTitle + ", 책 저자 : " + bkAuthor ;
	}
	
	
}
