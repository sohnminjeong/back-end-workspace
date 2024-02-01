package com.kh.example.practice2.controller;
// controller에서는 문자(글자) 관련은 배제, only 코드만!

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2.compare.ArtistDescending;
import com.kh.example.practice2.compare.TitleAscending;
import com.kh.example.practice2.model.Song_t;

public class SongController_t {

	private ArrayList<Song_t> list = new ArrayList<>();
	// controller에서 사용 할 것이기 때문에 private으로 걸어두기
	Song_t song = new Song_t();
	
	// 싱글톤 패턴(Singleton Pattern)
	// - 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴 
	
	//규칙 - 1. 생성자는 private으로 
	private SongController_t() {}
	
	// 2. 유일한 객체를 담을 static 변수 
	private static SongController_t/*(클래스타입)*/ instance;
	
	// 3. 객체를 반환하는 static 메서드 
	public static SongController_t getInstance() {
		if(instance == null) instance = new SongController_t();
		return instance;
	}
	

	public boolean addLastList(Song_t song) {
		if (!song.getTitle().equals("") && !song.getArtist().equals("")) {
			return list.add(song);
			// add는 return 타입이 boolean 이기때문에 void 대신 boolean 으로 맞추고
			// return 값 지정. => Application에서도 addLastList()를 boolean으로 지정!
		}
		return false;
	}

	public boolean addFirstList(Song_t song) {
		if (!song.getTitle().equals("") && !song.getArtist().equals("")) {
			list.add(0, song);
			return true;
		}
		return false;
	}

	public ArrayList<Song_t> printAll() {
		return list;
	}

	public Song_t searchSong(String title) {
		for (Song_t song : list) {
			if (song.getTitle().contains(title)) {
				return song;
			}
		}
		return null;
	}

	
	public Song_t removeSong(String title) {
		for (Song_t song : list) {
			if (song.getTitle().equals(title)) {
				return list.remove(list.indexOf(song)); // remove는 인덱스와 객체 -> 두 가지 타입으로 삭제 가능
			}
		}
		return null;
	}

	
	public Song_t updateSong(String search, Song_t update) {
		for (Song_t song : list) {
			if (song.getTitle().equals(search)) {
				return list.set(list.indexOf(song), update);
			}
		}
		return null;
	}

	public ArrayList<Song_t> ascTitle() {
		ArrayList<Song_t> cloneList = (ArrayList<Song_t>) list.clone();
		// clone으로 list복사해서 새로운 리스트 생성! -> 새로운 리스트로 배열 진행! (원본 list는 바뀌지않음 - 깊은 복사)
		Collections.sort(cloneList, new TitleAscending());
		return cloneList;
		
	}

	public ArrayList<Song_t> descArtist() {
		ArrayList<Song_t> cloneList1 = (ArrayList<Song_t>) list.clone();
		Collections.sort(cloneList1, new ArtistDescending());
		return cloneList1;
	}
}
