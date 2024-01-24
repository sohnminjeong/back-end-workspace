// 1) 책을 여러권 대여할 수 있도록! -> 배열 이용~
// tab으로 들여쓰기를 한 횟수가 5댑스까지 들어감 -> 댑스 많은 것 : 가독성 떨어지는 코드!  -> 가독성 : 객체를 쓰는 이유!
// 2) 다른 메서드 mainPage, rentBook 만들어서 댑스 줄이기
// 3) 객체 만들기 


package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.practice.model_p.Member;

public class ApplicationPrac2 {
	
	// 다른 메서드에서도 해당 변수 사용하려면 전역변수로 돌려서 사용해야 함.
	Scanner sc = new Scanner(System.in);
	
	Member m = new Member();
	//m 클래스에 있는 정보 사용할려면 선언해야 함!
	
	// [한 사람에 대한 정보를 담고 있는 변수들 -> model 클래스를 만든 이유 : 관련 있는 것은 묶은 것!(캡슐화)
	// name, age, coupon, bookList[]는 model_p.m 클래스에 들어가 있음]
	
	int num = -1;

	public static void main(String[] args) {
		// static에서는 작업 안하는 것 추천
		ApplicationPrac2 app = new ApplicationPrac2();
		app.mainMenu();
	}

	
	public void mainMenu() {

		System.out.print("이름 : ");
		m.setName(sc.nextLine());
//		m.name = sc.nextLine();    // setter

		System.out.print("나이 : ");
		m.setAge(Integer.parseInt(sc.nextLine()));
//		m.age = Integer.parseInt(sc.nextLine()); // setter

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
				//rentBook();
				break;
			case 3:
				check = false;
				break;
			}
		}
	}

	public void myPage() {
		/*System.out.println("Member[name =" + m.getName() + ", age=" + m.getAge() + ", " + 
		"cookCoupon=" + m.getCoupon() + ", bookList=" + Arrays.toString(m.getBookList()) + "]");*/   // getter
		//System.out.println(m.toString());
		// toString()은 문자열을 반환! 즉 '문자열 그 자체'이기 때문에 System.out.print() 필요함!
		System.out.println(m);
		// toString()자체가 호출 시 재정의를 한 것을 의미! 메서드 자체가 그대로 출력된다는 의미이기 때문에 toString()부분을 지우고 변수명(m)만 도출 가능 
	}
/*	
	public void rentBook() {
		System.out.println("0번 도서 : Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]");
		System.out.println("1번 도서 : Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]");
		System.out.println("2번 도서 : Book [title=원피스 107] / AniBook [accessAge = 19]");
		System.out.println("3번 도서 : Book [title=주술회전 24] / AniBook [accessAge = 15]");
		System.out.print("대여할 도서 번호 선택 : ");
		num = Integer.parseInt(sc.nextLine());

		// getter를 이용해서 기존 책 리스트를 일단 가지고 와야 함!
		// 가지고 온 걸 변수에 담고 이 변수로 비교 
		// m.getBookList() -> newBookList통해 변경됨 -> m.setBookList(newBookList)통해 저장 
		String[] newBookList = m.getBookList();
		// prac3에서 Member 클래스에 bookList의 문자형을 String 에서 Book[]으로 바꿔서 나타난 에러!
		for (int i = 0; i < newBookList.length; i++) {   // getter
			
			if (newBookList[i] == null) { // getter	
				// 대여 가능 공간 만남!
				if (num == 0) { 
					// m.coupon++;  // setter + getter
					// -> 새로운 쿠폰 값(setter) = 기존 쿠폰 값(getter) + 1;
					m.setCoupon(m.getCoupon()+1);
					newBookList[i] = "Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]";
				} else if (num == 1) {
					newBookList[i] = "Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]";
				} else if (num == 2 && m.getAge() >= 19) { // getter
					newBookList[i] = "Book [title=원피스 107] / AniBook [accessAge = 19]";
				} else if (num == 3 && m.getAge() >= 15) { // getter
					newBookList[i] = "Book [title=주술회전 24] / AniBook [accessAge = 15]";
				}

				break;
			}
	
		}
		// 새로 배열된 책리스트가 setter통해 bookList로 들어감 
		m.setBookList(newBookList);
		// prac3에서 Member 클래스에 bookList의 문자형을 String 에서 Book[]으로 바꿔서 나타난 에러!
		if (num == 2 && m.getAge() < 19 || num == 3 && m.getAge() < 15) { // getter
			System.out.println("나이 제한으로 대여 불가능입니다.");
		} else {
			System.out.println("성공적으로 대여되었습니다.");
		}
	}
*/	
}
