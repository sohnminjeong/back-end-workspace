package com.kh.test6;

import java.util.Scanner;

import com.kh.test6.model.Food;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private Food food = new Food();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.menuList();
	}

	public void menuList() {

		boolean check = true;
		while (check) {
			System.out.println("=== 음식 메뉴 리스트 ===");
			System.out.println("1. 음식 추가");
			System.out.println("2. 음식 정보");
			System.out.println("3. 음식 삭제");
			System.out.println("4. 프로그램 종료");
			System.out.print("번호 선택 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				info();
				break;
			case 3:
				delete();
				break;
			case 4:
				check = false;
				break;
			}

		}
	}

	public void add() {
		System.out.print("추가할 음식 입력 : ");
		String name = sc.nextLine();
		food.setName(name);
		System.out.print("칼로리 입력 : ");
		int kcal = Integer.parseInt(sc.nextLine());
		food.setKcal(kcal);
		System.out.println("음식 정보가 추가 되었습니다.");
	}

	public void info() {
		System.out.println(food.toString());
	}

	public void delete() {
		System.out.print("삭제하고 싶은 음식 선택 : ");
		String name = sc.nextLine();
		if(food.getName().equals(name)) {
			System.out.println(food.toString()+"가 삭제되었습니다.");
			food.setName(null);
			food.setKcal(0);
		} else {
			System.out.println("다시 입력해주세요.");
		}
	}

}
