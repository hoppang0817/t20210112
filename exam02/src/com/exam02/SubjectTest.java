package com.exam02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubjectTest {

	static Connection conn = null;
	static SubjectDAOImpl subjectDAO = null;
	
	@BeforeClass
	public static void before() {
		System.out.println("deleteSubjectTest 시작");
	}
	
	@AfterClass
	public static void after() {
		System.out.println("deleteSubjectTest 종료");
	}
	
	@Test
	public void connectiontest() {
		conn = DBConnection.getConnection();
		subjectDAO = new SubjectDAOImpl(conn);
		assertNotNull(conn);
	}
	
	@Test
	public void  insertSubjectTest() throws Exception {
		Subject s1 = new Subject("10025", "테스트", "a-5", "아무나", "15:00", null);
		int result = subjectDAO.insertSubject(s1);
		assertEquals(result, 1);
	}
	
	@Test
	public void updateSubjectTest() throws Exception {
		Subject s2 = new Subject("10025", "Junit활용", "a-5", "가나다", "15:00", null); 
		int result = subjectDAO.updateSubject(s2);
		assertEquals(result, 1);
	}
	
	@Test
	public void deleteSubjectTest() throws Exception {
		Subject s3 = new Subject(); 
		s3.setSubject_code("10025");
		int result = subjectDAO.deleteSubject(s3);
		assertEquals(result, 1);
	}

	@Test
	public void selectSubjectTest() throws Exception {
		List<Subject>subjectList = subjectDAO.selectSubject();
		for(Subject tmp : subjectList) {
			System.out.println(tmp.toString());
		}
		assertNotNull(subjectList);
	}
	

}
