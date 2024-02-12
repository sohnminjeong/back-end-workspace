package com.kh.array.practice2.controller;

import java.util.ArrayList;

import com.kh.array.practice2.model.Mem;

public class Controllers {

	Mem m = new Mem();
	ArrayList<Mem> list = new ArrayList<>();

	// 1. 새 회원 등록
	public void insert(String id, String name, String password, String email, char gender, int age) {
//		m.setId(id);
//		m.setName(name);
//		m.setPassword(password);
//		m.setEmail(email);
//		m.setGender(gender);
//		m.setAge(age);
		m = new Mem(id, name, password, email, gender, age);
		list.add(m);

	}

	// 2. 회원 정보 수정
	public void modify(String id, String name, String email, String password) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				list.get(i).setName(name);
				list.get(i).setEmail(email);
				list.get(i).setPassword(password);
			}
		}
	}

	public boolean idCheck() {
		return false;
	}

	// 3. 전체 회원 정보 출력
	public ArrayList<Mem> info() {
		return list;
	}

}
