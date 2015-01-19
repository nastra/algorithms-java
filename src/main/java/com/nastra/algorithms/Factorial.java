package com.nastra.algorithms;

/**
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class Factorial {

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    public static long numberOfTrailingZeros(int n) {
    	long result = 0;
		long divider = 5;
		double res = n / divider;
		result += (long) res;
		while (res >= 1.0) {
			divider = divider * 5;
			res = n / divider;
			result += (long) res;
		}

		return result;
    }
}
