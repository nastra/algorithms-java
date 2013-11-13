package com.nastra.algorithms;

import com.nastra.algorithms.search.SquareRoot;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class SquareRootTest {

    @Test
    public void testOne() {
        double x = 45d;

        double result = SquareRoot.sqrt(x);
        double expectedResult = Math.sqrt(x);
        Assert.assertEquals(result, expectedResult, 0.001);
    }

    @Test
    public void testTwo() {
        double x = 49d;

        double result = SquareRoot.sqrt(x);
        double expectedResult = Math.sqrt(x);
        Assert.assertEquals(result, expectedResult, 0.001);
    }

    @Test
    public void testThree() {
        double x = 12389234d;

        double result = SquareRoot.sqrt(x);
        double expectedResult = Math.sqrt(x);
        Assert.assertEquals(result, expectedResult, 0.001);
    }
}