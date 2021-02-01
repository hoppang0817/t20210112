package com.example.junit;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.project.DBConnection;
import com.project.Student;
import com.project.StudentDAOImpl;

public class StudentTeat {

	static Connection conn = null;
	static StudentDAOImpl sDAO = null;
	
	
	
	@BeforeClass
	public static void init() {//@Test의 메소드 수행전 최초 1 회만 수행됨
		conn = DBConnection.getConnection();
		sDAO = new StudentDAOImpl(conn);
		
	}
	
	@AfterClass
	public static void end() {//@Test의 메소드 수행 후 최초 1회만 수행됨
		System.out.println("테스트가 종료되었습니다.");
	}
	
	@Before
	public void before() {//@Test의 메소드 수행전 호출되는데 테스트 개수만큼 출력
		System.out.println("before");
	}
	
	@After
	public void after() {//@Test의 메소드 수행후 호출되는데 테스틑 개수만큼 출력됨
		System.out.println("after");
	}
	
	@Test
	public void DBConntest() {
		assertNotNull(conn);
	}
	
//	@Test//studentDAOImpl의 insertTest()를 수행했을때 결과
//	public void inserttest() throws Exception {
//		Student stdent = new Student("0000000009","가나다",3,"010-0000-1111","컴공",null);
//		int result = sDAO.insertStudent(stdent);
//		assertEquals(result, 1);
//	}

//	@Test
//	public void deleteTest() throws Exception {
//		Student s1 = new Student();
//		s1.setStudent_id("0000000009");
//		int result = sDAO.deleteStudent(s1);
//		assertEquals(result, 1);
//	}

	@Test
	public void selectTest() throws Exception {
		List<Student>list = sDAO.selectStudentList();
		assertNotNull(list);
		
	}
	
	@Test
	public void selectOneTest() throws Exception {
		Student s1 = new Student();
		s1.setStudent_id("0000000001");
		Student student = sDAO.selectStudentOne(s1);
		assertNotNull(student);
	}
}
