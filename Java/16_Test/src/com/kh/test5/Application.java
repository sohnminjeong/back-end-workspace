package com.kh.test5;

import java.util.ArrayList;
import java.util.List;

import com.kh.test5.model.Fruit;

public class Application {

	public static void main(String[] args) {
		List<Fruit> list = new ArrayList<>();
		list.add(new Fruit("사과", "빨강"));
		list.add(new Fruit("메론", "초록"));
		list.add(new Fruit("포도", "보라"));
		list.add(new Fruit("바나나", "노랑"));
		// list.add(new Fruit("바나나", "노랑")으로 변경
		for(int i=0; i<list.size(); i++) {
			// list의 경우 길이는 length가 아닌 size 사용
			System.out.println(list.get(i).getName());
			// list의 경우 인덱스 위치를 바로 [i]하는 것이 아닌 .get(i)를 사용해야 함.
		}
	}

}
