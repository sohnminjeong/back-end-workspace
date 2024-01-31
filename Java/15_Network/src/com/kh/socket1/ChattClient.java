package com.kh.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ChattClient {
	public static void main(String[] args) {
		try {
			
			InetAddress ip = InetAddress.getLocalHost();
			// 1. 소켓 생성 - ip주소와 port 번호
			Socket s = new Socket(ip.getHostAddress(), 60000);
			System.out.println("Client Socket Creating...");
			
			// 2. 스트림
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// 키보드에 입력한 걸 읽어드리는 것!
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			
			System.out.println("Client stream Creating...");
			
			String line = "";
			while((line = br.readLine())!=null) {
				pw.println(line);
			}
			
		}catch(Exception e) {
			System.out.println("서버와의 연결에 실패했습니다..");
		}
	}
}
