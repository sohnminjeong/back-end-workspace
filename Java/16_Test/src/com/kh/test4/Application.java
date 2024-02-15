package com.kh.test4;

import com.kh.test4.model.Person;

public class Application {

	public static void main(String[] args) {
		Person[] pArr = new Person[3];
		// Person클래스를 배열의 타입으로 지정하려면 com.kh.test4.model이라는 package에 Person이라는 클래스가 있어야 한다. 
		pArr[0] = new Person("가");
		pArr[1] = new Person("나");
		pArr[2] = new Person("다");
		
		for(int i=0; i<pArr.length; i++) {
			System.out.println(pArr[i].getName());
		}
	}
	

}
