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
assertArrayEquals(a, b) :  �迭 A�� B�� ��ġ�ϴ� �� Ȯ��
assertEquals(a, b) : ��ü A�� B�� ���� ������ Ȯ��
assertEquals(a, b, c) :  ��ü A�� B�� ���� ������ Ȯ��( a: ����, b:�����, c: ��������)
assertSame(a, b) : ��ü A�� B�� ���� ��ü���� Ȯ��
assertTrue(a): ���� a�� ������ Ȯ��
assertFalse(a) : ���� a�� �������� Ȯ��
assertNotNull(a) : ��ä A�� null�� �ƴ��� Ȯ��
assertNull(a) : ��ü a�� null���� Ȯ��
*/