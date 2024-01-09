package com.kh.variable;

public class B_Casting {
	
	/*
	 * 형 변환(Casting)
	 * - 값의 타입을 다른 타입으로 변환하는 것 
	 * - boolean을 제외한 7개의 기본형은 서로 형변환이 가능 
	 * */

	public static void main(String[] args) {

		B_Casting b = new B_Casting();
		// b.autoCasting();
		b.casting();
	}

	/*
	 * 자동 형 변환(묵시적 형 변환)
	 * - 자동으로 형 변환이 이루어지기 때문에 따로 형 변환하지 않아도 된다. 
	 * */
	public void autoCasting() {
		// 정수
		byte b = 10;  // 1byte
		short s = b;  // 2byte : byte -> short 자동 형 변환
		int i = s;    // 4byte : short -> int 자동 형 변환 
		long l = i;   // 8byte : int -> long 자동 형 변환 
		
		// 실수
		float f = 1;   // 4byte 
		double d = f;  // 8byte  : float -> double 자동 형 변환 
		
		// 정수 -> 실수
		d = i;   // int -> double 자동 형 변환
		f = l;   // long(8byte) -> float(4byte) 
		// => 표현 가능한 수의 범위가 더 크기 때문에
		
		double result = 12 + 3.3;
		System.out.println(result);   // 15.3
		
		int result2 = b + s;   // byte, short 타입의 데이터는 연산시 무조건 int 타입으로 변환 
		System.out.println(result2);   // 20
		
		long result3 = 30 + 30;  // 30 + 30 = 60, 60을 long 타입으로 형 변환 (60L로 들어감) 
		// int+int로 계산되어 int 먼저 계산 된 후 long 으로 변경되어 송출
		System.out.println(result3);   // 60
		
		long result4 = 30 + 30L;   // 30L + 30L = 60L
		// int+long 계산 시 int를 long으로 형 변환하여 long+long으로 계산 됨 
		System.out.println(result4);   // 60
		
	}
	
	/*
	 * 강제 형 변환 (명시적 형 변환)
	 * 
	 * (자료형) 데이터;
	 * 
	 * - 범위가 큰 크기의 자료형의 데이터를 
	 * 	 작은 크기의 자료형으로 변환하려고 할 때 사용
	 * - 강제 형 변환의 경우 데이터의 손실이 발생할 수 있다. 
	 *  
	 * */
	public void casting() {
		double d = 4.12345678901234567890;   // 20자리
		System.out.println(d);    //double : 15자리까지만 보임 (4.123456789012345)
		
		float f = (float) d;      // 강제형 변환 
		System.out.println(f);    // float : 6자리까지만 보임(마지막 반올림) -> 데이터 손실 발생 (4.123457)
		
		int i = (int) f;
		System.out.println(i);    // 4
		
		int sum = (int) (i+d);    // 4.0 + 4.123456789012345
		System.out.println(sum);   // 8
		
		
		int sum2 = i + (int) d;     // 4 + 4
		System.out.println(sum2);   // 8
		
		int number = 128;
		byte bNumber = (byte) number;
		int number1 = 129;
		byte bNumber1 = (byte) number1;
		
		System.out.println(bNumber);   // -128  : byte는 -128~127까지임으로 127을 넘을 경우 처음인 -128로 돌아감 
		System.out.println(bNumber1);  // -127
		
		// char <-> int : 각 문자들마다 고유한 숫자가 지정되어 있기 때문에 
		// 쌍방향으로 형변환 가능 
		// char는 음수값 저장 불가 => 값의 범위가 0 ~ 65535
		
		int num = /*(int)*/ 'A';
		System.out.println(num);   // A -> 65
		
		char ch = /*(char)*/ 52143;
		System.out.println(ch);    // 52143 -> 쮯
		
	}
}
