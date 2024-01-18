package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController {
	private Employee employee = new Employee();
	
	// 오버로딩!! 매개변수는 같은데 갯수와 타입이 다른 경우~
	public void add(int empNo, String name, char gender, String phone) {
		// void가 리턴타입이면 반환값 필요 없다
		// 임시저장공간 -> 세터방식!(employee생성자를 위해서 했기 때문)
		employee.setempNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
	}
	
	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		employee.setempNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setSalary(salary);
		employee.setBonus(bonus);
	}
	
	public void modify(String phone) {
		employee.setPhone(phone);
	}
	
	public void modify(int salary) {
		employee.setSalary(salary);
	}
	
	public void modify(double bonus) {
		employee.setBonus(bonus);
	}
	
	public Employee info() {
		// class 타입 자체를 반환값으로 처리할 수 있다 
		// 매개변수를 받지 않기 때문에 return이 필요함
		// 객체 타입이 employee라는 뜻 (객체 그대로 넘기면 됨)
		return employee;
	}
}
