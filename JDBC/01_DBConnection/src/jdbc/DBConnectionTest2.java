package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest2 {

	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/kh";
	public static final String USER = "root";
	public static final String PASSWORD = "1234";
	// final : 변수를 상수로 만드는 키워드 
	
	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			//System.out.println("1. 드라이버 로딩...!!");
			
			// 2. 디비 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//System.out.println("2. 디비 연결...!!");
			
			// 3. 쿼리 준비 - INSERT
			String query = 
					"INSERT INTO employee(emp_id, emp_name, emp_no) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 4. 쿼리문 실행
			ps.setInt(1, 700);
			ps.setString(2, "손민정");
			ps.setString(3, "111111-2222222");
			
			System.out.println(ps.executeUpdate() + "명 추가!");
			

		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("디비 연결 실패");
		}
		
		
	}

}
