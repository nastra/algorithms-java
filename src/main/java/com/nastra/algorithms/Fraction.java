package com.nastra.algorithms;

/**
 * @author nastra
 * 
 */
public class Fraction {
    long numerator;
    long denominator;

    public void reduce() {
        long n = numerator;
        long d = denominator;

        while (d != 0) {
            long t = d;
            d = n % d;
            n = t;
        }

        long gcd = n;

        numerator /= gcd;
        denominator /= gcd;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

}
