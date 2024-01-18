package com.kh.inheritance.child;

import com.kh.inheritance.parent.Product;

/*
 * 상속
 * 
 * class 자식클래서 extend 부모클래스{
 * } 
 * 
 * * 상속의 장점
 * - 적은 양의 코드로 새로운 클래스 작성이 가능 
 * - 코드를 공통적으로 관리하기 때문에 코드의 추가나 변경에 용이
 * - 코드의 중복을 제거하여 프로그램의 생산성과 유지 보수에 크게 기여
 * 
 * * 상속의 특징
 * - 클래스 간의 단일 상속만 가능
 * - 명시되지 않아도 모든 클래스는 Object 캘래스 상속
 * 		-> Object 클래스의 메서드들을 오버라이딩 하여 메서드 재정의 가능
 * - 부모 클래스의 생성자, 초기화, 블럭은 상속되지 않는다.
 * 		-> 자식 클래르 생성 시에 부모 클래스 생성자가 먼저 실행
 * - 부모의 private 변수는 상속은 되지만 직접 접근은 불가능
 * 		-> Getter / Setter 사용해서 간접 접근 가능
 *  */

public class Notebook extends Product{
	// 자바는 단일 상속만 가능 - 한 부모만! 
	private String cpu;      //cpu
	// 변수는 접근제어자를 private를 걸어야 함(해당 클래스에서만 다루도록!) 
	// -> 1) 생성자, 2) getter, setter 지정하여 사용할 수 있도록!
	public Notebook() {}

	public Notebook(String brand, String pCode, String name, int price, String cpu) {
		// super : 해당 객체의 부모의 객체 주소를 담고 있다. 
		// 1. 부모 생성자 호출해서 초기화
		super(brand, pCode, name, price);
		// super : 부모인 product를 가리킴 / 부모태그에 있는 this문에 들어감
		// super는 부모를 가리키고 this는 본인을 가리킴 
		this.cpu = cpu;
		
		// 2. super.를 통해서 부모의 변수에 직접 접근
		//super.brand;    // 부모가 private - 직접 접근이 안됨
		//super.pCode;    // 부모가 default - 같은 패키지에 있어야만 직접 접근 가능O
		super.name = name;   // 부모가 protected - 상속관계일 때 자식 객체에서 직접 접근 가능O
		super.price = price;   // 부모가 public - 어디서든 접근 가능 
		
		// 3. 부모의 setter 메서드를 호출해서 초기화 
		//   - 부모 크래스에서 setter 메서드를 제공하면 자식 클랙스에서 부모의 setter 메서드를 통해 초기화 가능
		super.setBrand(brand);
		this.setpCode(pCode);
		setName(name);
		
	}

	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return super.toString()+", Notebook [cpu=" + cpu + "]";
	}
	
}
