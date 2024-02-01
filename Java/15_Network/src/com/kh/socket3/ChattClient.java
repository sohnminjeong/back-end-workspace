package com.kh.socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattClient {

	public static void main(String[] args) {
		
		// ip주소, 포트번호를 매개변수로 Socket에 담아야 함
		try {
			Socket socket = new Socket("192.168.10.51", 3000);
			// Socket작성 후 try-catch 잡기
			System.out.println("서버와 연결되었습니다..");
			
			// 만든 SendThread 불러 시작하기 
			Thread sendThread = new SendThread(socket); // 작성한 sendThread를 Thread로 담기
			sendThread.start();  // sendThread 진행
			
			// bufferedreader에 담기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(br != null) {  // null이 되기 전까지 바로 읽어오기 
				System.out.println(br.readLine());
			}
			
			
		}catch (IOException e) {
			System.out.println("서버 종료...!");
		}
		
	}

}
