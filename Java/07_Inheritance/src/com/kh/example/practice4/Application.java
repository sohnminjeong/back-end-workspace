package com.kh.example.practice4;

// MVC 중 V(view) 역할 담당

import java.util.Scanner;

import com.kh.example.practice4.controller.CircleController;
import com.kh.example.practice4.controller.RectangleController;

public class Application {
	
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public static void main(String[] args) {
		
		Application app = new Application();
		app.mainMenu();
		
		
	}
	public void mainMenu() {
		
		boolean check = true;
		while(check) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");    // circleMenu()
			System.out.println("2. 사각형");   // rentanglemenu()
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			// Integer.parseInt(sc.nextLine())으로 할 경우 
			// => 밑에 sc.nextInt를 쓰는 모든 것들을 전부 Integer.parseInt(sc.nextLine())로 바꿔줘야함
			// 하나만 nextint에서 parseInt 할 경우 위에 전부 sc.nextLine();을 대입해야 함 
			// Integer.parseInt(sc.nextLine())
			int select = sc.nextInt();
			switch(select) {
			case 1 :
				circleMenu();
				break;
			case 2 :
				rectangleMenu();
				break;
			case 9 : 
				check = false;
				break;	
		}
		}
	}
	
	public void circleMenu() {
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");    // calCircum()
		System.out.println("2. 원 넓이");   // calcCircleArea()
		System.out.println("9. 메인으로"); 
		System.out.print("메뉴 번호 : ");
		int select = sc.nextInt();
		switch(select) {
		case 1 :
			calcCircum();
			break;
		case 2 :
			calcCircleArea();
			break;
		case 9 : 
			break;	
		}
	}
	
	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 =====");
		System.out.println("1. 사각형 둘레");    // calcPerimeter()
		System.out.println("2. 사각형 넓이");   // calcRectArea()
		System.out.println("9. 메인으로");  
		System.out.print("메뉴 번호 : ");
		int select = sc.nextInt();
		switch(select) {
		case 1 :
			calcPerimeter();
			break;
		case 2 :
			calcRectArea();
			break;
		case 9 : 
			break;	
		}
		
	}
	
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		sc.nextLine();
		System.out.println(cc.calcCircum(x, y, radius));
		
	}
	
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		System.out.println(cc.calcArea(x, y, radius));
	}
	
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int height = sc.nextInt();
		System.out.print("너비 : ");
		int width = sc.nextInt();
		System.out.println(rc.calcPerimeter(x, y, height, width));
	}
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int height = sc.nextInt();
		System.out.print("너비 : ");
		int width = sc.nextInt();
		System.out.println(rc.calcArea(x, y, height, width));
	}
}

