package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
    
    Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
				OperatorPractice o = new OperatorPractice();
				// o.method1();
				// o.method2();
				// o.method3();
				// o.method4();
				// o.method5();
				 o.method6();
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 키보드로 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.print("인원 수 > ");
		int person = sc.nextInt();
		
		System.out.print("연필 개수 > ");
		int pensil = sc.nextInt();
		sc.nextLine();
		
		int person_pensil = pensil / person ;
		int rest = pensil % person;
		
		System.out.println("1인당 연필 개수 : " + person_pensil);
		System.out.println("남은 연필 개수 : " + rest);
		
		/* [강사님]
		System.out.print("인원 수 : ");
		int person = sc.nextInt();
		System.out.print("연필 개수 : ");
		int pencil = sc.nextInt();
		
		System.out.println("1인당 연필 개수 : " + pencil/person);
		System.out.println("남은 연팰 개수 : " + pencil%person); */
		
	}
	
	//키보드로 입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.print("숫자 입력 > ");
		int num = sc.nextInt();
		int result = (num>=100) ? (num/100*100) : 0 ;
	
		 System.out.println(result);
		 
		 // [강사님]
		 System.out.print("숫자 > ");
		 int number = sc.nextInt();
		 System.out.println((num/100) * 100);
		
	}
	
	//3개의 수를 키보드로 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.print("숫자 1 입력 > ");
		int num1 = sc.nextInt();
		
		System.out.print("숫자 2 입력 > ");
		int num2 = sc.nextInt();
		
		System.out.print("숫자 3 입력 > ");
		int num3 = sc.nextInt();
		
		boolean result = (num1 == num2 && num2 == num3);
		
		System.out.println(result);
		
		/* [강사님]
		System.out.print("첫번째 수 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 : ");
		int num2 = sc.nextInt();
		System.out.print("세번째 수 : ");
		int num3 = sc.nextInt();
		
		boolean result = (num1 == num2) && (num2 == num3);
		System.out.println(reuslt);*/
		
	}
	
	//키보드로 입력 받은 하나의 정수가 짝수이면 “짝수다“, 짝수가 아니면 “홀수다“를 출력하세요.
	public void method4() {
		System.out.print("정수 입력 > ");
		int num = sc.nextInt();
		// String result = (num %2 == 0) ? "짝수다" : "홀수다";
		String result = (num == 0) ? "0이다." : (num %2 == 0) ? "짝수다" : "홀수다";
		
		System.out.println(result);
		
		/* [강사님]
		System.out.print("정수 : ");
		int num = sc.nextInt();
		String str = num%2 == 0 ? "짝수다" : "홀수다";
		System.out.println(str); */
	}
	
	//나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method5() {
		System.out.print("나이 입력 > ");
		int age = sc.nextInt();
		String result = (age <= 13) ? "어린이" 
				: (age <= 19) ? "청소년" : "성인";
		System.out.println(result);
		
		/* [강사님]
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "어린이" : age <= 19 ? "청소년" : "성인";
		System.out.println(result); */
	}
	
	//키보드로 사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method6() {
		System.out.print("사과 개수 입력 > ");
		int apple = sc.nextInt();
		
		System.out.print("바구니의 크기(바구니 1개의 들어가는 사과의 개수) 입력 > ");
		int pack = sc.nextInt();

		 int result = apple/pack + ((apple % pack == 0)? 0 : 1);
		
		// int re = apple / pack ;
		// int result = (apple % pack == 0)? re : re+1 ; 
		

		
		System.out.println("필요한 바구니의 수 : " + result);
		
		/* [강사님]
		System.out.print("사과의 개수 : ");
		int apple = sc.nextInt();
		System.out.print("바구니 1개당 들어가는 사과의 개수 : ");
		int count = sc.nextInt();
		
		// 나누어떨어졌을 때는 문제X, 나누어 떨어지지 않았을 때는 +1
		System.out.println(apple/count + (apple/count == 0 ? 0 : 1));*/
	}
	
}