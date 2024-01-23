package com.kh.practice1;

public class C_UnCheckedException {
	
	/*
	 * UnCheckedExcepton
	 * - RunTimeExcepton을 상속하고 있는 예외들 
	 * - 컴파일 시 예외 처리 코드가 있는지 검사하지 않는 예외 
	 * - RuntimeException의 경우 프로그램 실행할 때 문제가 발생될 것을 충분히 예측 가능해서 조건문 등을 통해 처리 가능 
	 * 
	 * */
	

	public static void main(String[] args) {
		C_UnCheckedException c = new C_UnCheckedException();
//		c.method1();
//		c.method2();
//		c.method3();
		c.method4();
	}
	
	
	// ArrayIndexOutOfBoundsException : 배열의 접근에 잘못된 인덱스 값을 사용하는 경우 예외 발생 
	public void method1() {
		String[] str = {"Hello Java", "Nice to meet you", "No I mean It"};
		
		for(int i =0; i<=3; i++) {
			try {
				System.out.println(str[i]);				
			} catch(ArrayIndexOutOfBoundsException e) {
				// e.getMessage()에 담겨있는 부분 -> e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	// NegativeArraySizeException : 배열 크기를 음수로 지정한 경우 예외 발생 
	public void method2() {
		try {
			// 해당 에러 잡기 위해 try-catch 실행
			int[] arr = new int[-3]; // 컴파일 에러는 안남 but 잘못된 코드 -> 실행하는 순간 에러 발생 : NegativeArraySizeException
		} catch(NegativeArraySizeException e) {
			// catch(에러명 변수명) {sysout(변수명.getMessage());}
			System.out.println(e.getMessage());   // -3
		}
		
	}
	
	// ArithmeticException : 나누기 연산에서 분모가 0인 경우 예외 발생
	public void method3() {
		try {
		int result = 10 / 0;   //컴파일 에러는 X but 잘못된 코드 -> 실행 순간 에러 발생: ArithmeticException
		} catch(ArithmeticException e) {
			System.out.println(e.getMessage());    // / by zero
		} finally {
			System.out.println("예외 발생 여부와 상관없이 무조건 실행");
		}
	}
	
	
	// NullPointerException : Null인 참조 변수로 객체의 멤버 참조 시도 시 예외 발생 
	public void method4() {
		// 에러 확인 후 try-catch가 아닌 미리 try(작성한 모든 코드)catch(해당 에러의 부모:Exception){실행문} 가능
		try {
			String str = null;
			System.out.println(str.length()); // 컴파일에러x -> 실행 순간 에러 : NullPointerException
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
