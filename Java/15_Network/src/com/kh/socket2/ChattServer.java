package com.kh.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트가 보낸 메세지를 받아서 다시 클라이언트에게 받은 메시지를 보낸다

/*
 * 서버측 로직
 * 1. ServerSocket 생성 - port : 60000 (시험문제는 1번까지만 알면 됨)
 * 2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket을 하나 리턴
 * 3. 소켓으로부터 스트림 리턴 
 * */

public class ChattServer {

	public static void main(String[] args) {
		try {
			// 1. ServerSocket 생성 port : 60000
			ServerSocket server = new ServerSocket(60000);
			System.out.println("Server Ready..");

			// 2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket을 하나 리턴
			Socket s = server.accept();
			System.out.println(s.getInetAddress() + "님이 접속하셨습니다..");

			// 3. 소켓으로부터 스트림 리턴
			// 클라이언트가 보낸 메세지를 받아서
			// BufferedReader, InputStreamReader, <- s.getInputStream
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//클라이언트가 적은 메세지를 스트림으로 받은 걸 bufferedReader에 담음 

			// 다시 클라이언트에게 받은 메시지를 보낸다
			// PrintWriter <- s.getOutputStream
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);  // 누적되어야 함으로 true 사용 

			String line = null;
			//Buffered이기 때문에 line으로 한줄씩 가져올 수 있음 
			while ((line = br.readLine()) != null) {
				System.out.println("[" + s.getInetAddress() + "] 가 보낸 메세지 : " + line);
				pw.println(line);  // 한줄씩 보내버리기 
			}

		} catch (Exception e) {
			System.out.println("Client와 연결이 끊겼습니다..");
		}
	}

}
