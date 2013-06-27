package com.zamoga.cal.core;

import java.math.BigInteger;

public class KaratsubaImpl implements IMultiplication {

	@Override
	public BigInteger execute( BigInteger number1, BigInteger number2) {
		
		if( number1.longValue() < 10 || number2.longValue() < 10 ) {
			return number1.multiply( number2 );
		}
		
		int max = Math.max( number1.bitLength(), number2.bitLength() );
		max = (max/2) + (max%2);
		
		BigInteger b = number1.shiftRight( max );
        BigInteger a = number1.subtract(b.shiftLeft( max ));
        BigInteger d = number2.shiftRight( max );
        BigInteger c = number2.subtract(d.shiftLeft( max ));

        BigInteger ac    = execute(a, c);
        BigInteger bd    = execute(b, d);
        BigInteger abcd  = execute(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(max)).add(bd.shiftLeft(2*max));
	}

}
