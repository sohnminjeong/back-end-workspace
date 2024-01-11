package com.kh.condition;

import java.util.Scanner;

public class A_If {

	Scanner sc = new Scanner(System.in);

	/*
	 * if문
	 * 
	 * if(조건식){ 조건식이 참(true)일 때 실행 }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 * 
	 */

	public void method1() {

		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		System.out.print("성적 입력 > "); // 권장
		int score = Integer.parseInt(sc.nextLine());

		if (score >= 60) {
			System.out.println("합격입니다");
		}

		if (score >= 60)
			System.out.println("합격입니다"); // 한 줄만 들어갔을 때는 유용!
		// 중괄호 생략도 가능! -> 비추천

		if (score >= 60)
			System.out.println("합격입니다");
		System.out.println("축하합니다"); // if문 바깥에 있는 걸로 인식
	}

	/*
	 * if-else문
	 * 
	 * if(조건식) { 조건식이 참(true)일 때 실행 } else { 조건식이 거짓(false)일 때 실행 }
	 */

	public void method2() {
		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		// 아니면 "불합격입니다"를 출력
		System.out.print("성적 입력 > "); // 권장
		int score = Integer.parseInt(sc.nextLine());

		if (score >= 60) {
			System.out.println("합격입니다");
		} else {
			System.out.println("불합격입니다");
		}

		// 삼항연산자
		String result = score >= 60 ? "합격입니다" : "불합격입니다";
		System.out.println(result);
	}

	public void method3() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다"를 출력
		System.out.println("이름 입력 > ");
		String name = sc.nextLine();

		// System.out.println("name의 주소값 : " + System.identityHashCode(name)); // 밑의 값과
		// 다름
		// System.out.println("본인이름의 주소값 : " + System.identityHashCode("손민정"));
		// System.out.println(name == "손민정"); // false
		// String -> 참조형 변수 (클래스 변수)는 주소값을 저장!
		// System.out.println(name.equals("손민정")); // true

