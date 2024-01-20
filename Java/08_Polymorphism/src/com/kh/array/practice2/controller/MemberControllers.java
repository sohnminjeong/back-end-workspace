package com.kh.array.practice2.controller;

import com.kh.array.practice2.model.Members;

public class MemberControllers {
	
	public int count = 0;
	private Members[] mArr = new Members[3];
	
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		
		
		mArr[count].setId(id);
		mArr[count].setName(name);
		mArr[count].setPassword(password);
		mArr[count].setEmail(email);
		mArr[count].setGender(gender);
		mArr[count].setAge(age);
			count+=1;
			
		
			System.out.println(mArr);
	}
	
	public void updateMember() {
		
	}
	
	public void printAll() {
		
	}
}
