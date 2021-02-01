package com.example.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {
	
	//�׽�Ʈ�� Ŭ������
	static Calc calc = null;
	
	
	//�ѹ��� ����
	@BeforeClass
	public static void beforeClass() {
		 calc = new Calc(1,2);
		 System.out.println("beforeClass");
	}
	
	//��ü���� �� �׽�Ʈ ���� ����
	@Before
	public void before() {
	 
	  System.out.println("before");
	}
	
	//�׽�Ʈ
	@Test
	public void test() {
		
		int result = calc.sum();
		assertEquals(3,result);
	}
	
	@Test
	public void test1() {
		
		int result = calc.sum(5,6);
		assertEquals(11,result);
	}

	@Test
	public void test2() {
		System.out.println("DB���� �׽�Ʈ");
		Connection conn = calc.getConnection();
		assertNotNull(conn);
	}

	
	@After
	public void After() {
		System.out.println("after");
	}
	
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("afterClass");
	}
}
/*
assertArrayEquals(a, b) :  배열 A와 B가 일치하는 지 확인
assertEquals(a, b) : 객체 A와 B가 같은 값인지 확인
assertEquals(a, b, c) :  객체 A와 B가 같은 값인지 확인( a: 예상값, b:결과값, c: 오차범위)
assertSame(a, b) : 객체 A와 B가 같은 객체인지 확인
assertTrue(a): 조건 a가 참인지 확인
assertFalse(a) : 조건 a가 거짓인지 확인
assertNotNull(a) : 객채 A가 null이 아닌지 확인
assertNull(a) : 객체 a가 null인지 확인
*/