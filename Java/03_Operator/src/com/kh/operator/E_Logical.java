package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
	
	/*
	 * 논리 연산자
	 * - 두 개의 논리값을 연산해주는 연산자
	 * - 논리연산한 결과마저 논리값 
	 * 
	 * 논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘다 true일 경우만 결과값이 true
	 * 논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중에 하나라도 true일 경우  결과값이 true
	 * */
	
	public static void main(String[] args) {

		E_Logical e = new E_Logical();
		// e.method1();
		// e.method2();
		e.practice();
	}
	public void method1() {
		
		//사용자가 입력한 정수값이 1부터 100 사이의 값인지 확인
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수값을 입력해주세요 > ");
		int number = sc.nextInt();
		boolean result = 1 <= number && number <= 100;
		
		
		System.out.printf("%d는 1 부터 100 사이의 값인가요? : %b", number, result);
		
	}
	
	public void method2() {
		int number = 10;
		boolean result = false;  // boolean의 초기값 기본은 false
		// --> 변수들 초기화부터 지정하고자 할 때! 
		
		// &&
		// true && true = true
		// true && false = false
		// false && true = false
		// false && false = false
		
		// && 연산자를 기준으로 앞에서 이미 false이기 때문에 굳이 뒤쪽의 연산은 수행하지 않는다 
		result = (number < 5) && (++number > 0); // false && true = false
		
		System.out.println(result);  // false
		System.out.println(number);  // 10
		
		
		// ||
		// true || true = true
		// true || false = true
		// false || true = true
		// false || false = false
		result = (number < 20) || (++number > 0);
		
		System.out.println(result);   // true
		System.out.println(number);   // 10
		
		// 예시 -> 로그인 
	
	}
	
	/* 
	 * 실습 문제
	 * 
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기 
	 * A ~ Z : 65 ~ 90, a ~ z : 97 ~ 122
	 * */
	public void practice() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자값을 입력해주세요 > ");
		String text = sc.nextLine();
		char text1 = text.charAt(0);
		int number = text1;
		 boolean result = (65 <= number && number <= 90) || (97 <= number && number <= 122);
		// boolean result2 = ('A' <= number && number <= 'Z') || ('a' <= number && number <= 'z');
		// boolean result3 = (65 <= text1 && text1 <= 90) || (97 <= text1 && text1 <= 122);
		
		System.out.printf("%s은 알파벳인가요? : %b", text, result);
		

		 // [강사님]
		 // Scanner sc = new Scanner(System.in);
		 // char ch = '\u0000';    // 초기화
		 // boolean result = false;    // 초기화
		 
		 // System.out.print("문자 입력 > ");
		 // ch = sc.nextLine().charAt(0);
		 
		 // result = ('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z');
		 
		 // System.out.println(result);
		 
		
	}
}
