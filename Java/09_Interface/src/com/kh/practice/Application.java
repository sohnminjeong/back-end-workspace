package com.kh.practice;

import java.util.Scanner;

import com.kh.practice.controller.LibraryController;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	LibraryController lc = new LibraryController();
	
	
	public static void main(String[] args) {
		Application a = new Application();
		
		a.mainMenu();
		
	
	}
	
	public void mainMenu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
//		lc.mainMenu(name, age, cookCoupon, book);
		
		
		Boolean check = true;
		while(check) {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.print("메뉴 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		switch(num) {
		case 1 : 
			myPage();
			break;
		case 2 : 
			bookRental();
			break;
		case 3 : 
			check = false;
			break;
			}
		}
	}
	
	public void myPage() {
		lc.mem();
	}
	
	public void bookRental () {
		
	}
	


}
