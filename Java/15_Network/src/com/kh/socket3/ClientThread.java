package com.kh.socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientThread extends Thread {

	Socket socket;
	BufferedReader br; // br을 메서드 2개에서 사용해야 함으로 바깥에서 먼저 선언

	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());

	public ClientThread(Socket socket) {
		this.socket = socket;

		try {
			// 클라이언트에서 서버로 - 스트림 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 서버에서 클라이언트로 - 스트림 생성
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			// printwriter(socket.getOutputStream)로 보냄
			list.add(pw); // 받은 것을 list에 추가 (list는 크게 사용됨으로 ClientThread메서드 밖에서 호출

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sendAll(String message) {
		// list에 모든 정보 담고 있어야 함
		for (PrintWriter pw : list) {
			pw.println(message);
			pw.flush();
		}
	}

	public void run() {
		try {
			String login = socket.getInetAddress() + "님이 접속하셨습니다.."; // getInetAddress : 해당 사람의 ip주소
			System.out.println(login);
			sendAll(login); // 누가 접속했는지에 대한 정보 담기

			while (br != null) {
				String line = "[" + socket.getInetAddress() + "] 가 보낸 메세지 : " + br.readLine();   // try-catch 필요(크게잡기)
				System.out.println(line);   // 서버에 출력
				sendAll(line);   // 클라이언트한테 보냄 
				
			}
		} catch (IOException e) {
			System.out.println(socket.getInetAddress() + "님이 나가셨습니다..");
		}

	}
}
