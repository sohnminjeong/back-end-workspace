package com.kh.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class ArrayPractice {
	Scanner sc = new Scanner(System.in);
	/*
	 * 길이가 5인 배열을 선언하고 과일 5개로 초기화 한 후 본인이 좋아하는 과일 하나를 출력하세요. (과일 5개는 뭐든지~)
	 * 
	 * */
	public void method1() {
		// [배열]
/*		String[] fruits = new String[5];
		//String[] fruits = {"사과", "딸기", "바나나", "오렌지", "포도"};
		fruits[0] = "사과";
		fruits[1] = "딸기";
		fruits[2] = "바나나";
		fruits[3] = "오렌지";
		fruits[4] = "포도";
		
		System.out.println(fruits[1]);
*/		
		// [List]
		//List<String> list = new ArrayList<>();
		// ArrayList ~~~  배열을 ArrayList로 변환 
		ArrayList<String> list = new ArrayList<>();
		// [Arrays.as : 배열을 list로 반환]
		// ArrayList<String> list = new ArrayList<>(Arrays.asList(fruits));
		
		list.add("사과");
		list.add("바나나");
		list.add("딸기");
		list.add("오렌지");
		list.add("포도");
		
		System.out.println(list.get(0));
	}
	
	/*
	 * 사용자에게 배열의 길이와 배열의 크기 만큼 사용자한테 입력 받은 값으로 초기화 한 후
	 * 각 입력 받은 값이 잘 들어갔는지 출력 후 저장된 값들의 합을 출력하세요.
	 * 
	 * 정수 : 5
	 * 배열 0번째 인덱스에 넣을 값 : 4
	 * 배열 1번째 인덱스에 넣을 값 : -4
	 * 배열 2번째 인덱스에 넣을 값 : 3
	 * 배열 3번째 인덱스에 넣을 값 : -3
	 * 배열 4번째 인덱스에 넣을 값 : 2
	 * [4, -4, 3, -3, 2]
	 * 2
	 * */
	public void method2() {
/*		[배열]
		System.out.print("정수 : ");
		int length = sc.nextInt();

		
		int[] arr = new int[length];
		int sum = 0;
		for(int i=0; i<length; i++) {
			System.out.print("배열 "+i+"번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
*/		
		// [list]
		System.out.print("정수 : ");
		int length = Integer.parseInt(sc.nextLine());
		int sum = 0;
		
		ArrayList<Integer> arrList = new ArrayList<>();
		for(int i=0; i<length; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : "); 
			 arrList.add(sc.nextInt());
			 sum += arrList.get(i);
			 // 위&아래 방법 모두 가능!
			 int answer = sc.nextInt();
			 arrList.add(answer);
			 sum += answer;
		}
			System.out.println(arrList);
			System.out.println(sum);
		
	}
	
	
	/*
	 * 음식 메뉴는 자유롭게! 개수도 자유롭게! 배열 사용해서
	 * 사용자가 입력한 값이 배열에 있으면 "배달 가능", 없으면 "배달 불가능"을 출력하세요.
	 * 
	 * */

	public void method3() {
		//[배열]
		String[] food = {"짜장면", "탕수육", "치킨", "김밥"};
		System.out.print("원하는 메뉴 : ");
		String order = sc.nextLine();
		
		// 일반 for문
		for(int i=0; i<food.length; i++) {
			if(order.equals(food[i])) {
				System.out.println("배달 가능");
				break;
			} else if(i == food.length-1) {
				System.out.println("배달 불가능");
			}
		}
		// 향상된 for문
		boolean check = false;
		for(String s : food) {
			if(order.equals(s)) {
				check = true;
			} 
		}
		System.out.println(check ? "배달 가능" : "배달 불가능");

		//[list]
		// 배열 -> ArrayList
		ArrayList<String> list = new ArrayList<>(Arrays.asList(food));
		for(int i=0; i<list.size(); i++) {
			if(order.equals(list.get(i))){
				check = true;
			}
		}
		System.out.println(check ? "배달 가능" : "배달 불가능");
		
/*
		Boolean check = false;
		
		for(int i = 0; i<food.length; i++) {	
			if(food[i].equals(order)) {
				check = true;
			} 
		}
		if(check == true) System.out.println("배달 가능");
		else System.out.println("배달 불가능");
*/	
	}
		
	
	/*
	 * 
	 * 사용자에게 주민등록번호를 입력받아 성별자리 이후부터 *로 가리고 출력하세요.
	 * 단, 원본 배열은 건드리지 않고! 
	 * 
	 * 주민등록번호 : 123456-1234567
	 * 123456-1******
	 * 
	 * */
	public void method4() {		
		System.out.print("주민등록번호 : ");
		String num = sc.nextLine();
		
		char[] arr = num.toCharArray();
		String[] arrNo = num.split("");
		
/*		
 		// [for문]
 		for(int i = 0; i<arrNo.length; i++) {
			if(i >= 8) {
				arrNo[i] = '*';
			}
		}
		System.out.println(arrNo);
*/
		// [list]
		ArrayList<String> noList = new ArrayList<>(Arrays.asList(arrNo));
		for(int i=0; i<noList.size(); i++) {
			if(i <= 7) {
			System.out.print(noList.get(i));
		} else {
			System.out.print("*");
			}
		}
	}
	
		
	
	
	/*
	 * 사용자가 입력한 단어를 거꾸로 뒤집어서 출력하세요. 
	 * 
	 * 단어 입력 : programming
	 * gnimmargorp
	 * 
	 * */
	public void method5() {
		
		System.out.print("단어 입력 : ");
		String input = sc.nextLine();
		
		//char[] arr = input.toCharArray();
		String[] arr = input.split("");
		
/*
		// [for문]
		for(int i = arr.length-1; i>=0; i--) {
			System.out.print(arr[i]);
		} 
*/
		ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
		Collections.reverse(list);
		for(String s : list) {
			System.out.print(s);
		}
	}	
	
	
	public static void main(String[] args) {
		ArrayPractice a = new ArrayPractice();
		//a.method1();
		//a.method2();
		//a.method3();
		//a.method4();
		a.method5();
	}
}
