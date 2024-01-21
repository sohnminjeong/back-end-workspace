package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {
	
	private Member[] mArr = new Member[3];
	public int count = 0;
	
	
// 멤버 추가 
	public void insertMember(Member m) {

		mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge());
//		count += 1;
//		System.out.println(Arrays.toString(mArr)); // 임시 확인용
	}
	
	public void insertMember1(String id, String name, String password, String email, char gender, int age) {
			
		// 세터방식 
		/*
		mArr[count] = new Member();
		mArr[count].setId(id);
		mArr[count].setName(name);
		mArr[count].setPassword(password);
		mArr[count].setEmail(email);
		mArr[count].setGender(gender);
		mArr[count].setAge(age);
		count+=1;
		*/
		
		// 생성자 방식
		mArr[count++] = new Member(id, name, password, email, gender, age);
		// count+=1;
		
	}
	
	
	public void insertMember2(Member m) {
		
		// 매개변수를 객체로도 넘길 수 있음! -> 임시저장도구로만 생각! 
		// 1) Application에서 Member객체 생성 후 매개변수를 객체 통채로 받기
		// 2) insertMember1의 매개변수도 통으로 받아야 함으로 ()안에 매개변수가 아닌 Member m으로 들어가야 함
		// 3) 생성자 방식 활용 시 getter로 입력값 가져오기 
		
		mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge());
		
		
	}
		
	
	// 멤버가 있는지 없는지 아이디로 조회하는 메서드
	// => 멤버 index를 아이디로 조회 
	// 향상된 for문의 경우 index를 찾기 어렵기 때문에 기본 for문으로 변경!
	public int checkId(String id) {   // boolean이였으나 index번호가 메인이기 때문에 int로 변경 
		for(int i = 0; i<mArr.length; i++) {
			if(mArr[i] != null && mArr[i].getId().equals(id)) {
				return i;
				}
			}
		// index가 -1인 경우는 없으므로 return을 -1로 지정
		return -1;
		}
	
	/*
	public boolean checkId(String id) {
		// 향상된 for문 사용 : for(데이터타입 변수 : 배열) {변수 : 배열의 값을 하나씩 가지고 옴}
		for(Member m : mArr) {
			//System.out.println(m); // 처음에 값은 없기때문에 전부null로 표현됨 -> 조건을 걸어야 함
			if(m != null && m.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	*/
	
	
	// 멤버 수정
	public void updateMember(String id, String name, String email, String password) {
		
		int index = checkId(id);   //중복이 있는경우 checkId의 return값이 i이기 때문
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPassword(password);
		
	}
	
	// 멤버 조회 기능
	// mArr을 보내야 하고 이것의 return type은 Member[]!
	public Member[] printAll() {
		return mArr;
	}
	
	
}
