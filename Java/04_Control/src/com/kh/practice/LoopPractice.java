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
		 l.method5();
		// l.method6();
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
    	int i = 0;
    	for(i = 1; sum<100; i++) {
    		if(i %2 != 0) {
    			sum += i;
    		} else {
    			sum -= i;
    		}
    	}
    	System.out.println("sum : "+sum);
    	System.out.println("몇까지 더해야 하는가 : "+ --i); 	
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
    	int count = 0;
    	for(int i=0; i<text.length(); i++) {
    		if(ch1 == text.charAt(i)) {
    			count++;
    		}
    	}
    	System.out.println(text+" 안에 포함된 "+ch1+" 개수 : "+count);
    	
    	
    	
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
    	//int random = 0;
//    	for(int i =1; i<=10; i++) {
//    		random = (int)(Math.random()*6)+1;
//    	}
    		//System.out.println();
    	/*
    	int count=0;
    	int count1=0;
    	int count2=0;
    	int count3=0;
    	int count4=0;
    	int count5=0;
    	for (int i =1; i<=6; i++) {
    		for(int j = 1; j <=10; j++) {
				random = (int) (Math.random()*6)+1;
				System.out.print(random);
			} if(i == 1 && i == random) {
    			count++;
    		} else if(i == 2 && i == random) {
    			count1++;
    		} else if(i == 3 && i == random) {
    			count2++;
    		} else if(i == 4 && i == random) {
    			count3++;
    		} else if(i == 5 && i == random) {
    			count4++;
    		} else if(i == 6 && i == random) {
    			count5++;
    		}
    		System.out.println(count);
    		System.out.println(count1);
    		System.out.println(count2);
    		System.out.println(count3);
    		System.out.println(count4);
    		System.out.println(count5);
    	}
    	*/
    	
    	for(int i = 0; i < 10 ; i++ ) {
    		int random = (int) (Math.random()*6)+1;     
    		
    	}
    	int count=0;
    	int count1=0;
    	int count2=0;
    	int count3=0;
    	int count4=0;
    	int count5=0;
    	for(int i=1; i<=10; i++) {
    		int random = (int)(Math.random()*6)+1;  
    		int r = random.nextInt(6)+1;
    		switch(r) {
    		case 1 : 
    			count++;
    			System.out.println("1 : "+count);
    			break;
    		case 2 :
    			count1++;
    			System.out.println("2 : "+count1);
    			break;
    		case 3 :
    			count2++;
    			System.out.println("3 : "+count2);
    			break;
    		case 4 :
    			count3++;
    			System.out.println("4 : "+count3);
    			break;
    		case 5 : 
    			count4++;
    			System.out.println("5 : "+count4);
    			break;
    		case 6 : 
    			count5++;
    			System.out.println("6 : "+count5);
    			break;
    		}
    	}
    	
    	
    	
    	
    }
    	
    	/*

    	int[] arr = new int[10];    	//자료형[] 배열명 = new 자료형[배열크기];
    	
    	for(int i = 0; i < 10 ; i++ ) {
    		int random = (int) (Math.random()*6)+1;     // random은 1부터 6까지
    		arr[i] = random;
    		// System.out.println(arr[i]);
    	}
    	
    	int count1 = 0;
    	int count2 = 0;
    	int count3 = 0;
    	int count4 = 0;
    	int count5 = 0;
    	int count6 = 0;
    	
    	for(int i = 0; i<10; i++) {
    		if(arr[i] == 1) {
    			count1++;
    		} else if(arr[i] == 2) {
    			count2++;
    		} else if(arr[i] == 3) {
    			count3++;
    		} else if(arr[i] == 4) {
    			count4++;
    		} else if(arr[i] == 5) {
    			count5++;
    		} else if(arr[i] == 6) {
    			count6++;
    		} 
    	}
    	System.out.println("1 : " + count1);
    	System.out.println("2 : " + count2);
    	System.out.println("3 : " + count3);
    	System.out.println("4 : " + count4);
    	System.out.println("5 : " + count5);
    	System.out.println("6 : " + count6);

    	}
    	*/
    
    

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
    	
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
    	while(true) {
    		System.out.print("가위바위보 : ");
    		String player = sc.nextLine();
    		
    		int random = (int)(Math.random()*3);
    		String computer = "";
    		// 가위 : 0 / 바위 : 1 / 보 : 2
    		if(random == 0) {
    			computer = "가위";
    		} else if(random == 1) {
    			computer = "바위";
    		} else {
    			computer = "보";
    		}
    		System.out.println("컴퓨터 : " + computer);
    		System.out.println(name + " : " + player);
    		
    		
    		if( player.equals(computer) ) {
    			System.out.println("비겼습니다.");
    		} else if( (player.equals("바위") && computer.equals("가위")) 
    					|| (player.equals("가위") && computer.equals("보")) 
    					|| (player.equals("보") && computer.equals("바위")) ) {
    			System.out.println("이겼습니다!");
    			break;
    		} else {
    			System.out.println("졌습니다 ㅠㅠ");
    		}
    		System.out.println();
    	}
    	
    }
    }
    

