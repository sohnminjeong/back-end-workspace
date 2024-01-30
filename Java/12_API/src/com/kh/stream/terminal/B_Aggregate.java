package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class B_Aggregate {

	public static void main(String[] args) {
		B_Aggregate b = new B_Aggregate();
		//b.method1();
		b.method2();
	}
	
	/*
	 * 기본 집계
	 * - 최종 처리 기능으로 요소들을 개수, 합계, 평균값, 최대값, 최소값 등과 같이 하나의 값으로 산출하는 역할 
	 * - count : 요소의 개수 리턴
	 * - sum : 요소들의 합계 리턴
	 * - average : 요소들의 평균 리턴
	 * - max : 최대 요소 리턴
	 * - min : 최소 요소 리턴 
	 * - findFirst : 첫번째 요소 리턴 
	 * */
	
	public void method1() {
		int[] array = {1, 2, 3, 4, 5, 6};
		
		long count = Arrays.stream(array).count();
		System.out.println("개수 : " + count);   // 개수 : 6
		
		int sum = Arrays.stream(array).sum();
		System.out.println("합계 : " + sum);   // 합계 : 21
		
		/*
		 * Optional 클래스
		 * - 스트림의 최종 결과 값을 저장하는 객체 
		 * - 단순히 값만 저장하는 것이 아니라, 값의 존재 여부를 확인하고 값이 존재하지 않을 경우 디폴트 값을 설정할 수 있는 객체 
		 * */
		
		// Double avg = Arrays.stream(array).average().getAsDouble();
		OptionalDouble avg = Arrays.stream(array).average();
		// get : 저장되어 있는 값을 얻기 위해 사용 
		// OptionalDouble인 경우 결과값 구할 때 .getAsDouble()로 바로 찾기도 가능
		System.out.println("평균 : " + avg.getAsDouble());   // 평균 : 3.5
		
		//OptionalInt max = Arrays.stream(array).max();   // 최대 : OptionalInt[6]
		int max = Arrays.stream(array).max().getAsInt();   // 최대 : 6		
		// OptionalInt로 할 경우 max.getAsInt();로 호출도 가능 
		System.out.println("최대 : " + max);    
		
/*		OptionalInt max = Arrays.stream(array).max();
		// orElse() : get과 동일하게 저장되어 있는 값을 얻어오는 메서드로 값이 저장되어 있지 않을 경우 디폴트 값을 지정
		int maxResult = max.orElse(0);  (= max.getAsInt();)
		System.out.println("최대값 : " + maxResult);
*/		
		
		int min = Arrays.stream(array).min().getAsInt();
		// OptionalInt로 할 경우 min.getAsInt();로 호출도 가능 
		System.out.println("최소 : " + min);    // 최소 : 1
		
/*		OptionalInt min = Arrays.stream(array).min();
		// isPresent : 값이 저장되어 있는지 검사 
		if(min.isPresent()) {
			System.out.println(min.getAsInt());
		} else {
			System.out.println("데이터가 없음");
		}
*/
		
		// ifPresent : 값이 저장되어 있을 경우 처리  (if + isPresent)
		OptionalInt first = Arrays.stream(array).findFirst();
		first.ifPresent(value -> System.out.println("첫번째 값 : " + value));
		//System.out.println("첫번째 요소 : " + first.getAsInt());  // 첫번째 요소 : 1
	}
	
	/*
	 * 커스텀 집계
	 * - 스트림에서 기본 집계 메서드를 제공하지만 다양한 집계 결과물을 만들 수 있도록 reduce 메서드를 제공한다
	 * */
	public void method2() {
		int[] values = {1, 2, 3, 4, 5, 6};
		
		// 1 * 2 * 3 * 4 * 5 * 6
		int result = Arrays.stream(values)
							.reduce((x, y) -> x * y)
							.getAsInt();
		System.out.println(result);  // 720
	}
}
