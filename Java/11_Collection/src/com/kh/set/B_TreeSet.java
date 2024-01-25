package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.kh.set.model.Person;

/*
 * TreeSet
 * - 저장과 동시에 자동 오름차순 정렬 (HashSet + 정렬)
 * - HashSet보다 데이터 추가, 삭제에 시간이 더 걸림 
 * 
 * */
public class B_TreeSet {

public static void main(String[] args) {
		
	B_TreeSet b = new B_TreeSet();
		//b.method1();
		b.method2();
	}

	public void method1() {
		Set<String> set = new TreeSet<>();
		
		set.add("라미란");
		set.add("공명");
		set.add("염혜란");
		set.add("박병은");
		set.add("라미란");
		set.add("라미란");
		// treeSet은 정렬되어 들어감
		
		System.out.println(set);
		System.out.println(set.size());  // 4
		System.out.println("라미란이 포함되어 있는가 ? " + set.contains("라미란"));  // true
	
		
		set.remove("박병은");
		// set은 순서가 없기 때문에 index가 필요X
		System.out.println(set);  // 박병은 사라지고 3개만 남아있음
		
		set.clear();
		System.out.println("비어있는지 ? " + set.isEmpty()); // true
		
	}
	
	
	public void method2() {
		
		TreeSet<Person> set = new TreeSet<>();
		// TreeSet은 Person에서 Comparable하고 재정의 필요
		set.add(new Person("라미란", 48));
		set.add(new Person("공명", 29));
		set.add(new Person("엄혜란", 47));
		set.add(new Person("박병은", 46));
		set.add(new Person("라미란", 48));
		set.add(new Person("라미란", 48));
		
		
		
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
