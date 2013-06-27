package com.zamoga.cal.ui;

import java.math.BigInteger;

import com.zamoga.cal.core.IMultiplication;
import com.zamoga.cal.core.KaratsubaImpl;

public class Calculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if( !validateInput( args ) ) {
			return;
		}
		
		IMultiplication mult = new KaratsubaImpl();
		BigInteger result = mult.execute( new BigInteger( args[0] ), new BigInteger( args[1] ) );
		
		System.out.println( "Resultado: " + result );		
	}
	
	public static boolean validateInput( String[] args ) {
		InputValidator validator = new InputValidator();
		
		try {
			validator.validate( args );
		} catch( Exception e ) {
			System.out.println( e.getMessage() );
			return false;
		}
		
		return true;
	}

}
