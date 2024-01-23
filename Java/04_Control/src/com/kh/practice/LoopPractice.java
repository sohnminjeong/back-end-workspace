package com.kh.practice;
import java.util.Arrays;
import java.util.Scanner;
class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		LoopPractice l = new LoopPractice();
//		 l.method1();
//		 l.method2();
//		 l.method3();
//		 l.method4();
//		 l.method5();
		 l.method6();
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
    	
/*    	// [강사님]
    	System.out.print("사용자 입력 : ");
    	int num = sc.nextInt();
    	for(int i=num; i>=1; i--) {
    		System.out.println(i);
    	}
 */
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
    	
/*    // 강사님
    int sum = 0;
    int num = 1;
    while(sum<100) {
    	if(num%2 == 0) {
    		sum -= num;
    	}else {
    		sum+=num;
    	}
    	if(sum>=100) {
    		break;
    	}
    	num++;
    }
    System.out.println("총 합이 100 이상이 되려면 " + num + "까지 더해야 한다");
*/    
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
    			
    	int count = 0;
    	for(int i=0; i<text.length(); i++) {
    		if(ch1 == text.charAt(i)) {
    			count++;
    		}
    	}
    	System.out.println(text+" 안에 포함된 "+ch1+" 개수 : "+count);
    	
 /*   	// 강사님
    	System.out.println("문자열 : ");
    	String str = sc.nextLine();
    	System.out.println("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	
    	int count = 0;
    	
    	[일반for문]
    	for(int i=0; i<str.length(); i++) {
    		if(ch == str.charAt(i)) {
    			count++;
    		}
    	}
    	
    	[향상된 for문] => for(아이템 하나씩 : 배열) {}
    	// str.toCharArray() : 문자열을 문자 배열로 바꾸는 함수 
    	for(char s : str.toCharArrya()){
    		if(ch == s) count++;
    	}
    	
    	System.out.println(str + "안에 포함된 " + ch + " 개수 : " + count);
  */  	
    	
    	
    	
    }

    /*
        4. 0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)   // 기존 : 0 <= Math.random < 1
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
    		int random = (int)(Math.random()*11);
    		System.out.println(random);
    		if(random == 0) {
    			break;
    		}
    	}
    	
    
/*    	// 강사님
    	while(ture) {
    		int random = (int)(Math.random()*11);
    		System.out.println(random);
    		if(random == 0) break;
    	} 
 */  	
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
    	  	
     	int count1 = 0;
    	int count2 = 0;
    	int count3 = 0;
    	int count4 = 0;
    	int count5 = 0;
    	int count6 = 0;
	
    	for(int i = 0; i < 10 ; i++ ) {
    		int random = (int) (Math.random()*6)+1;     // random은 1부터 6까지

    		if(random == 1) {
    			count1++;
    		} else if(random == 2) {
    			count2++;
    		} else if(random == 3) {
    			count3++;
    		} else if(random == 4) {
    			count4++;
    		} else if(random == 5) {
    			count5++;
    		} else if(random == 6) {
    			count6++;
    		} 
    	}
    	
    	System.out.println("1 : " + count1);
    	System.out.println("2 : " + count2);
    	System.out.println("3 : " + count3);
    	System.out.println("4 : " + count4);
    	System.out.println("5 : " + count5);
    	System.out.println("6 : " + count6);

    	//강사님
/*    	int[] dice = new int[6];   //6개짜리 배열 만들기
    	for(int i=0; i<10; i++) {
    		int random = (int)(Math.random()*6+1);
    		
    		switch(random) {
    		case 1: 
    			dice[0] ++;
    			break;
    		case 2:
    			dice[1] ++;
    			break;
    		case 3 :
    			dice[2] ++;
    			break;
    		case 4 : 
    			dice[3] ++;
    			break;
    		case 5 : 
    			dice[4] ++;
    			break;
    		case 6 :
    			dice[5] ++;
    			break;
    		}
    	}
    	for(int i=0; i<dice.length; i++) {
    		System.out.println((i+1)+ " : " + dice[i]);
    	}
   	
    	int[] dice = new int[6];   //6개짜리 배열 만들기
    	for(int i=0; i<10; i++) {
    		int random = (int)(Math.random()*6);  // 0부터 6까지 -> 총 6개(0,1,2,3,4,5)
    		dice[random]++;
    		
    	}
    	for(int i=0; i<dice.length; i++) {
    		System.out.println((i+1)+ " : " + dice[i]);
    	}
 */   	
 	
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
    	/*
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
    	int count1 = 0;
    	int count2 = 0;
    	int count3 = 0;
    	
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
    			count1++;
    		} else if( (player.equals("바위") && computer.equals("가위")) 
    					|| (player.equals("가위") && computer.equals("보")) 
    					|| (player.equals("보") && computer.equals("바위")) ) {
    			System.out.println("이겼습니다!");
    			count2++;
    			System.out.printf("비긴 횟수 : %d, 이긴 횟수 : %d, 진 횟수 : %d", count1, count2, count3);
    			break;
    		} else {
    			System.out.println("졌습니다 ㅠㅠ");
    			count3++;
    		}
    		System.out.println();
    	}
    	*/
    	
    	// 강사님
    	
    	String[] rps = {"가위", "바위", "보"};
    	int win = 0;
    	int lose = 0;
    	int draw= 0;
    	
    	System.out.print("당신의 이름을 입력해주세요 : " );
    	String name1 = sc.nextLine();
    	
    	while(true) {
    		System.out.print("가위바위보 : ");
    		String input = sc.nextLine();
    		
    		// 0 : 가위, 1 : 바위, 2 : 보
    		int computer = (int) (Math.random() * 3);  
    		System.out.println("컴퓨터 : " + rps[computer]);
    		
    		int number = Arrays.asList(rps).indexOf(input);
    		// 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값의 인덱스번호 찾기!
    		System.out.println(name1 + "사용자 : " + rps[number]);
    			
    		if(computer == number) {
    			// 비겼을 경우
    			System.out.println("비겼습니다.");
    			draw++;
    		} else if((number == 0 && computer == 2) || (number == 1 && computer == 0) || (number == 2 && computer == 1)) {
    			// 이겼을 경우
    			System.out.println("이겼습니다 !");
    			win++;
    			break;
    		} else {
    			// 졌을 경우
    			System.out.println("졌습니다 ㅠㅠ");
    			lose++;
    		}
    	}
    	System.out.println("비긴 횟수 : " + draw + ", 진 횟수 : " + lose + ", 이긴 횟수 : " + win);
    }
    }
    

