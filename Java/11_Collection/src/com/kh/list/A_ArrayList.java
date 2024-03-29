package com.kh.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.list.model.Person;

/*
	 * - 컬렉션 : 자바에서 제공하는 자료구조를 담당하는 프레임워크 (프레임워크 : 기능 가져다 쓰기) 
	 * - 자료구조 : 데이터를 효율적으로 이용하는 방법으로 데이터에 편리하게 접근하고, 효율적으로 사용하기 위해서 데이터를 저장하거나 조직하는 방법 
	 * - java.util 패키지에 컬렉션과 관련된 인터페이스와 클래스들이 포함 
	 * - 컬렉션을 사용하면 데이터의 추가, 삭제, 정렬 등의 처리가 간단하게 해결되어 자료구조적 알고리즘을 구현할 필요가 없음 
	 * 
	 * * 컬렉션의 장점
	 * - 저장하는 크기의 제약이 없다. 
	 * - 데이터의 추가, 삭제, 정렬 등의 기능 처리가 간단하게 해결 
	 * - 여러 타입의 데이터가 저장 가능 
	 * 
	 * * List 
	 * - 자료들을 순차적으로 늘어놓은 구조 
	 * - 저장되는 객체를 인덱스로 관리하기 때문에 인덱스로 객체를 검색, 삭제할 수 있는 기능
	 * - 중복되는 객체 저장 가능하고, null 값도 저장 가능 
	 * (list는 인터페이스다)
	 * 
	 *  * List의 특징
	 *  - 중복 허용
	 *  - 순서 있음 
	 * 
	 * * ArrayList
	 * - 저장 용량(capacity)을 초과한 객체들이 들어오면 자동적으로 저장 용량이 늘어난다. 
	 * - 동기화(Synchronized)를 제공하지 않는다.
	 * - 동기화 : 하나의 자원(데이터)에 대해 여러 개의 스레드가 접근하려 할 때 한 시점에서 하나의 스레드만 사용할 수 있도록 하는 것을 말한다. 
	 * 
	 * */
public class A_ArrayList {

	public static void main(String[] args) {
		
		A_ArrayList a = new A_ArrayList();
		//a.method1();
		a.method2();
		//a.method3();
	}
	
	public void method1() {
			
		// ArrayList는 클래스임으로 생성 가능 
		List<String> list = new ArrayList<String>();
		
		list.add("신대규");
		list.add("정대윤");
		list.add("조세미");
		list.add("정세영");
		list.add("권예빈");
		
		System.out.println(list);
	}
	
