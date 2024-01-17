
// MVC : model view controller 
// -> mvc패턴 : model(variable과column이 1대1매칭), view(화면), 
// controller(모델과 뷰 사이 / 기능개발 담당)다 따로 class 생성 

package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;

public class Application {
	
	
	public static void main(String[] agrs) {
	// ------------------------------------------------화면------------------------------------
		Scanner sc = new Scanner(System.in);

	
	System.out.println("스낵류를 입력하세요.");
	System.out.print("종류 : ");
	String kind = sc.nextLine();

	
	System.out.print("이름 : ");
	String name = sc.nextLine();

	
	System.out.print("맛 : ");
	String flavor = sc.nextLine();

	
	System.out.print("개수 : ");
	int numOf = Integer.parseInt(sc.nextLine());

	
	System.out.print("가격 : ");
	int price = Integer.parseInt(sc.nextLine());
	// --------------------------------------------------------------------------------------
	// -> 즉, 여기서 controller나 model에 직접 접근X
	
	// 데이터를 서버한테 요청! 그럼 데이터를 서버한테 전달! 
	// 전달할 때 controller한테 전달하면 됨! 
	
	// SnackController 사용하려면 객체 생성하면 됨(import도 진행) 
	SnackController control = new SnackController();
	System.out.println(control.saveData(kind, name, flavor, numOf, price));
	
	// 서버한테 요청해서 응답받은 결과를 다시 화면으로! 
	System.out.println(control.confirmData());
	
	
	
	}
}
