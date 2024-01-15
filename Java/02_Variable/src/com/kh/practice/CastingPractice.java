package com.kh.practice;

import java.util.Scanner;

public class CastingPractice {

	public static void main(String[] args) {
		CastingPractice c = new CastingPractice();
		c.method1();
		c.method2();
	}
	public void method1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[실습문제1]");
		
		System.out.print("문자 : ");
		String input = sc.nextLine();
		char text = input.charAt(0);
		int num = text;
		int num1 = num+1;
		char text1 = (char) num1;
		
		System.out.printf("%s unicode : %d\n%s unicode : %d\n", text, num, text1, num1);
		
		/*[강사님]
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		int num = ch;
		System.out.println(ch + " unicode : " + num);
		
		char ch2 = (char)(num+1);
		System.out.println(ch2 + " unicode : " + (int)ch2); */
		
	}
	
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[실습문제2]");
		
		System.out.print("국어 : ");
		int korean = sc.nextInt();
		sc.nextLine();	
		
		System.out.print("영어 : ");
		int english = sc.nextInt();
		sc.nextLine();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		sc.nextLine();
		
		int total = korean+english+math;
		
		double avg = (double) total/3;
	
		System.out.printf("총점 : %d\n평균 : %.2f", total, avg);
		
		// [강사님]
		System.out.print("국어 : ");
		int kScore = sc.nextInt();
		System.out.print("영어 : ");
		int eScore = sc.nextInt();
		System.out.print("수학 : ");
		int mScore = sc.nextInt();
		
		int sum = kScore + eScore + mScore;
		System.out.println("총점 : " + sum);
		System.out.printf("평균 : %.2f", (double)sum/3);
	}
}
