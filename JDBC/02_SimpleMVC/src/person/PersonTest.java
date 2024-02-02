package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonTest {

	PersonController pc = new PersonController();
	
	public static void main(String[] args) {
		
		PersonTest pt = new PersonTest();

		try {

			// Person 테이블에 추가
			//pt.addPerson(111, "김강우", "서울");
			//pt.addPerson(222, "고아라", "제주도");
			//pt.addPerson(333, "강태주", "경기도");

			// Person 테이블에서 데이터 수정
			//pt.updatePerson(111, "제주도");

			// person 테이블에서 데이터 삭제
			//pt.removePerson(333);

			// person 테이블에 있는 데이터 전체 보여주기
			//pt.searchAllPerson();

			// person 테이블에서 데이터 한개만 가져오기
			pt.searchPerson(111);

		}  catch (Exception e) {
			e.printStackTrace();
		}

	}


	// person 테이블에 추가 - INSERT 
	public void addPerson(int id, String name, String address) throws SQLException {// 메서드에서는 거의 try-catch안하고 던져버림!
		int result = pc.addPerson(id, name, address);
		if (result == 1) {
			System.out.println(name + "님, 회원가입 완료 ");	
		}
	}
	// person 테이블에 수정 - UPDATE 
	public void updatePerson(int id, String address) throws SQLException {
		int result = pc.updatePerson(id, address);
		if (result == 1) {
			System.out.println(result + "명 수정!");
		}
	}

	// person 테이블에 삭제 - DELETE
	public void removePerson(int id) throws SQLException {
		int result = pc.removePerson(id);
		if (result == 1) {
			System.out.println(result + "명 삭제!");
		}	
	}

	// person 테이블에 선택 - SELECT
	public void searchAllPerson() throws SQLException {
		
		ArrayList<Person> list = pc.searchAllPerson();
		for(Person p : list) {
			//System.out.println(p.getId() + ", " + p.getName()+ ", " +p.getAddress());
			System.out.println(p);
		}
	}

	public void searchPerson(int id) throws SQLException {
		Person person = pc.searchPerson(id);
		System.out.println(person);
	}
}
