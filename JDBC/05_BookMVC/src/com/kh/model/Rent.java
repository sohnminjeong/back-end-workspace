package com.kh.model;

import java.sql.Date;

public class Rent {
// rent_no, bk_title, bk_author, rent_date, adddate(rent_date, 7)
	private int rentNo;
	private String bkTitle;
	private String bkAuthor;
	private Date rentDate;
	private Date lastDate;

//	public Rent() {	}
//	public Rent(int rentNo, String bkTitle, String bkAuthor, Date rentDate) {
//		super();
//		this.rentNo = rentNo;
//		this.bkTitle = bkTitle;
//		this.bkAuthor = bkAuthor;
//		this.rentDate = rentDate;
//	}

	public Rent() {}
	public Rent(int rentNo, String bkTitle, String bkAuthor, Date rentDate, Date lastDate) {
		super();
		this.rentNo = rentNo;
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
		this.rentDate = rentDate;
		this.lastDate = lastDate;
	}

	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public int getRentNo() {
		return rentNo;
	}

	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
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

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	@Override
	public String toString() {
//		return "Rent [rentNo=" + rentNo + ", bkTitle=" + bkTitle + ", bkAuthor=" + bkAuthor + ", rentDate=" + rentDate
//				+ "]";
		return "대여번호 : " + rentNo + ", 책 제목 : " + bkTitle + ", 책 저자 : " + bkAuthor + ", 대여 날자 : " + rentDate
				+ ", 반납 기한 : " + lastDate;
	}

}
