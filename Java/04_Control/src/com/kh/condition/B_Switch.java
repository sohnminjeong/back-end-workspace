package com.kh.condition;

import java.util.Scanner;

public class B_Switch {

	Scanner sc = new Scanner(System.in);

	/*
	 * switch문
	 * 
	 * switch(조건식) { case 값1 : 조건식의 결과가 값1과 같은 경우 실행 break; (break를 만날 때 까지 스위치 문은
	 * 안나감) case 값2 : 조건식의 결과가 값2와 같은 경우 실행 break; default : } 조건식의 결과가 일치하는 case문이
	 * 없을 때 실행
	 * 
	 * - case문의 수는 제한이 없다. - 조건식 결과는 정수, 문자, 문자열이어야 한다. - 조건문을 빠져나가려면 break가 필요하다. -
	 * default문은 생략 가능하다.
	 */

	public void method1() {
		/*
		 * 숫자를 입력받아 1일 경우 "빨간색입니다" 2일 경우 "파란색입니다" 3일 경우 "초록색입니다" 잘못 입력했을 경우 "잘못입력했습니다"
		 */

		System.out.print("숫자 입력 > ");
		int num = Integer.parseInt(sc.nextLine());
		String result = "";

		// switch 문
		switch (num) {
		case 1:
			result = "빨간색입니다";
			break;
		case 2:
			result = "파란색입니다";
			break;
		case 3:
			result = "초록색입니다";
			break;
		default:
			result = "잘못 입력했습니다.";
		}
		System.out.println(result);

		// if문
		System.out.println("숫자 입력 > ");
		int number = sc.nextInt();

		if (number == 1)
			System.out.println("빨간색입니다.");
		else if (number == 2)
			System.out.println("파란색입니다.");
		else if (number == 3)
			System.out.println("초록색입니다.");
		else
			System.out.println("잘못입력했습니다.");
	}

	/*
	 * 주민번호를 입력받아 "남자"인지 "여자"인지 출력 주민번호 입력 > 100000-3000000 남자
	 */
	public void practice1() {

		System.out.print("주민번호 입력 > ");
		String num = sc.nextLine();
		char num2 = num.charAt(7);
		// int num3 = num2;
		// System.out.print(num3);
		// String result = "";

		switch (num2) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
		}
	}

	// System.out.println(result);

	/*
	 * [강사님] System.out.print("주민번호 입력 > "); char no = sc.nextLine().charAt(7);
	 * String num = String.valueOf(no);
	 * 
	 * switch(Integer.parseInt(num)) { case 1 : case 3 : System.out.println("남자");
	 * break; case 2 : case 4 : System.out.println("여자"); break; } /*
	 * 
	 * 
	 * 
	 * /* 등급별 권한 1 : 관리권한, 글쓰기권한, 읽기권한 2 : 글쓰기권한, 읽기권한 3 : 읽기권한
	 * 
	 * 등급 입력 > 1 관리권한 글쓰기권한 읽기권한
	 */
	public void practice2() {
		System.out.print("등급 입력 > ");
		int grade = Integer.parseInt(sc.nextLine());

		switch (grade) {
		case 1:
			System.out.println("권리권한\n글쓰기권한\n읽기권한");
			break;
		case 2:
			System.out.println("글쓰기권한\n읽기권한");
			break;
		case 3:
			System.out.println("읽기권한");
			break;
		}
/*
		System.out.print("등급 입력 > ");
		int level = sc.nextInt();
		switch (level) {
		case 1:
			System.out.println("권리권한");
		case 2:
			System.out.println("글쓰기권한");
		case 3:
			System.out.println("읽기권한");
		}
		*/
	}

	public static void main(String[] args) {
		B_Switch b = new B_Switch();
		// b.method1();
		b.practice1();
		// b.practice2();
	}

}
