package com.zamoga.cal.ui;

import org.junit.Before;
import org.junit.Test;

public class InputValidatorTest {

	private InputValidator validator;
	
	@Before
	public void setUp() throws Exception {
		validator = new InputValidator();
	}

	@Test(expected = Exception.class)
	public void testNumberFormat1() throws Exception {
		String[] args = { "5000X", "5000" };
		validator.validate( args );
	}
	
	@Test(expected = Exception.class)
	public void testNumberFormat2() throws Exception {
		
		String[] args = { "50000", "50ERROR00" };
		validator.validate( args );
	}
	
	@Test(expected = Exception.class)
	public void testTooMuchArgs() throws Exception {
		
		String[] args = { "50000", "50M00", "50M00", "50M00" };
		validator.validate( args );
	}
	
	@Test(expected = Exception.class)
	public void testTooLargeArgs1() throws Exception {
		
		String[] args = { "123456789012345678901", "5000000" };
		validator.validate( args );
	}
	
	@Test(expected = Exception.class)
	public void testTooLargeArgs2() throws Exception {
		
		String[] args = { "12345678", "123456789012345678901" };
		validator.validate( args );
	}
	
	@Test(expected = Exception.class)
	public void testNegativeArgs() throws Exception {
		
		String[] args = { "-12345678", "1234567890" };
		validator.validate( args );
	}

}
