package com.kh.test7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
	
		try {
			ServerSocket server = new ServerSocket(3000);
			// 1. 서버쪽에 ServerSocket()에서 괄호 안에 포트번호 작성해야 함.
			Socket s = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
