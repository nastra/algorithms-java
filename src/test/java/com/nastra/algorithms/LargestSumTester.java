package com.nastra.algorithms;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author nastra
 */
public class LargestSumTester {

    @Test
    public void largestSumTester() {

        int[] one = {-8, 3, -2, 4, -10};
        int expectedSum = 5;
        int sum = LargestSum.largestSum(one);
        Assert.assertEquals(expectedSum, sum);


        int[] two = {-6, 3, -5, 9, -4, 7};
        expectedSum = 12;
        sum = LargestSum.largestSum(two);
        Assert.assertEquals(expectedSum, sum);

        int[] three = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        expectedSum = 43;
        sum = LargestSum.largestSum(three);
        Assert.assertEquals(expectedSum, sum);
    }
}