		if (name.equals("손민정")) {
			System.out.println("본인이다.");
		} else {
			System.out.println("본인이 아니다.");
		}
		;
	}

	public void method4() {

		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수" 출력
		System.out.print("숫자 입력 > ");
		int num = Integer.parseInt(sc.nextLine());

		// 삼항연산자
		String result = num > 0 ? "양수" : num == 0 ? "0이다" : "음수";
		System.out.println(result);

		// else if 사용

		if (num > 0) {
			System.out.println("양수");
		} else if (num == 0) {
			System.out.println("0이다");
		} else {
			System.out.println("음수");
		}

		/*
		 * if (num > 0) { System.out.println("양수"); } else { if(num == 0) { // if문은 중첩
		 * 가능! System.out.println("0이다"); } else { System.out.println("음수"); } }
		 */

		/*
		 * if-else if-else문
		 * 
		 * if(조건식1) { 조건식1이 참(true)일 때 실행 } else if(조건식2) { 조건식1이 거짓(false)이면서 조건식2이
		 * 참(true)일 때 실행 } else { 조건식1, 조건식2 모두 거짓(false)일 때 실행 }
		 * 
		 * - else if 수는 제한이 없다
		 * 
		 */
	}

	public void method5() {

		System.out.print("숫자 입력 > ");
		int number = Integer.parseInt(sc.nextLine());

		// if~else --> if~else if~else로 변경!
		if (number > 0) {
			System.out.println("양수");
		} else if (number == 0) {
			System.out.println("0이다");
		} else {
			System.out.println("음수");
		}

	}

	// [실습 문제]
	/*
	 * 1. 사용자에게 점수(0~100)를 입력받아서 점수별로 등급을 출력 - 90점 이상은 A 등급 - 90점 미만 80점 이상은 B 등급 -
	 * 80점 미만 70점 이상은 C 등급 - 70점 미만 60점 이상은 D 등급 - 60점 미만 F 등급
	 */

	public void practice1() {
		System.out.print("점수(0~100) 입력 > ");
		int score = Integer.parseInt(sc.nextLine());

		String grade = "";
		
		if (score >= 90) {
			grade = "A";
			//System.out.println("A 등급");
		} else if (score >= 80) {
			grade = "B";
			//System.out.println("B 등급");
		} else if (score >= 70) {
			grade = "C";
			//System.out.println("C 등급");
		} else if (score >= 60) {
			grade = "D";
			//System.out.println("D 등급");
		} else {
			grade = "F";
			//System.out.println("F 등급");
		}
		 
		System.out.println(grade);
	}

	/*
	 * 2. 세 정수를 입력했을 때 짝수만 출력
	 * 
	 * num1 입력 > 3 num2 입력 > 4 num3 입력 > 6 4 6
	 */

	public void practice2() {
		System.out.print("정수1 입력 > ");
		int num1 = Integer.parseInt(sc.nextLine());
	//	boolean result1 = num1 % 2 == 0;

		System.out.print("정수2 입력 > ");
		int num2 = Integer.parseInt(sc.nextLine());
		//boolean result2 = num2 % 2 == 0;

		System.out.print("정수3 입력 > ");
		int num3 = Integer.parseInt(sc.nextLine());
		//boolean result3 = num3 % 2 == 0;

		if (num1 % 2 == 0 ) {
			System.out.println(num1);
		} else {
			System.out.println("");
		}
		if (num2 % 2 == 0) {
			System.out.println(num2);
		} else {
			System.out.println("");
		}
		if (num3 % 2 == 0) {
			System.out.println(num3);
		} else {
			System.out.println("");
		}
		
		// if(num1 % 2 == 0) System.out.println(num1);
		// if(num2 % 2 == 0) System.out.println(num2);
		// if(num3 % 2 == 0) System.out.println(num3);
		
		// if문 하나 가지고! 중첩O (비추천)
		/*
		if(num1 % 2 == 0) {
			System.out.println(num1);
			
			if(num2 % 2 == 0) {
				System.out.println(num2);
				if(num3 % 2 == 0) {
					System.out.println(num3);
				}
			}else {
				if(num3 % 2 == 0) {
					System.out.println(num3);
			}
		 else {System.out.println("");
		 	}
		 }
		
		}
		*/
		
		// if~else if 사용! 중첩X (비추천!!)
		/*
		if(num1 % 2 == 0 && num1 % 2 == 0 && num1 % 2 == 0) {
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);
		} else if (num1 % 2 == 0 && num1 % 2 == 0 && num1 % 2 != 0) {
			System.out.println(num1);
			System.out.println(num2);
		} else if (num1 % 2 == 0 && num1 % 2 != 0 && num1 % 2 == 0) {
			System.out.println(num1);
			System.out.println(num3);
		} else if (num1 % 2 != 0 && num1 % 2 == 0 && num1 % 2 == 0) {
			System.out.println(num2);
			System.out.println(num3);
		} else if (num1 % 2 == 0 && num1 % 2 != 0 && num1 % 2 != 0) {
			System.out.println(num1);
		} else if (num1 % 2 != 0 && num1 % 2 == 0 && num1 % 2 != 0) {
			System.out.println(num2);
		} else if (num1 % 2 != 0 && num1 % 2 != 0 && num1 % 2 == 0) {
			System.out.println(num3);
		} 
		*/
	}

	/*
	 * 3. 정수 1개를 입력했을 때 음(minus)/양(plus)/0(zero), 짝(even)/홀(odd) 출력
	 * 
	 * 정수 입력 > -3 minus odd
	 */
	public void practice3() {
		System.out.print("정수 입력 > ");
		int number = Integer.parseInt(sc.nextLine());
		
		if(number > 0) {
			System.out.println("plus");
		} else if (number == 0){
			System.out.println("zero");
		} else {
			System.out.println("minus");
		}
		
		if(number == 0) {
			System.out.println("");
		} else if(number %2 == 0){
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
	
		/*
		System.out.println("정수 입력 > ");
		int number = sc.nextInt();
		String result = "";
		String result2 = "";
		
		if(number > 0) {
			result = "plus";
		} else if (number < 0) {
			result = "minus";
		} else {
			result = "0";
		}
	
		if(number == 0){
			result2 = "";
		}else if(number % 2 == 0) {
			result2 = "even";
		} else {
			result2 = "odd";
		}
		*/
	}
	
	

	public static void main(String[] args) {
		A_If a = new A_If();
		// a.method1();
		// a.method2();
		// a.method3();
		// a.method4();
		// a.method5();

		 a.practice1();
		 a.practice2();
		 a.practice3();
	}

}
