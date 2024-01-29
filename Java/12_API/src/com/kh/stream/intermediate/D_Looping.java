package com.kh.stream.intermediate;

import java.util.Arrays;

/*
 * 반복
 * - 요소 전체를 반복하는 역할 
 * - peek : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용 
 * - forEach : 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용  
 * */

public class D_Looping {

	public static void main(String[] args) {
		
		int[] values = {1, 2, 3, 4, 5};
		
		// peek
		int sum = Arrays.stream(values)
						.filter(i -> i%2 == 0)
						.peek(value -> System.out.println(value))   // 중간처리들만 있으면 최종처리 만나기 전까지 실행안함.
						.sum();  // sum의 반환타입은 int
			System.out.println("1~5 중 짝수의 합계 : " + sum);
			
		System.out.println();
			
		// forEach
		Arrays.stream(values)
				.filter(i -> i%2 == 0)
				.forEach(value -> System.out.println(value));
		// forEach도 최종처리, sum도 최종처리 임으로 함께 사용 불가 
		
		// sum 구하고 싶은 경우 이렇게 따로 작성해야 함!
		int sum2 = Arrays.stream(values)
							.filter(i -> i % 2 == 0)
							.sum();
		System.out.println("1~5 중 짝수의 합계 : " + sum2);
		
	}

}
