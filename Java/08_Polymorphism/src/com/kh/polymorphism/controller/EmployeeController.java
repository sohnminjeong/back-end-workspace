package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.parent.Employee;

public class EmployeeController {

	
	// [이름으로 사람 찾기] 
	public Employee findEmployeeByName(String name, Employee[] empArr) {
		for(Employee employee : empArr) {
			if(employee.getName().equals(name)) {
				return employee;
			}
		}
		return null;
	}		
	
	
	
	// [찾은 사람의 연봉은? --> 한 사람의 연봉을 찾는 기능]
	public int getAnnualSalary(Employee result) {
		// result라는 변수명 대신 다른 것도 가능! eX) e로 할 경우 result가 적힌 것 전부 e로 바꿔야 함.
		int annualSalary = result.getSalary() * 12;
		// result의 타입인 Employee 그대로 넘기기 
		// instanceof -> result가 engineer인 경우
		if(result instanceof Engineer) {
			// Engineer 객체 만들기 -> result의 강제 형 변환(result>engineer) 부모->자식
			Engineer engineer = (Engineer) result;  
			return annualSalary + engineer.getBonus();  // 김영철의 경우 보너스때문에 제외됨
		} else {
			return annualSalary;
			// 아닌 경우가 이미 적혀있기 때문에 처음에 적었던 return은 필요가 없다.
		}
	}
	
	/*
	 * instanceof : 객체 타입을 확인하는 연산자 -> true, false로 반환
	 * -> 선언 방식 : '객체 instanceof 클래스'
	 * */
	
	// [전체 사람들의 연봉 총합은?]
	public int getTotalSalary(Employee[] empArr) {
		int sum = 0;
		for(Employee employee : empArr) {
			// empArr은 Application에 있기 때문에 밖에서 받아야 함
			sum += getAnnualSalary(employee);
			// 해당 getAnnualSalary는 같은 class에 있기 때문에 ec.붙이지 않아야 함!
		}
		return sum;
		// 각 연봉의 합계가 return이 되어야 함
	}
}
