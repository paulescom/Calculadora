package com.zamoga.cal.core;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import com.zamoga.cal.core.KaratsubaImpl;

public class KaratsubaImplTest {
	
	private KaratsubaImpl multiplication;

	@Before
	public void setUp() throws Exception {
		multiplication = new KaratsubaImpl();
	}

	@Test
	public void testLitteNumbers() {
		BigInteger result = multiplication.execute( BigInteger.valueOf(5), BigInteger.valueOf(5) );
		assertEquals( "5 x 5 debe ser 25", 
					  BigInteger.valueOf( 25 ), 
					  result );
	}
	
	
	@Test
	public void testNormalNumbers() {
		BigInteger result = multiplication.execute( BigInteger.valueOf(5000000), BigInteger.valueOf(5000000) );
		assertEquals( "5.000.000 x 5.000.000 debe ser 25000000000000", 
					  BigInteger.valueOf( 25000000000000L ), 
					  result );
	}
	
	@Test
	public void testSameNumber() {
		BigInteger result = multiplication.execute( BigInteger.valueOf(1), BigInteger.valueOf(123456789012345L) );
		assertEquals( "1 x 123.456.789.012.345 debe ser 123.456.789.012.345", 
					  BigInteger.valueOf( 123456789012345L ), 
					  result );
	}

}
