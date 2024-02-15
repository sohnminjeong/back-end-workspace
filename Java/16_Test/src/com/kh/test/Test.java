package com.kh.test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// 1. false가 아닌 true
			System.out.print("문자열을 입력해주세요 : ");
			String str = sc.nextLine();
			// 2. String이기 때문에 sc.nextInt()가 아닌 sc.nextLine()으로 받아야 함.
			if(str.equals("exit")) {
				break;
				// 3. exit의 경우 종료하고 싶으면 continue가 아닌 break;
				// 4. String의 경우 ==가 아닌 equals를 사용해야 함 (주소값이 다름)
			} else {
				System.out.println(str.length() + "글자 입니다.");
				// 5. str.length가 아닌 length()
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
//문제점 5가지