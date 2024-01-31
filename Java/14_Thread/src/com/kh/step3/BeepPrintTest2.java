package com.kh.step3;

import java.awt.Toolkit;

public class BeepPrintTest2 {

	public static void main(String[] args) {
		
		// main 스레드 하나, 작업 스레드 하나로도 사용 가능 
		// 소리는 메인에서, 글자는 스레드로!
		
		TextThread text = new TextThread();
		Thread tt = new Thread(text);
		tt.start();
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		// 경고음 5번 울리는 작업
		for(int i=0; i<5; i++){
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//[해당부분은 thread로]
//		// 띵띵띵띵띵을 5번 출력하는 작업
//		for(int i=0; i<5; i++) {
//			System.out.println("띵~~");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	
	}

}
