// 클래스 이름 : com.kh.practice.VariablePractice
// FQCN(Fully Qualified Class Name)

package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {

	public static void main(String[] args) {

		VariablePractice v = new VariablePractice();
		v.method1();
		v.method2();
		v.method3();
		
	}
	public void method1() {
		int adult = 10000;
		int student = 7000;
	
	System.out.println("[실습문제1]");
		
	System.out.println("성인 2명 : " + adult*2+"원");
	System.out.println("청소년 3명 : " + student*3+"원");
	System.out.println();
	System.out.println("총 금액 : " + (adult*2+student*3)+"원");
	}
	
	
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		
		int number = x;
		x=y;
		y=z;
		z=number;
	    
		
	    System.out.println("[실습문제2]");
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
	
	}
	
	public void method3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[실습문제3]");
		
		System.out.print("문자열을 입력하세요 : ");
		String text = sc.nextLine();
		char start = text.charAt(0);
		char last = text.charAt(7);
		
		System.out.printf("첫번째 문자 : %c\n마지막 문자 : %c", start, last);
	}
}

