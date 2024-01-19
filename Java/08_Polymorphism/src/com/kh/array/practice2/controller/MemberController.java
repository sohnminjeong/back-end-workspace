package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Member;

public class MemberController {
	
	private Member[] mArr = new Member[3];
	public int count = 0;
	
	
// 멤버 추가 
	public void insertMember(Member m) {
//		mArr[count] = new Member();
//		mArr[count].setId(id);
//		mArr[count].setName(name);
//		mArr[count].setPassword(password);
//		mArr[count].setEmail(email);
//		mArr[count].setGender(gender);
//		mArr[count].setAge(age);
		
		mArr[count++] = new Member(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge());
//		count += 1;
		System.out.println(Arrays.toString(mArr)); // 임시 확인용
	}

	
	
	
	
	
	public String printMem() {
			return Arrays.toString(mArr);
//		return mArr[0].toString();
		
	}
	
	public void updateMem(String id, String name, String email, String password) {
		
		mArr[0].setId(id);
		mArr[0].setName(name);
		mArr[0].setEmail(email);
		mArr[0].setPassword(password);
	
	}
	
	
	
}
