package com.kh.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.map.model.Snack;

/*
 * Map
 * - key-value 쌍으로 저장 
 * - 순서 없음
 * - 중복 : 키(key) X, 값(value) O 
 * 
 * HashMap
 * - Map 인터페이스를 구현한 대표적인 컬렉션 클래스 
 * 
 * */
public class A_HashMap {

	public static void main(String[] args) {
		
		A_HashMap a = new A_HashMap();
		//a.method1();
		a.method2();
		
	}
	
	public void method1() {
		// <키에 대한 데이터 타입, 값에 대한 데이터 타입>
		Map<String, Integer> map = new HashMap<>();
		map.put("웨하스", 250);   // add와 같은 기능
		map.put("고래밥", 180);
		map.put("칸쵸", 800);
		map.put("나쵸", 450);
		
		System.out.println(map);   //{웨하스=250, 고래밥=180, 나쵸=450, 칸쵸=800}
		
		// 1. 키만 가져오기
		Set<String> key = map.keySet(); // set은 중복허용x
		System.out.println(key);   // [웨하스, 고래밥, 나쵸, 칸쵸]
		
		// 2. 값만 가져오기
		Collection<Integer> col = map.values();
		System.out.println(col);    // [250, 180, 450, 800]
		
		// 3. 키에 해당하는 value 값 가져오기
		Iterator<String> it = key.iterator();
		// 키에 대한 interator를 가져올 것이기 때문 , java.util import필요 
		while(it.hasNext()) {
			String name = it.next();
			//System.out.println(it.next());   // 웨하스 고래밥 나쵸 칸쵸
			System.out.println(name + " : " + map.get(name));
		}
		System.out.println("=====================");
		for(String s : key) {
			System.out.println(s + " : " + map.get(s));
		}
		
		/*
		 * 4. entrySet
		 * 	- Map 컬렉션에 있는 Entry 객체(key, value 쌍으로 이루어진)를 Set 컬렉션에 담아서 반환 
		 * 	- 반환된 Set 컬렉션에서 반복자를 얻어서 반복 처리 
		 * */
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		// entry(String, integer) 형태 객체들이 담겨있는 set
		System.out.println(entrySet);   // [웨하스=250, 고래밥=180, 나쵸=450, 칸쵸=800]
		
		for(Entry<String, Integer> entry : entrySet) {
			//System.out.println(entry);    //  웨하스=250 고래밥=180 나쵸=450 칸쵸=800
			System.out.println(entry.getKey() + " : " + entry.getValue());  // .getKey(), .getValue()로 각각을 가져올 수 있음
		}	
	}
	
	public void method2() {
		Map<String, Snack> map = new HashMap<>();
		map.put("웨하스", new Snack("치즈", 240));
		map.put("웨하스", new Snack("딸기", 255));
		map.put("고래밥", new Snack("양념치킨", 173));
		map.put("자유시간", new Snack("아몬드", 232));
		map.put("칸쵸", new Snack("딸기 요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("나쵸", new Snack("치즈", 486));
		map.put("꼬깔콘", new Snack("매콤달콤", 175));
		map.put("후렌치파이", new Snack("딸기", 900));
		
		// key 한개 중복으로(웨하스) 과자개수 -> 9개로 나옴
		System.out.println("과자의 개수 : " + map.size());   // 과자의 개수 : 9개
		
		// 웨하스에는 뭐가 들어 있을까요?
		// put은 한벌 들어가면 추간데 두번째부터는 수정 들어감 -> 그래서 두번째 웨하스가 들어감
		System.out.println(map.get("웨하스"));    // Snack [flavor=딸기, calorie=255]
		
		// 키 값으로 삭제하기 - 꼬깔콘
		map.remove("꼬깔콘");
		System.out.println("과자의 개수 : " + map.size());   // 과자 개수 : 8
		
		System.out.println("===================================================");
		
		// 1. 홈런볼에 해당하는 과자 정보 출력
		System.out.println("홈런볼 과자 정보 : " + map.get("홈런볼"));
		
		// 2. 후렌치파이의 맛 정보 출력
		//map.get("후렌치파이").getFlavor();
		System.out.println("후렌치파이 맛 정보 : " + map.get("후렌치파이").getFlavor());
		
		// 3. 모든 과자의 칼로리 총합과 평균 출력
		
		// [entry방식] -> entry방식 쓰면 key와 value 둘다 사용 가능!
		int sum = 0;		
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		for(Entry<String, Snack> e : entrySet) {
			sum += e.getValue().getCalorie();
			/*Snack snack = e.getValue();
			sum += snack.getCalorie();*/
		}
		
		//[key값 방식]
		// map.keySet() : map의 key다 갖고 있음
		for(String key : map.keySet()) {
			Snack snack = map.get(key);
			sum += snack.getCalorie();
		}

		System.out.println("모든 과자 칼로리 총합 : " + sum + "kcal");
		System.out.println("모든 과자 평균 : " + (sum/map.size()) + "kcal");
		
		// 모든 Entry 객체 삭제 (clear : 객체 삭제 / isEmpty() : 비어있는지 확인)
		map.clear();
		System.out.println("비어있는지 : " + map.isEmpty());
		System.out.println(map);
		
	}
}
