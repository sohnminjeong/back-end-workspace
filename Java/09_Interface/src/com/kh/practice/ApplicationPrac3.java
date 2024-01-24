// 1) 책을 여러권 대여할 수 있도록! -> 배열 이용~
// tab으로 들여쓰기를 한 횟수가 5댑스까지 들어감 -> 댑스 많은 것 : 가독성 떨어지는 코드!  -> 가독성 : 객체를 쓰는 이유!
// 2) 다른 메서드 mainPage, rentBook 만들어서 댑스 줄이기
// 3) prac2 : member 객체 만들고 이에 맞춰 수정
// 4) prac3 : book객체 만들고 이에 맞춰 수정


package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.practice.model_p.Book;
import com.kh.practice.model_p.Member;

public class ApplicationPrac3 {
	
	Scanner sc = new Scanner(System.in);
	
	Member m = new Member();
	
	int num = -1;

	// 책에 대한 정보!(처음부터 필요함)
	Book[] books = {
		// 생성자 활용! setter와 같은 역할
		new Book("맛있는 지중해식 레시피", true),
		new Book("카페 샌드위치 마스터 클래스", false),
		new Book("원피스 107", 19),
		new Book("주술회전 24", 15)				
	};
	
	
	public static void main(String[] args) {
		
		ApplicationPrac3 app = new ApplicationPrac3();
		app.mainMenu();
	}

	
	public void mainMenu() {

		System.out.print("이름 : ");
		m.setName(sc.nextLine());


		System.out.print("나이 : ");
		m.setAge(Integer.parseInt(sc.nextLine()));


		Boolean check = true;

		while (check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());

			
			
			switch (menu) {
			case 1:
				myPage();
				break;
			case 2:
				rentBook();
				break;
			case 3:
				check = false;
				break;
			}
		}
	}

	public void myPage() {
		System.out.println(m);	
	}
	
	
	
	public void rentBook() {
		
		for(int index=0; index < books.length; index++ ) {
			System.out.println(index + "번 도서 : " + books[index]);
		}
		System.out.print("대여할 도서 번호 선택 : ");
		num = Integer.parseInt(sc.nextLine());

		Book selectBook = books[num];   // 사용자가 대여하고 싶어 선택한 책! -> 대여할 도서책 받아오기
		
		Book[] newBookList = m.getBookList(); // 멤버가 이미 가지고 있는 책 중에서의 배열 
		
		
		
		for (int i = 0; i < newBookList.length; i++) {  
			
			if (newBookList[i] == null) { 
				// 도서가 3권 다 대여된 경우 '대여 불가'는 null이 없는 경우로 조건!
				if(selectBook.isCoupon()) {	
				// if 뒤 ()안은 true가 기본이기 때문에 == true 따로 적지 않아도 됨! 
				// 내가 대여할 책의 쿠폰이 true 인 경우!
					m.setCoupon(m.getCoupon()+1); // 쿠폰+1
				}
				
				if(m.getAge() >= selectBook.getAccessAge()) {
				// 나의 나이가 대여할 책의 접근 제한 나이보다 많은 경우!
					newBookList[i] = books[num];  // 대여
				}
					
				break;
			}
	
		}
	
		m.setBookList(newBookList);
		
		if (m.getAge() < selectBook.getAccessAge()) { 
			System.out.println("나이 제한으로 대여 불가능입니다.");
		} else {
			System.out.println("성공적으로 대여되었습니다.");
		}
	}
}
