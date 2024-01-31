package com.kh.step5;

// 스레드들은 공유자원을 서로 공유한다 
public class SharedMemoryTest {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		//CalculatorUser1 : 50 CalculatorUser2 : 50 -> user1에서 100이지만 2의 공유자원으로 인해 둘다 값이 50으로 변경됨
		// -> 동기화 처리가 필요(순서에 맞게 처리하는 것) -> synchronized : 동기화 처리
		User1 user1 = new User1();
		user1.setCalculator(cal);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(cal);
		user2.start();
		
		
	}
	

}
