package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.example.practice2.model.Song;

public class Application {

	Scanner sc = new Scanner(System.in);
	Song song = new Song();
	ArrayList<Song> songList = new ArrayList<>();

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
		song.setTitle(title);
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		song.setSinger(singer);
		
		songList.add(new Song(title, singer));
		

		if (title == "" || singer == "") {
			System.out.println("추가 실패, 재입력 바랍니다.");
			backAdd();
		} else {
			System.out.println("추가 성공");
		}
	}

	public void frontAdd() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		song.setTitle(title);
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		song.setSinger(singer);
		
		songList.add(0, new Song(title, singer));

		if (title == "" || singer == "") {
			System.out.println("추가 실패, 재입력 바랍니다.");
			frontAdd();
		} else {
			System.out.println("추가 성공");
		}
	}

	public void list() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		for(Song i : songList) {
			System.out.println(i);
		}
	}

	public void search() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.println("검색할 곡 명 : ");
		String title = sc.nextLine();
		
		for(int i=0; i<songList.size(); i++) {
			if(songList.get(i).getTitle().contains(title)) {
				System.out.println(songList.get(i).getSinger() + " - " + title + "을(를) 검색 했습니다.");
			} 
		} 
	}
	
	
	public void delete() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		boolean check = false;
		for(int i=0; i<songList.size(); i++) {
			if(songList.get(i).getTitle().equals(title)) {
				System.out.println(songList.get(i).getSinger() + " - " + title + "을(를) 삭제 했습니다.");
				songList.remove(i);
				check = true;
			} 
		}
		if(!check) {System.out.println("삭제할 곡이 없습니다.");}
		
	}

	
	public void modify() {
		System.out.println("****** 특정 곡 수정 ******");
		System.out.print("검색할 곡 명 : ");
		String sTitle = sc.nextLine();
		
		Song song = null;
		
		for(int i=0; i<songList.size(); i++) {
			if(songList.get(i).getTitle().equals(sTitle)) {
				song = songList.get(i);
			} 
		}
		
		int idx = songList.indexOf(song);
		
		/*
		String lastSinger = "";
		boolean check = false;
		for(int i=0; i<songList.size(); i++) {
			if(songList.get(i).getTitle().equals(sTitle)) {
				lastSinger = songList.get(i).getSinger();
				check = true;
			} 
		}*/
		
		System.out.print("수정할 곡 명 : ");
		String mTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String mSinger = sc.nextLine();
		
		
		Song update = songList.set(idx, new Song(mTitle, mSinger)); // 변경 전 Song 반환
		
		if(update!=null) {
			System.out.println(update.getSinger() + " - " + update.getTitle() + "의 값이 변경되었습니다.");
		} else {
			System.out.println("검색할 곡 명이 없습니다.");
		}
		
			
		/*
		if(check) {
			for(int i=0; i<songList.size(); i++) {
				if(songList.get(i).getTitle().equals(sTitle)) {
					songList.get(i).setTitle(mTitle) ;
					songList.get(i).setSinger(mSinger); 
				} 
			}
			System.out.println(lastSinger + " - " + sTitle + "의 값이 변경되었습니다.");
		} else {
			System.out.print("검색할 곡 명이 없습니다.");
		}
		*/
		
		
	}

	public void titleArray() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		Collections.sort(songList);
		for(Song i : songList) {
			System.out.println(i);
		}
		
	}

	public void singerArray() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
//		Collections.sort(songList);
		System.out.println("아직입니다요~~~ 로딩중이에요~~~ 기다려주세요~~~~~:)");
		
	}
}
