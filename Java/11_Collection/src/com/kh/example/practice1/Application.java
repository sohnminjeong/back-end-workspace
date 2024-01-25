package com.kh.example.practice1;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Arrays;

import com.kh.list.model.Person;

public class Application {

	public static void main(String[] args) {
		
		// set은 중복안들어가고 순서 상관없음 -> TreeSet은 정렬해줌 
		// HashSet으로 할 경우 무작위 ->.equals할 경우 배열 안 위치가 달라도 숫자가 같으면 같다고 함!
		// ArrayList는 숫자와 위치 둘다 맞춰줘야 함! -> Collections.sort()이용해서 둘다 정렬 후 .equals()로 같은지 확인해야 함
		// ArrayList는 중복처리를 해주지 않기 때문에 조건이 달라짐! 
		// ==> int num = 런덤값; if(!lotto.contains(num)){lotto.add(num);} 필요 (랜덤값이 배열안에 포함되어있지x경우에만 해당랜덤값!)
		
		
		//[로또 번호]
		HashSet lotto = new HashSet();
		for (int i = 0; lotto.size() < 6; i++) {
			// i<6이 아닌 lotto의 사이즈를 다 채워야 함으로 lotto.size()<6으로 잡아야 함!
			lotto.add((int) (Math.random() * 45 + 1));
		}
		//for 대신 while문도 가능
		
/*		
 		TreeSet<Integer> lotto = new TreeSet<>(); 
 		while(lotto.size() < 6) {
			int num = (int)(Math.random() * 45 + 1);			
			lotto.add(num);
		}
*/
		
		//[내 로또 번호]
		HashSet myLotto = new HashSet();  
				
		boolean check = true;
		int count = 0;
		
		while(check) {
			System.out.println("로또 번호 : " + lotto);
			count++;
			
			for (int i = 0; myLotto.size() < 6; i++) {
				myLotto.add((int) (Math.random() * 45 + 1));
			} System.out.println("내 번호 : " + myLotto);
			
			if(myLotto.equals(lotto)) {check = false;} 
			else {
				myLotto.clear();
			}
		}
		System.out.println("횟수 : " + count);
		
		
/*	[강사님]	
		int count=0;
		while(true) {
			TreeSet<Integer> myLotto = new TreeSet<>();
			
			while(myLotto.size()<6) {
				int num = (int)(Math.random() * 45 + 1);
				myLotto.add(num);
			}
			
			System.out.println("로또 번호 : " + lotto);
			System.out.println("내 번호 : " + myLotto);
			
			// 멈추는 조건 : 로또 번호와 내 번호가 정확히 일치! 
			if(lotto.equals(myLotto)) {
				System.out.println("횟수 : "+ count);
				break;
			}
		}
*/		
	
	}
}

