package com.kh.variable;

import java.util.Scanner;

public class D_Scanner {
	
	/*
	 * Scanner 
	 * - 화면(Console)으로부터 데이터를 "입력"받는 클래스 
	 * 
	 * 1. import java.util.Scanner; 추가 
	 * 
	 * 2. Scanner 객체 생성 
	 * 	  Scanner sc = new Scanner(System.in);
	 * 
	 * 3. Scanner 메서드 사용
	 * 	  입력값이 
	 * 	  - 문자열 일 때 : sc.next();   - 공백이 있을 경우 공백 이전까지
	 * 					sc.nextLine();  - 공백 포함 엔터 전까지   --> 얘만 사용하는 것을 권장 
	 *    - 정수 일 때 : sc.nextInt();
	 *    - 실수 일 때 : sc.nextFloat();, sc.nextDouble();
	 * */
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름은 무엇입니까? > ");
		String name = sc.next();  // enter 처리 X
		sc.nextLine();  // enter 처리위해 사용됨 
		
		System.out.print("당신의 집은 어디십니까? > ");
		String addr = sc.nextLine();
		
		System.out.print("당신의 나이는 몇살입니까? > ");
		int age = sc.nextInt();  // enter 처리 X 
		
		System.out.print("당신의 키는 몇입니까? (소수점 첫째 자리까지 입력하세요.) > ");
		double height = sc.nextDouble();  
		// enter 처리 X (enter 처리 안하는 것 다음 또 enter 처리 안하는 것이 만나면 nextLine만나기 전까지 남겨둠)
		sc.nextLine();
		
		
		System.out.print("당신의 성별은 무엇입니까? (남/여) > ");
		String input = sc.nextLine();
		char gender = input.charAt(0);    // input변수의 값의 0번째 인덱스 한글자만 gender 변수로 출력 
		
		/*
		System.out.println("당신의 이름은 " + name + "이고 사는 곳은 " + addr + ", 나이는 " + age 
				+ "살, 키는 " + height + "cm, 성별은 " + gender +" 입니다.");
				*/
		
		// --> printf 변경!
		
		// System.out.printf("출력하고자하는형식(포맷)", 출력하고자하는 값, 값, ...)
				// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행 
				
				/*
				 * 포맷으로 쓰이는 키워드
				 * %d : 정수
				 * %f : 실수
				 * %c : 문자 
				 * %s : 문자열 (문자도 가능) 
				 * */
		
		System.out.printf("당신의 이름은 %s이고 사는 곳은 %s, 나이는 %d살, 키는 %.1fcm, 성별은 %c 입니다.",
				name, addr, age, height, gender);
	}

}
