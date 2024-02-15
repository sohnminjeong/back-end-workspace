package com.kh.test8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "1234");
			// 1. mysql-connector 연결
			// 2. query문 작성 필요 
			String query = "SELECT emp_id, emp_name FROM kh.employee";
			PreparedStatement st = conn.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			// 3. select문 사용하는 것이기 때문에 executeUpdate()가 아닌 executeQuery() 사용해야 한다
			
			while(rs.next()) {
				// 4. rs가 아닌 rs.next()사용
				System.out.println(rs.getString("emp_id") + " / " + rs.getString("emp_name"));
				// 5. 컬럼명을 그대로 적어야 하기 때문에 "emp_id", "emp_name"으로 작성 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
