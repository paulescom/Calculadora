package com.zamoga.cal.ui;


public class InputValidator {

	public void validate( String[] args ) throws Exception {	
		
		if( args == null || args.length != 2 ) {
			throw new Exception( "Error: numero de parametros incorrecto. Uso: operando1 operando2" );
		}
		
		if( args[0].length() > 20 || args[1].length() > 20 ) {
			throw new Exception( "Error: No se permiten numeros mayores a 15 digitos" );
		}
		
		Number op1 = null;
		Number op2 = null;
		try {
			op1 = Long.parseLong(args[0]);
			op2 = Long.parseLong(args[1]);
		} catch( NumberFormatException pe ) {
			throw new Exception( "Error: los operandos deben ser numeros" );
		}
		
		if( (op1 != null && op1.doubleValue() < 0) ||
			(op2 != null && op2.doubleValue() < 0) ) {
			throw new Exception( "Error: los operandos deben ser numeros positivos" );
		}

	}

}