	public void method2() {
		
		/*
		 * 제네릭스(Generics)
		 * - 컴파일 시 타입을 체크해 주는 기능
		 * - <> 다이아몬드 연산자 
		 * 
		 * * 컬렉션에서 사용하는 이유 
		 * - 명시된 타입의 객체만 저장하도록 제한을 두기 위해 사용 
		 * */
		
		ArrayList<Person> list = new ArrayList<Person>();
		// 이 arraylist는 데이터타입 person이다.
		// 그래서 list.add("강호동"); 할 경우 ""는 데이터타입이 string이기 때문에 오류 발생함 
		
		
		// 1. add : 리스트 끝에 추가 
		list.add(new Person("전현무", "삼성동", 46));	
		list.add(new Person("남궁민", "서울숲", 45));
		list.add(new Person("이시언", "상도동", 41));
		list.add(new Person("이제훈", "삼성동", 39));
	
		//System.out.println(list);
		
		// 2. add : 인덱스를 지정하여 해당 인덱스에 추가
		// 		-> 내부적으로 기존에 있는 것들은 뒤로 땡기고 해당 인덱스에 값 추가
		// list.add(인덱스번호, 객체);
		list.add(1, new Person("유재석", "압구정", 51));
		list.add(3, new Person("강호동", "도곡동", 53));
		
		
		// 3. set : 해당 인덱스의 값을 변경 
		list.set(3, new Person("오은영", "삼성동", 57));  // '강호동' 사라지고 '오은영' 생김 
		
		// 4. size : 리스트 안에 몇 개의 데이터가 있는지 
		// list.size()는 int 반환되기 때문에 sysout에 담아야 함! 
		System.out.println("사람 수 : " +  list.size());
		System.out.println(list);
		
		// 5. remove : 해당 인덱스의 객체 삭제 
		// 		-> 알아서 크기가 줄어들고 뒤에 객체가 앞으로 다 땡겨옴
		list.remove(0); // 인덱스 0번인 '전현무' 삭제됨
		System.out.println("삭제 후 사람 수 : " +  list.size());
		System.out.println(list); // Person 클래스에 toString 없으면 주소값만 나옴~ 
		
		// 6. get : 해당 인덱스의 객체 가져오기
		System.out.println(list.get(0));   // 인덱스 0번인 '유재석'정보 하나만 가져옴
		
		// 7. subList : 기존 리스트에서 원하는 만큼 추출해서 새로운 리스트 반환	
		// 반환타입이 list이기 때문에 list에 담음
		List<Person> sub = list.subList(0, 2);
		System.out.println(sub); // 인덱스 0번부터 2번 사이를 가져옴으로 2명!
		
		// 8. addAll : 컬렉션을 통째로 뒤에 추가 
		list.addAll(sub);
		// sub도 list니까 컬렉션임
		System.out.println(list);
		// list 특징 : 중복된거 상관없이 계속 추가됨
		
		// 9. isEmpty : 컬렉션이 비어있는지
		System.out.println("리스트가 비어있는가? " + list.isEmpty()); // 컬렉션이 비어있지 않음으로 false 뜸 
		
		
		// 리스트에 저장된 사람들의 평균 연령 출력
		int sum = 0;
//		for(int i=0; i<list.size(); i++) {
//			sum += list.get(i).getAge();
//		}
//		System.out.println("사람들의 평균 연령 : " + sum/list.size());
		
		for(Person p : list) {
			sum += p.getAge();
		}
		System.out.println(sum/(list.size()));
		
		// 저장된 사람들의 이름만 출력
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getName());
//		}

		for(Person p : list) {
			System.out.println(p.getName());
		}
		
		
		// 삼성동에 사는 사람들만 출력
//		for(int i=0; i<list.size(); i++) {
		
//			if(list.get(i).getAddr().equals("삼성동")) {
//				System.out.println(list.get(i));
//			}
//			if(list.get(i).getAddr() == "삼성동") {
		//  == 을 써도 가능한 이유는 : String이 갖고 있는 특성 중 하나! 
//				System.out.println(list.get(i));
//			}
//			
//		}
		
		for(Person p : list) {
			if(p.getAddr().equals("삼성동")) {
				System.out.println(p);
			}
		}
	
		// 나이 순서대로 출력  --> 이름 순서대로 출력
		// list의 데이터 타입에 implements Comparable<Person> 해야 함
		Collections.sort(list);
		System.out.println(list);
		
		// 10. clear : 싹 비우기
		list.clear();
		// 메서드 실행하고 list 호출
		System.out.println(list);   // 다 비워짐 
		
		
	}
	
	public void method3() {
		List<String> list = new ArrayList<>();
		// String  선택하고 F3누르면 String class를 보여줌!
		// String class에 이미 compareTo가 만들어져 있어서 바로 사용 가능!
		list.add("banana");
		list.add("apple");
		list.add("orange");
		list.add("mango");
		list.add("grape");
		
		
		
		// 11. 오름차순 정렬 : Comparable 인터페이스를 구현하고 있는 요소를 가지고 비교한 값들 반환하여 정렬 
		Collections.sort(list);
		
		// 12. 내림차순 정렬 : sort 메서드를 통해서 오름차순 정렬 후 reverse 메서드를 호출해서 정렬
		Collections.reverse(list);
		// reverse만 사용하면 그냥 반대로 작성이고 sort후 reverse를 해야 내림차순 정렬임
		System.out.println(list);
		
	}
}














