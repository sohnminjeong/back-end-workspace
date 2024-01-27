package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.example.practice2.controller.SongController;
import com.kh.example.practice2.model.Song;

public class Application {

	Scanner sc = new Scanner(System.in);
	Song song = new Song();
	ArrayList<Song> songList = new ArrayList<>();
	SongController scon = new SongController();

	public static void main(String[] args) {
		Application a = new Application();
		a.mainMenu();

	}

	public void mainMenu() {

		boolean check = true;
		while (check) {
			try {
				System.out.println("==== 메인 메뉴 ====");
				System.out.println("1. 마지막 위치에 곡 추가");
				System.out.println("2. 첫 위치에 곡 추가");
				System.out.println("3. 전체 곡 목록 출력");
				System.out.println("4. 특정 곡 검색");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 특정 곡 수정");
				System.out.println("7. 곡 명 오름차순 정렬");
				System.out.println("8. 가수 명 내림차순 정렬");
				System.out.println("9. 종료");
				System.out.print("메뉴 번호 입력 : ");
				int num = Integer.parseInt(sc.nextLine());

				switch (num) {
				case 1:
					backAdd();
					break;
				case 2:
					frontAdd();
					break;
				case 3:
					list();
					break;
				case 4:
					search();
					break;
				case 5:
					delete();
					break;
				case 6:
					modify();
					break;
				case 7:
					titleArray();
					break;
				case 8:
					singerArray();
					break;
				case 9:
					check = false;
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못입력하셨습니다.");
			}

		}
	}

	public void backAdd() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();

		
		System.out.println(scon.backAdd(title, singer));

	}

	public void frontAdd() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();	
		
		System.out.println(scon.frontAdd(title, singer));
	}

	public void list() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		scon.list();
	}

	public void search() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
	
		System.out.println(scon.search(title));
	}
	
	
	public void delete() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();

		System.out.println(scon.delete(title));
	}

	
	public void modify() {
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡 명 : ");
		String sTitle = sc.nextLine();
		
		System.out.print("수정할 곡 명 : ");
		String mTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String mSinger = sc.nextLine();
		
		System.out.println(scon.modify(sTitle, mTitle, mSinger));
	
	}

	public void titleArray() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		scon.titleArray();
	}
		

	public void singerArray() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
		System.out.println("아직입니다요~~~ 로딩중이에요~~~ 기다려주세요~~~~~:)");
	
	}
}
