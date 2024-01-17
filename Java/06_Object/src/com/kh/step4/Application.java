package com.kh.step4;

import com.kh.step4.model.Car;

public class Application {

	public static void main(String[] args) {
		Car c = new Car();
		
		/* private로 지정되어 있기 때문에 class가 달라 사용 불가 
		c.color = "red";
		c.gearType = "auto";
		c.door = 4;
		*/
		
		Car c1 = new Car("white", "auto", 4);
		// public Car(String color, String gearType, int door) 해당 생성자 호출
		Car c2 = new Car("black", "manual");
		// public Car(String color, String gearType) 해당 생성자 호출
		
		System.out.println(c1);  // 자식 클래스에 public String toString()작성 후 적으면 그대로 값 출력됨 
		System.out.println(c2);  // public String toString()작성하지 않으면 주소값이 나옴
	}
	
	// 오버로딩 : 한 클래스 내에 동일한 이름의 메서드를 매개변수의 자료형과 개수, 순서가 다르게 작성되어야 함 
	// = 같은 메서드, 다른 매개변수 가지고 있는 것
	void test() {}
	void test(int a) {}
	void test(int a, String s) {}
	void test(String s, int a) {}
	void test(int a, int b) {}
	// void test(int c, int d){} : 윗줄과 같은 메서드로 인식됨
	
	
	
	
	
	
}
