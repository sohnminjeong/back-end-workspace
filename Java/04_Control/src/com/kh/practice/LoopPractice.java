package com.kh.practice;
import java.util.Scanner;
class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		LoopPractice l = new LoopPractice();
		// l.method1();
		// l.method2();
		// l.method3();
		// l.method4();
		// l.method5();
	}
    /*
        1. 사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	
    	System.out.print("숫자(1~100) 1개 입력 > ");
    	int num = sc.nextInt();

    	for(int i = num; i >= 1; i--) {
    		System.out.println(i);
    	}
    }

    // 2. 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	int sum = 0;
    	for(int i = 1; i < 10; i++) {
    		if(i %2 != 0) {
    		sum += i;
    		System.out.println(sum);
    	} 
    	}
    }

    /*
        3. 사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.print("문자열 입력 : ");
    	String text = sc.nextLine();
    	System.out.print("문자 : ");
    	String ch = sc.nextLine();
    	char ch1 = ch.charAt(0);
    			
    	int num = 0;
    	for(int i=0; i<text.length(); i++) {
    		if(ch1 == text.charAt(i)) {
    			System.out.println(ch1);
    		}
    		// System.out.println(text+" 안에 포함된 "+ch1+" 개수 : "+num);
    	}
    	
    	
    	
    }

    /*
        4. 0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	
    	while(true) {
    		int random = (int)(Math.random()*10);
    		System.out.println(random);
    		if(random == 0) {
    			break;
    		}
    	}
    }

    /*
        5. 주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0


			// Math.random() // 0.0 * 6 <=Math.random() < 1.0 * 6
    		                 // 0.0 + 1 <= Math.random() < 6.0 + 1
    		                 // 1.0 <= Math.random() < 7.0
     */
    public void method5() {
    	/*
    	for(int i = 1; i<= 10; i++) {
    		int random = (int) (Math.random()*6)+1;  
    		System.out.println(random);
    	}
    	*/
    	
    	
    	for(int j = 1; j <= 6; j++) {
    		for(int i = 1; i<= 10; i++) {
        		int random = (int) (Math.random()*6)+1;  
        		//System.out.println(random);
        	} 
    		
    		}
    		
    	}
    

    /*
        6. 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.


        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
    */
    public void method6() {

    }

}