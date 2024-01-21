package com.kh.array.practice2;

import java.util.Scanner;

import com.kh.array.practice1.model.Student;
import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	
	public static void main(String[] args) {
			
		Application app = new Application();
		app.mainMenu();
	}

	
	public void mainMenu() {
		
		/*[조건]
		 * 회원 수가 3명이 최대 등록 가능 
		 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다." 와 함께 
		 * "1. 새 회원 등록" 하지 못하게 -> 화면상 안보이게만 처리하셔도 됩니다
		 * 
		 * 1번인 경우 -> insertMember();
		 * 2번인 경우 -> updateMember()
		 * 3번인 경우 -> printAll()로 호출되게끔 
		 * 9번인 경우 -> 프로그램 종료
		 * 그 외의 경우 -> '잘못 입력하셨습니다. 다시 입력해주세요' 출력
		 * 
		 * */
		boolean check = true;
		while(check) {
			System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			System.out.println("현재 등록된 회원 수는 "+ mc.count +"명입니다");
			
			if(mc.count < 3) {
			System.out.println("1. 새 회원 등록");
			} else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1 : 
				if(mc.count<3) insertMember();
				break;
			case 2 : 
				updateMember();
				break;
			case 3 : 
				printAll();
				break;
			case 9 : 
				check = false;
				break;
			default : 
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
			}
		}
	}
	
	
	
	public void insertMember() {
		/* [조건]
		 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우 
		 * "중복된 아이디입니다. 다시 입력해주세요." 출력 후 
		 * 다시 아이디 입력부터 나올 수 있게 처리 
		 * */
		
		
		/* 2-2) [Member m = new Member(); 선언 후 모든 값을 setter방식으로 받기!] => mc.memberInsert2방식
		Member m = new Member();
		=> but : setter 방식으로 할 경우 "중복된 아이디 체크" 시 에러 발생! ->  기존대로 따로 받는 것 추천!  
		*/
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		// m.setId(sc.nextLine());
		
		
		// [아이디 중복 확인] if문 사용 -> 중복인 경우 : 경고문!, 중복이 아닌 경우 : 이름, 비밀번호 등 나머지 물어보는 문장 호출!
		// 기존 멤버 배열에 아이디가 있는 경우! 에 대한 메서드를 controller에 따로 만들기!
		// 중복된 상황이여야 함으로 checkId(id)가 중복이아닌(-1) 경우를 적어주어야 함
		if(mc.checkId(id) != -1) {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			// 중복된 아이디일 경우 다시 아이디 입력이 나오도록! => 본인 호출
			insertMember();
		} else {
			
			System.out.print("이름 : ");
			String name = sc.nextLine();
			// m.setName(sc.nextLine());
			
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			// m.setPassword(sc.nextLine());
		
			System.out.print("이메일 : ");
			String email = sc.nextLine();
			// m.setEmail(sc.nextLine());
		
			System.out.print("성별(M/F) : ");
			char gender = sc.nextLine().charAt(0);
			// m.setGender(sc.nextLine().charAt(0));
		
			System.out.print("나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			// m.setAge(Integer.parseInt(sc.nextLine()));
			
			
			// 1) 매개변수 & 생성자로 담아내기 => mc.insertMember1(매개변수) 사용 
			// mc.insertMember1(id, name, password, email,gender, age);
			
			// 2) 생성자 +  매개변수를 객체로 받아오기 => mc.insertMeber2(객체) 사용
            // => Member 객체 따로 생성!
			// => 각 정보를 set으로 받을 경우 : 상단에서 Member 객체 선언하고 각 값을 setter로 받음(바로 아래 문장은 필요x)
			Member m = new Member(id, name, password, email, gender, age);
			// => 매개변수로 멤버 객체를 통채로 넘겼다!
			mc.insertMember2(m);
			
		}
	}

	
	
	public void updateMember() {
		/* [조건]
		 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우 
		 * "회원 정보가 없습니다." 출력 후 다시 메인 화면으로 
		 * */
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		
		
		// 멤버 배열에 아이디가 없는 경우 -> mc.checkId1 이용 (insert에 경우에는 아이디가 있는 경우  였음!)
		// 회원의 아이디가 없는 경우임으로 -1인 경우를 뜻함
		if(mc.checkId(id) == -1) {
			System.out.println("회원 정보가 없습니다.");
			// else로 하는 것이 귀찮은 경우! -> return; 선언 시 다시 시작함
			return;
		}
		 
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.println("수정할 이메일 : ");
		String email = sc.nextLine();
		System.out.println("수정할 비밀번호 : ");
		String password = sc.nextLine();
		
		mc.updateMember(id, name, email, password);
	
		
	}
	public void printAll() {
		/* [조건]
		 * 전체 회원 정보 출력
		 * */
		Member[] mArr = mc.printAll();
		// 향상된 for문 사용 : for(데이터타입 변수 : 배열) {변수 : 배열의 값을 하나씩 가지고 옴}
		for(Member m : mArr) {
			// 저장된 값이 없는 경우엔 아무것도 x -> m이 null이 아닌 경우에만 m이 출력된다는 조건 걸기!
			if(m!=null) System.out.println(m);
		}
	}
	
}
