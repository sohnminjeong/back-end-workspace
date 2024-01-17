package com.kh.example.practice1.model;

public class Member {
	public String memberId;
	public String memberPwd;
	public String memberName;
	public int age;
	public char gender;
	public String phone;
	public String email;
	
	public void changeName(String name) {
		// void = 리턴타입
		// 매개변수 : String 타입의 name
		memberName = name;
	}
	
	public void printName() {
		// 리턴타입은 void이며 매개변수는 없음 
		System.out.println(memberName);
	}
	
}
