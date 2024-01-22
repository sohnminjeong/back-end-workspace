package com.kh.practice;

//import java.util.Arrays;
import java.util.Scanner;

import com.kh.practice.controller.LibraryController;
//import com.kh.practice.model.Book;

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
		
		lc.mainMenu(name, age);
		
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
		System.out.println(lc.myPage());
	}
	
	public void bookRental () {

		lc.bookRental();
		System.out.print("대여할 도서 번호 선택 : ");
		int bkNum = Integer.parseInt(sc.nextLine());
		
		lc.bookRentalIf(bkNum);
		
	}
}



