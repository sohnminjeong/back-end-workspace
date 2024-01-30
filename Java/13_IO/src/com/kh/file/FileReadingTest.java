package com.kh.file;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 문자 기반 스트림 
 * - 문자 데이터를 읽고 출력할 때 사용 
 * - Reader, Writer : 문자 기반 입출력 스트림의 최상위 클래스 
 * 
 * */

public class FileReadingTest {
	
	String fileName = "src/test.txt";
	String outfileName = "src/result.txt";
	
	public static void main(String[] args) {
		FileReadingTest f = new FileReadingTest();
		f.fileSave();
	}

	public void fileSave() {
		//FileWriter를 사용해서 파일을 생성하고 데이터를 문자 단위로 저장하는 로직 
		// 로직 작성 후 실행하고 Java project를 refresh해야 test.txt 파일 생성됨
		//저장 중 file과 관련된 것 = FileWriter
		// IO 관련된 것은 모두 try-catch 잡아야 함으로 try~catch 밖에서 선언
		
		// [자동 자원반납문] : try-with-resource 문을 통해서 사용한 리소스를 자동으로 close()
		try(FileWriter fw = new FileWriter(fileName, true)) {
		// true -> 실행 할 때마다 test.txt에 아래 문구가 반복적으로 계속 추가됨
		// false(기본값) -> 실행 할 때마다 test.txt가 새로고침돼서 반복이 아닌 작성한 문구 한 번만 보임	
			fw.write("IO 재밌나요?\n");
			fw.write("아닌가요 ㅠㅠ?\n");
			fw.write("뭐가 되었든 끝납니다!\n");
			fw.write("오전 수업 끝!");
			 
			fw.flush();  
			
		} catch(IOException e){
			e.printStackTrace();
		}
		
		
		/* [기본]
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fileName);
			
			fw.write("IO 재밌나요?\n");
			fw.write("아닌가요 ㅠㅠ?\n");
			fw.write("뭐가 되었든 끝납니다!\n");
			
			//fw.write 사용 후 반드시 .flush 필요 
			fw.flush();  // 강제로 자료 출력 
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//자원반납
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 */
	}
}
