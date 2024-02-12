package com.kh.array.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.array.practice2.controller.Controllers;
import com.kh.array.practice2.model.Mem;

public class App {

	private Scanner sc = new Scanner(System.in);
	private Controllers c = new Controllers();

	public static void main(String[] args) {

		App a = new App();
		a.mainMenu();
	}
	int count = 0;

	public void mainMenu() {
		boolean check = true;
		while (check) {
			System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			System.out.println("현재 등록된 회원 수는 "+count+"명입니다.");
			if(count<3) {
				System.out.println("1. 새 회원 등록");
			}else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				insert();
				break;
			case 2:
				modify();
				break;
			case 3:
				info();
				break;
			case 9:
				check = false;
				break;

			}
		}
	}

	public void insert() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		c.insert(id, name, password, email, gender, age);
		count++;
	}

	public void modify() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이름 : ");
		String modifyName = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String modifyEmail = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String modifyPassword = sc.nextLine();
		c.modify(id, modifyName, modifyEmail, modifyPassword);
		
	}

	public void info() {
		for(Mem person : c.info()) {
			System.out.println(person);
		}
	}

}
