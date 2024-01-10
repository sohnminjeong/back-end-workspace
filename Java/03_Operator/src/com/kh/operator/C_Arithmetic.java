package com.kh.operator;

public class C_Arithmetic {
	
	/*
	 * 산술 연산자
	 * + : 더하기
	 * - : 빼기
	 * * : 곱하기
	 * / : 나누기
	 * % : 나머지 
	 *  
	 * */
	
	public static void main(String[] args) {
		
		C_Arithmetic c = new C_Arithmetic();
		// c.method1();
		c.method2();
	}

	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println(" + : " + (num1 + num2));   // + : 13
		System.out.println(" - : " + (num1 - num2));   // - : 7
		System.out.println(" * : " + (num1 * num2));   // * : 30
		System.out.println(" / : " + (num1 / num2));   // / : 3 (몫) - 정수끼리 연산하면 값이 정수로 나옴
		System.out.println(" % : " + (num1 % num2));   // % : 1 (나머지)
		
	}
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b;   // 16
		int d = c / a;      // 16/6 = 2
		int e = c % a;      // 4
		int f = e++;        // 4
		int g = (--b) + (d--);   //9 + 2 = 11
		int h = 2;               // 2
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); 
	    // 6 + 9 / (15/4) * (11-1) % (6+2)
		// 6 + 9 / 3 * 10 % 8 => 6 + 30 % 8 =>  6 + 6 = 12 
		System.out.println(i);     // 12
	}
}
