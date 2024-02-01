package com.kh.socket3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
	
	Socket socket; // 사용해야 하니 변수 지정 
	Scanner sc = new Scanner(System.in);
	
	public SendThread(Socket socket) {
		// socket정보를 사용해야 함으로 이것을 매개 변수로!
		this.socket = socket;
	}
	
	public void run() {
		try {
			PrintStream ps = new PrintStream(socket.getOutputStream());
			// printStream : 보조 스트림
			// getOutputStream은 try-catch 잡아야 함 
		
			while(true) {
			// 무한루프
				ps.println(sc.nextLine());   // 작성한 한 줄 씩 보내야 함
				ps.flush();  // <-- 보낼때마다 마무리 필요
				
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
