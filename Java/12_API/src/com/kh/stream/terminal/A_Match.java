package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.List;

import com.kh.stream.model.Student;

/*
 * 매칭
 * - 최종 처리 단계에서 요소들이 특정 조건에 만족하는지 조사하는 역할
 * - allMatch : 모든 요소들이 매개 값으로 주어진 조건을 만족하는지 조사 
 * - anyMatch : 최소한 한 개의 요소가 매개 값으로 주어진 조건을 만족하는지 조사 
 * - noneMatch : 모든 요소들이 매개 값으로 주어진 조건을 만족하지 않는지 조사 
 * */

public class A_Match {

	public static void main(String[] args) {
		A_Match a = new A_Match();
		//a.method1();
		a.method2();
		
	}
	
	public void method1() {
		int[] values = {2, 4, 6};
		boolean result = Arrays.stream(values)
								.allMatch(value -> value % 2 == 0);
		// allMatch : 전부 다 해당인지 확인
		System.out.println("짝수만 가지고 있는가? " + result);   // 짝수만 가지고 있는가? true
		
		result = Arrays.stream(values).anyMatch(value -> value % 3 == 0);
		//stream은 일회성이라 사용할 때마다 만들어야 함
		// anyMatch : 하나라도 해당인지 확인 
		System.out.println("3의 배수 값이 하나라도 있는가? " + result);    // 하나라도 3의 배수가 있는가? true
	
		result = Arrays.stream(values).noneMatch(value -> value % 5 == 0);
		// noneMatch : 하나도 없는지 확인
		System.out.println("모두 다 5의 배수가 아닌가? " + result);    // 모두 다 5의 배수가 아닌가? true
		
	}
	
	public void method2() {
		List<Student> students = Arrays.asList(
				new Student("이상현", 25, "남자", 50, 80),
				new Student("정동준", 28, "남자", 90, 90),
				new Student("이상호", 26, "남자", 80, 70),
				new Student("권예빈", 27, "여자", 75, 80),
				new Student("조세미", 24, "여자", 85, 65)
				);
		// collection의 경우에는 stream을 제공하기 때문에 Arrays.stream()이 아닌 배열명.stream()으로 시작!
		
		// [나이가 25살 이상인 학생들이 모두 남자인지 확인]
		boolean check = students.stream()
						.allMatch(student -> student.getAge()>=25 && student.getGender().equals("남자"));
		// filter(student -> student.getAge()>=25)
		// allMatch(gender확인) => filter로 한번 거르고 allMatch로 확인하는 방법도 가능 
		System.out.println("나이가 25살 이상인 학생들이 모두 남자인지 : " + check);    // false
		
		// [남학생들 중에 평균이 70점 이상인 학생이 한 명이라도 존재하는지 확인]
		boolean check2 = students.stream()
						.anyMatch(student -> student.getGender().equals("남자") && ((student.getMath()+student.getEnglish())/2>=70));
		//.filter(student -> student.getGender().equals("남자"))
		//.anyMatch(student -> student.getMath() + student.getEnglish())/2 >= 70)
		System.out.println("남학생들 중 평균 70점 이상인 학생이 한 명이라도 존재하는가? " + check2);     // true
		
	}
}
