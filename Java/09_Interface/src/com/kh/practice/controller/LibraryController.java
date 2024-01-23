package com.kh.practice.controller;

//import java.util.Arrays;

import com.kh.practice.model.*;
//import com.kh.practice.model.Book;
//import com.kh.practice.model.Member;

public class LibraryController {
		
	private Member member = null;
	private Book[] bookList = new Book[4];

	
	// 인스턴스 초기화 블록 : 객체 생성 시 실행되는 블록 
	{
		bookList[0] = new CookBook("맛있는 지중해식 레시피", true);
		bookList[1] = new CookBook("카페 샌드위치 마스터 클래스", false);
		bookList[2] = new AniBook("원피스 107", 19);
		bookList[3] = new AniBook("주술회전 24", 15);
	}
	
	public void mainMenu(String name, int age) {
		
		member = new Member();
		member.setName(name);
		member.setAge(age);
	}
	
	public Member myPage() {
		return member;
	}
	
	
	public void bookRental() {
		for(int i=0; i<bookList.length; i++) {
			System.out.println(i+"번 도서 : " + bookList[i]);
		}
	}
	
	
	// 대여 시 조건 : 성공적 대여 / 나이 제한 / coupon+1
	// Controller는 백 단이기 때문에 void(화면 단 용)보다는 String-return으로 표현하는 것이 더 좋음! (조건도 화면에서 거는 것이 best) 
	public String bookRentalIf(int bkNum) {
		 switch(bkNum) {
		 case 0 : 
			 member.setCookCoupon(member.getCookCoupon()+1);
			 // 도서 0번이 coupon[true]여서 갖고있던 쿠폰에서 1개 증가하여 set 
			 // -> 이것이 member에 저장됨으로 추후 mypage 호출 시 변경되어 산출됨
			 member.setBook(bookList[bkNum]);
			 // 대여에 성공한 도서는 bookList[bkNum]이 member에서 set되며 이것이 추후mypage 호출 시 반영됨
			 return "성공적으로 대여되었습니다.";
		 case 1 :
			 member.setBook(bookList[bkNum]);
			 return "성공적으로 대여되었습니다.";
		 case 2 : case 3 :
			 if(((AniBook) bookList[bkNum]).getAccessAge() > member.getAge()) {
				 return "나이 제한으로 대여 불가능입니다.";
				} else {
					member.setBook(bookList[bkNum]);
					return "성공적으로 대여되었습니다.";
					}
		 default : 
			 return "번호가 없는 도서입니다.";
		 }
		
	}
	
}
