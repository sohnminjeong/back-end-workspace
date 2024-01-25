package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.kh.set.model.Person;

/*
 * Set의 특징
 * - 중복 없음
 * - 순서 없음
 * */

// HashSet : Set 인터페이스를 구현한 대표적인 컬렉션 클래스 

public class A_HashSet {
	
	public static void main(String[] args) {
		
		A_HashSet a = new A_HashSet();
		//a.method1();
		a.method2();
	}

	public void method1() {
		Set<String> set = new HashSet<>();
		
		set.add("라미란");
		set.add("공명");
		set.add("염혜란");
		set.add("박병은");
		set.add("라미란");
		set.add("라미란");
		// set 특징1) set은 list와 다르게 중복이 포함되지 않는다. 
		// set 특징2) set은 순서를 바꿔도 자기 맘대로 
		
		System.out.println(set);
		System.out.println(set.size());  // 4
		System.out.println("라미란이 포함되어 있는가 ? " + set.contains("라미란"));  // true
		// contains : 포함되어 있는가 ->true, false로 반환 
		
		set.remove("박병은");
		// set은 순서가 없기 때문에 index가 필요X
		System.out.println(set);  // 박병은 사라지고 3개만 남아있음
		
		set.clear();
		System.out.println("비어있는지 ? " + set.isEmpty()); // set으로 하면 []나오고 isEmpty()하면 true나옴
		
	}
	
	
	public void method2() {
		
		HashSet<Person> set = new HashSet<>();
		// Person 타입으로 생성 객체 생성
		
		set.add(new Person("라미란", 48));
		set.add(new Person("공명", 29));
		set.add(new Person("엄혜란", 47));
		set.add(new Person("박병은", 46));
		set.add(new Person("라미란", 48));
		set.add(new Person("라미란", 48));
		
		// 객체는 주소값으로 저장되고 각 객체는 주소값이 다르기 때문에 내용이 중복이여도 주소값이 달라 저장됨 
		// 객체의 주소값을 가지고 비교하기 때문에 모두 다른 객체로 인식해서 중복 제거되지 X
		// -> 객체에 hashCode, equals 메서드 재정의(Person에서 Alt+Shift+s 누르고 hachCode() and equals() 선택) 
		
		for(Person p : set) {
			System.out.println(p);
		}
		// while문으로도 가능!
		System.out.println();
		/*
		 * Iterator
		 * - 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스 
		 * - iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용 
		 * */
		
		Iterator<Person> it = set.iterator();
		while(it.hasNext()) {  // 읽어올 요소가 있는지 확인 
			System.out.println(it.next()); // 다음 요소를 읽어옴!(next 활용)
		}
		
	}
}
