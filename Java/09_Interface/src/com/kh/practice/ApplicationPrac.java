// 도서 1권만 대여
package com.kh.practice;

import java.util.Scanner;

public class ApplicationPrac {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
/*		[반복문]
		- for : 숫자, 횟수, 범위가 정해져 있을 경우 사용
		- while : 조건, 무한루프의 경우 사용
		[조건문]
		- if : 대부분
		- switch : a가 n, m, s와 같다 등 '같다'의 경우에 많이 사용
			-> break; 걸지 않으면 멈추지 않고 다 진행됨 
*/
		int num = -1;
		int coupon = 0;
		// num == 0일때마다 coupon이 1개 추가임으로 밖에서 따로 coupon에 대해서 선언!
		String book = null;
		Boolean check = true;
		while(check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1 :
				// 밑에 반복되는 것이 전부 같기 때문에 조건문 필요x
				System.out.println("Member[name =" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book + "]");
//				if(num == 0) {
//					System.out.println("Member[name =" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book + "]");
//				} else if(num == 1) {
//					System.out.println("Member[name =" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book + "]");
//				} else if(num==2 && age >=19) {
//					System.out.println("Member[name =" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book + "]");
//				} else if(num == 3 && age >= 15) {
//					System.out.println("Member[name =" + name + ", age=" + age + ", cookCoupon=" + coupon + ", book=" + book + "]");
//				} else {
//					System.out.println("Member[name =" + name + ", age=" + age + ", cookCoupon=0, book=" + book + "]");					
//				}
				break;
			case 2 :
				System.out.println("0번 도서 : Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]");
				System.out.println("1번 도서 : Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]");
				System.out.println("2번 도서 : Book [title=원피스 107] / AniBook [accessAge = 19]");
				System.out.println("3번 도서 : Book [title=주술회전 24] / AniBook [accessAge = 15]");
				System.out.print("대여할 도서 번호 선택 : ");
				num = Integer.parseInt(sc.nextLine());
				// num을 case1, 2에서 다 쓸 수 있도록 반복문 밖에서 int num으로 정의하고 case2에서는 num만 작성! -> 그럼 case 1에서도 사용 가능
				if(num==0) {
					coupon++;
					book = "Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]";
				} else if(num == 1) {
					book = "Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]";
				} else if(num == 2 && age >= 19) {
					book = "Book [title=원피스 107] / AniBook [accessAge = 19]";
				} else if(num == 3 && age >= 15) {
					book = "Book [title=주술회전 24] / AniBook [accessAge = 15]";
				}
				
				if(num==2 && age < 19 || num == 3 && age < 15) {
					System.out.println("나이 제한으로 대여 불가능입니다.");
				} else {					
					System.out.println("성공적으로 대여되었습니다.");
				}
				break;
			case 3 :
				check = false;
				break;
			}
		}
		
	}

}
