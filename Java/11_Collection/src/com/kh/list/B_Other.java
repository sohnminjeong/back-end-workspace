package com.kh.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class B_Other {

	public static void main(String[] args) {
		
		B_Other b = new B_Other();
		//b.method1();
		//b.method2();
		b.method3();
	}
	
	/*
	 * Vector
	 * - 동기화된(synchronized) 메서드로 구성 (개념을 스레드를 알아야 함! 뒤에서~)
	 * */
	public void method1() {
		Vector v = new Vector();
		// 이미 존재하고 있는 것(ArrayList와 비슷)
		v.add(0);
		v.add(1);
		System.out.println(v);   // [0, 1]
		System.out.println("size : "+v.size());   // 2
		System.out.println("capacity : " + v.capacity());    // 10 -> capacity는 기본이 10
		
		v.trimToSize();
		
		System.out.println("size : "+v.size());   // 2
		System.out.println("capacity : " + v.capacity());    // 2 -> trimToSize로 용량을 사이즈에 딱 맞춤
	}

	// 스택(Stack) : 마지막에 저장한 것을 제일 먼저 꺼내는 LIFO(Last In First Out) 구조 
	public void method2() {
		
		Stack s = new Stack();
		// Stack은 import하면 바로 사용 가능
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.pop(); // 꺼내는 메서드
		s.push(4);
		s.pop();
		s.push(5);
		s.push(6);
		s.push(7);
		s.pop();
		System.out.println(s);   //[0, 1, 2, 5, 6]
	}
	
	// 큐(Queue) : 처음에 저장한 것을 제일 먼저 꺼내는 FIFO(First In First Out) 구조 
	public void method3() {
		
		// 큐는 class가 아닌 interface임으로 객체 생성이 안된다. 
		// 참조변수(데이터타입)으로는 쓸 수 있지만 객체 생성은 X
		Queue q = new LinkedList();
		// Queue()대신 LinkedList() 사용 -> list 계열 중 하나 
		
		q.offer(0); // 넣을 때는 offer, add
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.poll();  // 뺄 때는 poll, remove
		q.add(4); 
		q.remove();
		q.add(5);
		q.add(6);
		q.add(7);
		q.remove();
		
		System.out.println(q); // [3, 4, 5, 6, 7]
		
		
	}
}
