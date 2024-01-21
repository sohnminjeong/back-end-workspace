package com.kh.array.practice2.controller;

import java.util.Arrays;

import com.kh.array.practice2.model.Members;

public class MemberControllers {
	
	public int count = 0;
	private Members[] mArr = new Members[3];
	
	public void insertMember(Members m) {
		
		/*
		mArr[count].setId(id);
		mArr[count].setName(name);
		mArr[count].setPassword(password);
		mArr[count].setEmail(email);
		mArr[count].setGender(gender);
		mArr[count].setAge(age);
			count+=1;
		*/
		mArr[count++] = new Members(m.getId(), m.getName(), m.getPassword(), m.getEmail(), m.getGender(), m.getAge());
//		System.out.println(Arrays.toString(mArr)); 확인용
		
		
	}
	/*
	// 아이디가 중복인 경우
		public boolean idCheck(String id) {
			for(Members m : mArr) {
				if(m != null && m.getId().equals(id)) {
					return true;
				}
			}
			return false;
		}
	*/
	// 아이디가 있는, 없는 경우 -> 배열의 index번호로 찾기
	public int idCheck(String id) {
		for(int i = 0; i < mArr.length; i++) {
			if(mArr[i] != null && mArr[i].getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public void updateMember(String id, String name, String email, String password) {
		
		int index = idCheck(id);   // 아이디 중복 유무 확인 시 중복의 경우 true값이 i이기 때문
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPassword(password);
		
	}
	
	// 반환형이 Members[] 
	public Members[] printAll() {
		return mArr;
	}
}
