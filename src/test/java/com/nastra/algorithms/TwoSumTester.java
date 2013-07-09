package com.nastra.algorithms;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author nastra
 */
public class TwoSumTester {

    @Test
    public void testTwoSum() {
        int[] in = {1, 2, 3, 4, 7, 11};
        int target = 6;
        boolean hasSum = TwoSum.hasSum(in, target);
        Assert.assertTrue(hasSum);
    }

    @Test
    public void testTwoSumFalse() {
        int[] in = {1, 2, 3, 4, 7, 11};
        int target = 16;
        boolean hasSum = TwoSum.hasSum(in, target);
        Assert.assertFalse(hasSum);
    }

    @Test
    public void testTwoSumOneElement() {
        int[] in = {11};
        int target = 11;
        boolean hasSum = TwoSum.hasSum(in, target);
        Assert.assertFalse(hasSum);
    }
}
