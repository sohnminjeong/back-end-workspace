package com.kh.socket3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattServer {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(3000);
			// ServerSocket에 매개변수 port번호 담고 try-catch 잡기
			System.out.println("클라이언트 기다리는 중...!");

			while (true) {
				// 한명이 아닌 여러명을 받았기 때문에 승인에 반복문 필요
				Socket socket = serverSocket.accept();
				// 클라이언트가 접속할 때 마다 새로운 스레드 생성
				ClientThread client = new ClientThread(socket);
				client.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
