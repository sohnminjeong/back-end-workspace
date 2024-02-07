package com.kh.model.vo;

import java.util.Date;

public class Rent {
	private int retNo;
	private Member member;  // member_no가 Member에 foreign 걸려있오 뵨굥 
	private Book book;   	// bk_no가 Book에 foreign 걸려있어 변경
	private Date rentDate;
	
	public Rent() {}
	public Rent(int retNo, Member member, Book book, Date rentDate) {
		this.retNo = retNo;
		this.member = member;
		this.book = book;
		this.rentDate = rentDate;
	}
	public int getRetNo() {
		return retNo;
	}
	public void setRetNo(int retNo) {
		this.retNo = retNo;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getRentDate() {
		return rentDate;
	}
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	@Override
	public String toString() {
		return "Rent [retNo=" + retNo + ", member=" + member + ", book=" + book + ", rentDate=" + rentDate + "]";
	}

}
