import java.net.InetAddress;
import java.net.UnknownHostException;

public class example {

	public static void main(String[] args) {
		
		//InetAddress ip = InetAddress.getByName("google.com");
//		System.out.println("호스트 이름 : " + ip.getHostName());
//		System.out.println("호스트 IP 주소 : " + ip.getHostAddress());
//		System.out.println();
		
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			
			System.out.println("localhost의 호스트 이름 : " + ip.getHostName());
			System.out.println("localhost의 IP 주소 : " + ip.getHostAddress());
		} catch (UnknownHostException e) {
		
			e.printStackTrace();
		}

	}

}
