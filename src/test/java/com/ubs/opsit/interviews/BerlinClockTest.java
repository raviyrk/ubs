package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BerlinClockTest {

	static TimeConverter timeConvertor;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		timeConvertor = new BerlinClock();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertTimeAllZeros() {
		
		String testString= "Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO";
		assertTrue(timeConvertor.convertTime("00:00:00").equalsIgnoreCase(testString));		
	}
	
	@Test
	public void testConvertTime13_17_01() {
		String testString= "O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO";
		assertTrue(timeConvertor.convertTime("13:17:01").equalsIgnoreCase(testString));		
	}
	@Test
	public void testConvertTime23_59_59() {
		String testString= "O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY";
		assertTrue(timeConvertor.convertTime("23:59:59").equalsIgnoreCase(testString));		
	}
	
	@Test
	public void testsomething(){
		
		double d =  10.0/ -0;
		if(d ==  Double.POSITIVE_INFINITY)
			System.out.println("P");
		else
			System.out.println("N");
		int i[] = {1};
		System.out.println(i[i.length -1]);
		method(i);
		System.out.println(i[i.length -1]);
		
	}
	
	private void method(int[] i){
		i[i.length-1]++;
	}

}
