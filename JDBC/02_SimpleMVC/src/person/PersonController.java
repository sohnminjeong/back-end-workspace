package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonController {

	public PersonController() {
		try {
			// 드라이버 로딩은 한번만 해도 가능!
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// [고정적인 반복] -- DB 연결, 자원 반납 -> 공통적인 메서드 정의.. 메서드마다 호출해서 사용!
	// DB연결 메서드
	public Connection getConnect() throws SQLException {
		// 2. 디비 연결 (각각 들어갈때마다 해야 함)
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		return conn; // conn의 리턴형태는 Connection이기 때문에 void에서 Connection으로 변경
	}

	// 자원 반납 메서드(ps, conn용)
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	// 자원 반납 메서드(rs, ps, conn용)
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	
	
	
	// [변동적인 반복] -- 비즈니스 로직 DAO(Database Access Object)
	public int addPerson(int id, String name, String address) throws SQLException {
		Connection conn = getConnect(); // getConnect() 메서드 따로 만들어서 변수conn으로 호출

		// 3. 쿼리문 -> PreparedStatement
		String query = "INSERT INTO person VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);

		// System.out.println(ps.executeUpdate() + "명 추가!");?
		int result = ps.executeUpdate(); // executeUpdate에서 성공시 1, 실패시 -1 
		
		// 5. 자원 반납
		closeAll(ps, conn);
		
		return result;
	}

	public int updatePerson(int id, String address) throws SQLException {
		Connection conn = getConnect();

		String query = "UPDATE person set address = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, address);
		ps.setInt(2, id);

		// System.out.println(ps.executeUpdate() + "명 수정!");
		int result = ps.executeUpdate();
		
		// 5. 자원 반납
		closeAll(ps, conn);
		
		return result;
	}

	public int removePerson(int id) throws SQLException {
		Connection conn = getConnect();

		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, id);

		// System.out.println(ps.executeUpdate() + "명 삭제!");
		int result = ps.executeUpdate();

		// 5. 자원 반납
		closeAll(ps, conn);
		
		return result;

	}

	public ArrayList<Person> searchAllPerson() throws SQLException {
		Connection conn = getConnect();

		String query = "SELECT * FROM person";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		// SELECT때만 executeQuery이고 나머지는 executeUpdate 사용  
		// executeQuery : 쿼리를 실행하고, 결과를 ResultSet 객체로 반환한다
		
		ArrayList<Person> list = new ArrayList<>();
		while (rs.next()) {
			// 생성자 방식
			list.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
			
			// setter 방식
			//Person person = new Person();  // setter방식은 돌아갈 때마다 객체 생성 및 list 추가를 선언해줘야 함 
			//person.setId(rs.getInt("id"));
			//person.setName(rs.getString("name"));
			//person.setAddress(rs.getString("address"));
			//list.add(person);
		}
				
		// 5. 자원 반납
		closeAll(rs, ps, conn);
		
		return list;

	}

	public Person searchPerson(int id) throws SQLException {
		Connection conn = getConnect();

		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		Person person = null;
		
		if(rs.next()) {
			person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
		}
		
		// 5. 자원 반납
		closeAll(rs, ps, conn);
		
		return person;
	}

}
