package com.kh.overriding;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VIPCustomer;

public class Application {

	
	public static void main(String[] args) {
		
		// 객체 생성! 따로 인식됨
		Customer customer1 = new Customer("이상현");
		// 생성자 중 두번째꺼 호출		
		Customer customer2 = new Customer("이상현");
		
		// "이상현"으로 같아도 객체는 따로로 인식되어 두 주소값 다름
		System.out.println(customer1);
		System.out.println(customer2);
		// Customer에 tostring 넣으면 똑같이 보임.
		
		System.out.println(customer1 == customer2);        // false
		System.out.println(customer1.equals(customer2));   // true
		
		System.out.println();
		
		VIPCustomer customer3 = new VIPCustomer("정세영");
		VIPCustomer customer4 = new VIPCustomer("정회영");
		
		System.out.println(customer3.equals(customer4));   // false : 상속받았기 때문
		
		// customer1 또는 customer2
		// customer3 또는 customer4
		// ~~님의 등급은 ~~이며, 지불해야 하는 금액은 ~~원이며, 적립된 포인트는 ~~점입니다.
		
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다\n",
		customer1.getName(), customer1.getGrade(), customer1.calcPrice(1000), customer1.getBonusPoint());

		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점입니다",
				customer3.getName(), customer3.getGrade(), customer3.calcPrice(1000), customer3.getBonusPoint());
		
	}

}
