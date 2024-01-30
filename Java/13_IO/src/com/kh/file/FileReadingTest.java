package com.kh.file;

import java.io.*;

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
		//f.fileSave();
		//f.fileRead();
		//f.method1();
		f.method2();
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
	
	public void fileRead() {
		// FileReader를 사용해서 파일에서 데이터를 문자 단위로 읽어온다.
		try(FileReader fr = new FileReader(fileName)) {
			// 보조 스트림을 붙여서 한 줄 단위로 가져오기
			int data = 0;
			while((data = fr.read()) != -1) {
				System.out.println((char)data);  //그냥(data)만 할 경우 -> 숫자값으로 나옴!
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	// 파일에 있는 내용을 읽어서 한 줄 단위로 콘솔에 출력하는 로직 
	// 보조 스트림 BufferedReader : 버퍼(char[])에 데이터가 쌓이기를 기다렸다가 꽉 차게 될 시 한꺼번에 보냄 
	public void method1() {
	
		try(
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				
				) {
			String line = "";
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 파일에 있는 내용을 읽어서 또다른 파일로 출력하는 로직
	public void method2() {
		
		/*
		 * BufferedReader, BufferedWriter : 입출력 효율을 높이기 위해 버퍼(char[])를 사용하는 보조스트림
		 * --> 라인(line) 단위로 입출력이 편리하다. (Buffered 사용 안할 시 한 단어씩 출력됨)
		 * 
		 * PrintWriter : 프린터와 유사하게 출력하는 print(), println() 메서드를 가지고 있는 보조스트림
		 * */
		
		try(
			// 읽어오는 것에는 Reader가 필요하며 기반 스트림부터 먼저 실행!
			FileReader fr = new FileReader(fileName);
			// 이 후 보조 스트림 BufferedReader 호출하고 ()안에 기반 스트림 넣기 	
			BufferedReader br = new BufferedReader(fr);
			//[한줄로도 작성 가능] : BufferedReader br = new BufferedReader(new FileReader(fileName));
			// 뒤에서부터 앞으로 작성! : 파일명 -> 기반 스트림 Reader -> 보조 스트림 Buffered
			FileWriter fw = new FileWriter(outfileName, true);
			// FileWriter에 true 붙일 경우 -> 실행 할 때마다 추가됨!
			//BufferedWriter bw = new BufferedWriter(fw);
			//[한줄작성] BufferedWriter bw = new BufferedWriter(new FileWriter(outfileName));
			PrintWriter pw = new PrintWriter(fw);	
				){
			
			String line = "";
			while((line = br.readLine()) != null) {
				//System.out.println(line);
				//bw.write(line);
				//bw.newLine(); // 라인 구분자(개행문자)를 출력
				pw.println(line);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
