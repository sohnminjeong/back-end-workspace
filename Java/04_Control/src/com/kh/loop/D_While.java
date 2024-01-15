package com.kh.loop;

import java.util.Scanner;

public class D_While {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * while 문
	 * 
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 * }
	 * */
	
	// 1~5까지 출력 : for -> while
	public void method1() {
		for(int i = 1; i<=5; i++) {
			System.out.println(i);
		}
		
		System.out.println();
		
		int i = 1;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
	}
	
	// 무한루프 & break 문
	/*
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 줍청되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다. 
	 * */
	public void method2() {
		/*for(;;) {
			
		}*/
		
		
		while(true) {
			System.out.print("숫자 입력 > ");
			int num = sc.nextInt();
			System.out.println(num);
			if(num == 0) break;
			}
		}
	
	
	/*
	 * do {
	 * 		실행 코드
	 *  } while(조건식);
	 *  
	 *  - 조건과 상관없이 무조건 한 번은 실행 
	 * 
	 * */
	public void method3() {
		
		int number = 1;
		
		while(number == 0) {
			System.out.println("while문");
		}
		
		
		do {
			System.out.println("do-while문");
		} while (number == 0);
		
	}
	
	
	public static void main(String[] args) {

		
		D_While d = new D_While();
		// d.method1();
		// d.method2();
		d.method3();
	}

}
