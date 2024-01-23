package com.kh.practice1;

import java.io.IOException;

public class B_Throws {
	
	/*
	 * 리턴타입 메서드명(매개변수, ...) throws 예외클래스1, 예외클래스2, ... {
	 * 
	 * }
	 * 
	 * - main 메서드에서도 throws 키워드로 예외를 떠넘길 수 있지만 결국 JVM이 예외 처리를 하게 된다. --> 비추천! 
	 * 		--> 프로그램 사용자는 프로그램이 알 수 없는 예외 내용을 출력하고 종료되는 것을 좋아하지 않는다.
	 * - 따라서 main 메서드에서 try~catch 블록으로 예외를 최종 처리하는 것이 바람직
	 * */
	
	public static void main(String[] args) {
		// 실행 시 : '클래스가 존재하지 않습니다.'
			try {
				findClass();
				// findClass()에서 받은 에러 처리 -> try~catch!
			} catch (ClassNotFoundException e) {
				System.out.println("클래스가 존재하지 않습니다.");
			}
			
			
			B_Throws b = new B_Throws();
			try {
				b.method1();
//			} catch (ClassNotFoundException | IOException e) {
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("예외가 발생했습니다!");
			}
		
	}
	
	public static void findClass() throws ClassNotFoundException {
		
		Class cla = Class.forName("java.lang.String2");
//		Class cla = Class.forName("com.kh.practice1.A_TryCatch");
		// -> 동일 java project에 있는 것은 가능! 다른 프로젝트 일 경우 불가
		// throw declaration 할 경우 findClass() 뒤에 throw 발생 -> 이 경우엔 윗줄 findClass();에서 에러가 발생(에러를 저기로 던짐)
		// try-catch할 경우 : String2라는 클래스 없기 때문에 에러 발생 
		//Class.forName() : 클래스 찾기 
	}
	
	public void method1() throws ClassNotFoundException, IOException {
		System.out.println("method1() 호출");
		
		method2();
		
		System.out.println("method1() 종료");
	}
	
	public void method2() throws ClassNotFoundException, IOException {
		System.out.println("method2() 호출");
		
		method3();
		
		System.out.println("method2() 종료");
		
	}
	
	public void method3() throws ClassNotFoundException, IOException {
		System.out.println("method3() 호출");
		
		int random = (int) (Math.random() * 2 + 1);
		
		if(random == 1) {
			throw new ClassNotFoundException();
		} else if(random == 2) {
			throw new IOException();
		} 
		
		System.out.println("method3() 종료");
		
	}
}
