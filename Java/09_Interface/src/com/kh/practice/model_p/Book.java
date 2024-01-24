package com.kh.practice.model_p;

public class Book {
	
	private String title;
	private boolean coupon;
	private int accessAge;
	
	// Member 때(세터, 게터 방식)와 다르게 여기선 생성자 방식 사용해봄!
	public Book(String title, boolean coupon) {
		this.title = title;
		this.coupon = coupon;
	}
	
	public Book(String title, int accessAge) {
		this.title = title;
		this.accessAge = accessAge;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCoupon() {
		// boolean의 경우 getCoupon이 아닌 isCoupon이라고 적힘! (boolean의 특징)
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", coupon=" + coupon + ", accessAge=" + accessAge + "]";
	}	
}
