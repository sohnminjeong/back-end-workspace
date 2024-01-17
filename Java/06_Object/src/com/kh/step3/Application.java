package com.kh.step3;

import com.kh.step3.model.Calculator;

public class Application {

	public static void main(String[] args) {
		/*
		 * 변수 호출 방법
		 * - 참조변수.변수;
		 * 
		 * 메서드 호출 방법 
		 * - 참조변수.메서드명(); // 매개변수가 없는 경우
		 * - 참조변수.메서드명(값1, 값2, .....);    // 매개변수가 있는 경우 
		 * 
		 * */
		Calculator c = new Calculator();
		
		c.a = 3;
		c.b = 98;
		
		System.out.println("더하기 : " + c.add());     // 101
		System.out.println("빼기 : " + c.substract());  // -95
		System.out.println("곱하기 : "+c.multiply());   // 294
		System.out.println("곱하기2 : "+c.multiply(100, 200));  // 20000 - 매개 변수가 있는 경우는 값을 같이 적어야 사용 가능 
		System.out.println("나누기 : "+Calculator.divide(c.a, c.b));   // 몫은 0, 나머지는 3
	
	

		System.out.println("팩토리얼 : "+c.factorial(4));    // 팩토리얼 : 24
		System.out.println("팩토리얼 : "+c.factorial2(4));   // 팩토리얼 : 24 => if(n!=1)없을 경우 에러 발생 
	}

}
