package com.kh.test7;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		
		try {
			InetAddress ip = InetAddress.getLocalHost();
			// 서버 ip를 위해 InetAddress.getLocalHost()를 InetAddress 타입으로 ip에 담아야 함
			Socket s = new Socket(ip.getHostAddress(), 3000);
			// Socket()에서 괄호 안에 ip주소, 포트번호를 적어야 하며 
			// ip주소는 ip.getHostAddress()를 통해 확인 가능.
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
