//package com.kh.example.practice2.controller;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//import com.kh.example.practice2.model.Song;
//
//public class SongControllers {
//		
//	Song song = new Song();
//	ArrayList<Song> songList = new ArrayList<>();
//	
//
//	public Song search(String title) {
//		boolean check = false;
//		
//		for(int i=0; i<songList.size(); i++) {
//			if(songList.get(i).getTitle().contains(title)) {
//				check = false;
//				return songList.get(i).getSinger() + " - " + songList.get(i).getTitle() + "을(를) 검색 했습니다.";
//			} 
//		}
//		if(!check) {System.out.print("검색할 곡이 목록에 없습니다. 다시 입력해주세요.");	
//		}
//		return "";
//	}
//	
//	public Song delete(String title) {
//
//		boolean check = false;
//		for(int i=0; i<songList.size(); i++) {
//			if(songList.get(i).getTitle().equals(title)) {
//				check = true;
//				String singer = songList.get(i).getSinger();
//				songList.remove(i);
//				return song;
//						//singer + " - " + title + "을(를) 삭제 했습니다.";
//			} 
//		}
//		return null;
////		if(!check) {return "삭제할 곡이 없습니다.";}
////		return "";
//	}
//	
//	public Song modify(String sTitle, String mTitle, String mSinger) {
//		
//		Song song = null;
//		
//		for(int i=0; i<songList.size(); i++) {
//			if(songList.get(i).getTitle().equals(sTitle)) {
//				song = songList.get(i);
//			} 
//		}
//		int idx = songList.indexOf(song);
//		
//		if(idx == -1) {return "수정할 곡이 없습니다";}
//		else {
//			
//			Song update = songList.set(idx, new Song(mTitle, mSinger)); // 변경 전 Song 반환
//			
//			if(update!=null) {
//				return update.getSinger() + " - " + update.getTitle() + "의 값이 변경되었습니다.";
//			} 
//			return "";	
//		}
//	}
//	
//
//}
