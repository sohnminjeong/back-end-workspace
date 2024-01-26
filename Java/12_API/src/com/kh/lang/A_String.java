package com.kh.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_String {

	public static void main(String[] args) {
		
		A_String a = new A_String();
		//a.method1();
		//a.method2();
		//a.method3();
		a.method4();
	}
	
	/*
	 * String 클래스
	 * - 불변의 클래스 (객체를 생성하면 변경 X)
	 * - 변경이 적고 읽기가 많은 경우에 사용하는 것이 좋다 
	 * - new 없이도 객체를 생성할 수 있는 유일한 객체 
	 * */
	public void method1() {
		// 문자열 리터럴과 new 연산자로 생성된 문자열 비교 
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		//객체생성 방식도 사용 가능
		String str4 = new String("hello");
		
		System.out.println("str1 == str2 : " + (str1 == str2));  // true
		// str1,2는 String pool에 있는 같은 값을 가리킨다 
		System.out.println("str1 == str3 : " + (str1 == str3));  // false
		// str1은 String pool에 있는 것! str3, str4는 다른 영역! (3과 4도 각각 다른 영역에 있음)
		System.out.println("str3 == str4 : " + (str3 == str4));  // false
		//equals는 object에 있는 메서드로 string클래스에서 equals를 재정의 함! -> 같으면 같은 것!
		System.out.println("str1.equals(str2) : " + str1.equals(str2));  // true
		System.out.println("str1.equals(str3) : " + str1.equals(str3));  // true
		System.out.println("str3.equals(str4) : " + str3.equals(str4));  // true
		
	}
	
	// String 클래스에서 제공하는 메서드
	public void method2() {
		String str = "Hello, Java!";
		
		// 메서드 : return 타입 - 설명
		// 1. charAt(int index) : char 
		// - 전달받은 index 위치의 하나의 문자만 추출해서 리턴하는 메서드
		char ch = str.charAt(3);
		System.out.println("ch : " + ch);   // l
		
		// 2. concat(String str) : String 
		// - 전달받은 문자열과 원본 문자열을 하나로 합친 새로운 문자열을 생성해서 리턴
		String str2 = str.concat("!!!!!");
		// = str2 = str + "!!!!!";
		System.out.println("str2 : " + str2);   // Hello, Java!!!!!!
		
		// 3. substring(int beginIndex) : String
		// - 문자열의 beginIndex 위치에서부터 끝까지의 문자열을 새로 생성해서 리턴 
		// substring(int beginIndex, int endIndex) : String
		// - 문자열의 beginIndex 위치에서부터 endIndex-1까지 
		String str3 = str.substring(6);
		String str4 = str.substring(2, 7);
		System.out.println("str3 : " + str3);     //_Java!
		System.out.println("str4 : " + str4);     //llo,_ 
		
		// 4. idnexOf(String str) : int
		// - 전달받은 str의 시작 인덱스를 리턴 (포함되어 있지 않으면 -1)
		int index = str.indexOf("!");
		System.out.println("index : " + index);   // 11
		
		int index2 = str.indexOf("Java");
		System.out.println("idnex2 : " + index2);    // 7 : Java의 J로 확인 
		
		int index3 = str.indexOf("?");
		System.out.println("index3 : " + index3);    // -1 : 포함되어 있지 않기때문
		
		// 5. replace(char oldChar, char newChar) : String
		// - 문자열에서 Old 문자를 new 문자로 변경된 새로우누 문자열을 생성해서 리턴
		String str5 = str.replace('l', 'c');
		System.out.println("str5 : " + str5);    // Hecco, Java!
		
		// 6. toUpperCase() / toLowerCase() : String
		// - 문자열을 모두 대/소문자로 변경한 새로운 문자열을 생성해서 리턴 
		String str6 = str.toUpperCase();
		String str7 = str.toLowerCase();
		System.out.println("str6 : " + str6);   // HELLO, JAVA!
		System.out.println("str7 : " + str7);   // hello, java!
		
		// 7. trim() : String
		// - 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성해서 리턴 
		String str8 = "          Hello,            Java!         ";
		System.out.println("trim 전 : " + str8);   //            Hello,            Java!
		String str9 = str8.trim();
		System.out.println("trim 후 : " + str9);   // Hello,            Java!
		
		// 8. toCharArray() : char[]
		// - 문자열의 문자들을 문자 배열에 담아서 해당 배열의 주소값 리턴 
		char[] arr = str.toCharArray();
		ArrayList<char[]> arrList = new ArrayList<>();
		// char만 char[]로 표현 
		System.out.println(arr);    // Hello, Java!
		System.out.println(Arrays.toString(arr));   // [H, e, l, l, o, ,,  , J, a, v, a, !]
		
		// 9. static valueOf(문자 배열) : String
		// - 문자열로 변경해서 리턴
		String str10 = String.valueOf(arr);
		System.out.println(str10);    // Hello, Java!
		
		System.out.println("str : " + str);  // str자체는 변경x 
	}
	
	/*
	 * StringBuilder & StringBuffer
	 * - 가변의 클래스 : String 클래스와 달리 내부의 문자열을 수정할 수 있다 
	 * - 16개의 문자를 저장할 수 있는 버퍼가 미리 생성되고 문자가 저장됨에 따라 자동 증가
	 * - StringBuilder : 동기화 x -> 단일 스레드 환경 권장
	 * - StringBuffer : 동기화 O -> 멀티 스레드 환경 권장
	 * */
	public void method3() {
		StringBuilder sb = new StringBuilder("Hello, ");
		
		// 1. append(String str) : StringBuilder
		// - 기존 문자열 뒤에 문자열 추가 (concat과 같은 역할)
		sb.append("World!");
		// System.out.println(sb);   // Hello, World!
		
		// 2. insert(int offset, String str) : StringBuilder
		// - 문자열의 offset 위치부터 전달받은 문자열 추가 
		sb.insert(1, "eeeee");
		//System.out.println(sb);   // Heeeeeello, World!
		
		// 3. delete(int start, int end) : StringBuilder
		// - start에서 end-1까지의 인덱스에 해당하는 문자열 삭제 
		sb.delete(1, 6);
		// System.out.println(sb);  // Hello, World!  (위에서 추가된 eeeee들이 빠짐)
		
		// 4. reverse() " StringBuilder
		// - 문자열의 순서를 역으로 바꾼다
		sb.reverse();
		System.out.println(sb);   // !dlroW ,olleH
		
		// 메서드 체이닝 : 메서드를 이어서 쓸 수 있다!
		StringBuilder sb2 = new StringBuilder("Java Program");
		sb2.delete(5, 12).append("API").reverse();
		System.out.println(sb2);   // IPA avaJ	
	}
	
	/*
	 * StringTokenizer
	 * - java.util 패키지에서 제공하는 클래스
	 * - 객체 생성 시 생성자로 전달받은 문자열을 구분자로 이용하여 분리 
	 * - 분리된 최소 단위를 토큰이라고 부른다  
	 * */
	public void method4() {
		
		String str = "HTML,CSS,JavaSCript,MySQL,Java,JDBC,Servlet,JSP,jQuery,MyBatis,Spring,React";
		
		// 1. String 클래스의 split 메서드를 이용 
		// split(String regex) : String[]
		// - 입력받은 구분자로 문자열을 분리해서 문자열의 배열로 담아서 리턴 
		String[] strArr = str.split(",");
		System.out.println("과목 개수 : " + strArr.length);
		for(String s : strArr) {
			System.out.println(s);
		}
		
		// StringTokenizer 객체 이용
		StringTokenizer st = new StringTokenizer(str, ",");
		// countTokens : 꺼내지 않고 남아있는 토큰의 수를 확인 
		System.out.println("과목 개수 : " + st.countTokens());   // 12
		System.out.println(st.hasMoreElements());  // true
		// hasMoreTokens() : 남아 있는 토큰이 있는지 확인  -> 있으면 true, 없으면 false
		System.out.println(st.nextToken());  // HTML
		// nextToken : 토큰을 하나씩 꺼내옴 
		/*while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}*/
		
		System.out.println("꺼내고 남은 과목 개수 : " + st.countTokens());   // 0
		
	}
	
	
	
	
	
	
	
	
}
