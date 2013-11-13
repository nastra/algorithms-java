package com.nastra.algorithms;

import com.nastra.algorithms.search.Power;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class PowerTest {

    @Test
    public void testZero() {
        int base = 2;
        int exp = 0;
        long pow = Power.power(base, exp);
        double expected = Math.pow(base, exp);

        Assert.assertEquals((double) pow, expected);
    }

    @Test
    public void testEven() {
        int base = 2;
        int exp = 32;
        long pow = Power.power(base, exp);
        double expected = Math.pow(base, exp);

        Assert.assertEquals((double) pow, expected);
    }

    @Test
    public void testOdd() {
        int base = 2;
        int exp = 35;
        long pow = Power.power(base, exp);
        double expected = Math.pow(base, exp);

        Assert.assertEquals((double) pow, expected);
    }

    @Test
    public void testEvenTwo() {
        int base = 10;
        int exp = 12;
        long pow = Power.power(base, exp);
        double expected = Math.pow(base, exp);

        Assert.assertEquals((double) pow, expected);
    }

    @Test
    public void testOddTwo() {
        int base = 10;
        int exp = 17;
        long pow = Power.power(base, exp);
        double expected = Math.pow(base, exp);

        Assert.assertEquals((double) pow, expected);
    }
}
