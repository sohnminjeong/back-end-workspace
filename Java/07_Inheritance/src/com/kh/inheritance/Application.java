package com.kh.inheritance;

import com.kh.inheritance.child.Notebook;
import com.kh.inheritance.child.SmartPhone;
import com.kh.inheritance.child.Tv;

public class Application {

	public static void main(String[] args) {
		
		// 생성자 방식! -> 바로 정보 입력
		Notebook notebook = new Notebook("애플", "mbp-14", "맥북 프로 14", 2390000, "M3");

		// setter 방식 : 틀만 만들고 시작
		SmartPhone phone = new SmartPhone();
		// 부모꺼에 접근 가능
		phone.setBrand("삼성");
		phone.setpCode("SM-F946NZAKOO");
		phone.setName("갤럭시 Z 폴드 5");
		phone.setPrice(2097700);	
		phone.setMobileAgency("SKT");
		
		Tv tv = new Tv("엘지", "OLED97M3KNA", "시그니처 올레드", 45800000, 97);
		
		
		System.out.println(notebook);
		System.out.println(phone);
		System.out.println(tv);
	}

}
