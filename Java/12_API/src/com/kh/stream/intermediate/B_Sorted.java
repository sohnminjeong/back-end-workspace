package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.model.Student;

/*
 * 정렬
 * - 스트림은 최종 처리가 되기 전에 중간 단계에서 요소들을 정렬해서 최종 처리 순서를 변경할 수 있다.
 * - Stream<T>은 요소 객체가 Comparable 인터페이스를 구현해야 정렬할 수 있다. 
 * */

public class B_Sorted {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미");
		// 이름이 ㄱ부터 순서대로 정렬됨
		// 오름차순 정렬
		//names.stream().sorted().forEach(name -> System.out.print(name + " "));
		// 내림차순 정렬
		names.stream()
			 .sorted()
			 .sorted(Comparator.reverseOrder())
			 .forEach(name -> System.out.print(name + " "));
		
		System.out.println();
		
		List<Student> students = Arrays.asList(
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90)
			);
		
		// 나이 오름차순 정렬
		students.stream()
				.sorted()
				.forEach(student -> System.out.println(student));
		
		System.out.println();
		
		// 나이 내림차순 정렬 
		students.stream()
				.sorted(Comparator.reverseOrder())
				.forEach(student -> System.out.println(student));
	}

}
