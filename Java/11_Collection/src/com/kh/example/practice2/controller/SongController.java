package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2.model.Song;

public class SongController {
		
	Song song = new Song();
	ArrayList<Song> songList = new ArrayList<>();
	
	public String backAdd(String title, String singer) {
		
		song.setTitle(title);
		song.setSinger(singer);
		songList.add(new Song(title, singer));
		
		if (title == "" || singer == "") return "추가 실패, 재입력 바랍니다.";	
		else return "추가 성공";

	}
	
	public String frontAdd(String title, String singer) {
		
		song.setTitle(title);
		song.setSinger(singer);
		songList.add(0, new Song(title, singer));
		
		if (title == "" || singer == "") return "추가 실패, 재입력 바랍니다.";	
		else return "추가 성공";
	}
	
	public void list() {
		for(Song i : songList) {
			System.out.println(i);
		}
		
	}

	public String search(String title) {
		boolean check = false;
		
		for(int i=0; i<songList.size(); i++) {
			if(songList.get(i).getTitle().contains(title)) {
				check = false;
				return songList.get(i).getSinger() + " - " + songList.get(i).getTitle() + "을(를) 검색 했습니다.";
			} 
		}
		if(!check) {System.out.print("검색할 곡이 목록에 없습니다. 다시 입력해주세요.");	
		}
		return "";
	}
	
	public String delete(String title) {

		boolean check = false;
		for(int i=0; i<songList.size(); i++) {
			if(songList.get(i).getTitle().equals(title)) {
				check = true;
				String singer = songList.get(i).getSinger();
				songList.remove(i);
				return singer + " - " + title + "을(를) 삭제 했습니다.";
			} 
		}
		if(!check) {return "삭제할 곡이 없습니다.";}
		return "";
	}
	
	public String modify(String sTitle, String mTitle, String mSinger) {
		
		Song song = null;
		
		for(int i=0; i<songList.size(); i++) {
			if(songList.get(i).getTitle().equals(sTitle)) {
				song = songList.get(i);
			} 
		}
		int idx = songList.indexOf(song);
		
		if(idx == -1) {return "수정할 곡이 없습니다";}
		else {
			
			Song update = songList.set(idx, new Song(mTitle, mSinger)); // 변경 전 Song 반환
			
			if(update!=null) {
				return update.getSinger() + " - " + update.getTitle() + "의 값이 변경되었습니다.";
			} 
			return "";	
		}
	}
	

	public void titleArray() {
	
		Collections.sort(songList);
		for(Song i : songList) {
			System.out.println(i);
		}
		
	}
}
