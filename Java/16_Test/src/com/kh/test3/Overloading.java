package com.kh.test3;

public class Overloading {
	public void test() {}
	public void test(String str, String s) {} //String s추가하여 매개변수 갯수 변경
	//2. 2와 4 에러 - 매개변수의 갯수1개로, 형태 String으로 동일하기 때문에
	public void test(int i) {}
	// 3. 3과 8에러 - 동일한 메서드가 있고 메서드명, 매개변수의 갯수, 형태까지 전부 동일하기 때문에 오버로딩도 되지 않음.
	public void test(String s) {}
	public void test(char ch) {}
	public void test(String str, int i) {}
	public void test(int i, String str) {}
	public void test2(int i) {}  //메서드명을 test에서 test2으로 변경
	public int test1() {return 0;}
	// 1. 1과 9 - 동일 메서드명, 매개변수의 갯수와 형태까지 전부 동일하기 때문에 오버로딩 되지 않음.
}
