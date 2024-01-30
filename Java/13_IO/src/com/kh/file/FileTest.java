package com.kh.file;

import java.io.File;
import java.io.IOException;

/*
 * File 클래스
 * - 파일과 디렉토리 다루는데 사용되는 클래스 
 * */

public class FileTest {

	public static void main(String[] args) {

		File file = new File("src/test.txt");
		
		// 파일명 가져오는 메서드 : .getName()
		System.out.println("파일명 : " + file.getName());
		// 파일 절대경로 가져오는 메서드 : .getAbsolutePath()
		System.out.println("절대 경로 : " + file.getAbsolutePath());
		// 파일 상대경로 가져오는 메서드 : .getPath()
		System.out.println("상대 경로 : " + file.getPath());
		// 파일 용량 가져오는 메서드 : .length()
		System.out.println("파일 용량 : " + file.length());
		// 파일 존재 여부 확인 메서드(true/false) : .exists()
		System.out.println("파일 존재 여부 : " + file.exists());   // true
		// 파일 자체 여부 - 이것이 파일인지 (true/false) : .isFile()
		System.out.println("파일 여부 : " + file.isFile());  // true
		// 파일 디렉토리 여부 (true/false) : .isDirectory()
		System.out.println("디렉토리 여부 : " + file.isDirectory());  // false
		
		// 만약 존재하지 않는 경로를 제시하면 IOException 발생
		File newFile = new File("src/temp/test.txt");  //해당 폴더도 없고 파일도 없음
		//System.out.println(newFile.exists());  // false
		
		try {
			// 존재하지 않는 폴더부터 만들기			
			File tempDir = new File("src/temp");
			if(!tempDir.isDirectory()) {
				// 폴더 존재하지 않는다면 만들기
				tempDir.mkdir();
			}
			if(!newFile.exists()) {
				// 파일이 존재하지 않는 경우 생성하겠다!
				newFile.createNewFile();
			}
			// 실행하면 temp폴더와 test.txt 파일이 생성됨 
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
