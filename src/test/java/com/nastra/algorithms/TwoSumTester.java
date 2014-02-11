package com.nastra.algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class TwoSumTester {

    @Test
    public void testTwoSum() {
        int[] in = {1, 2, 3, 4, 7, 11};
        int target = 6;
        boolean hasSum = TwoSumSolver.hasSum(in, target);
        Assert.assertTrue(hasSum);
        hasSum = TwoSumSolver.hasSumOptimized(in, target);
        Assert.assertTrue(hasSum);
    }

    @Test
    public void testTwoSumFalse() {
        int[] in = {1, 2, 3, 4, 7, 11};
        int target = 16;
        boolean hasSum = TwoSumSolver.hasSum(in, target);
        Assert.assertFalse(hasSum);
        hasSum = TwoSumSolver.hasSumOptimized(in, target);
        Assert.assertFalse(hasSum);
    }

    @Test
    public void testTwoSumOneElement() {
        int[] in = {11};
        int target = 11;
        boolean hasSum = TwoSumSolver.hasSum(in, target);
        Assert.assertFalse(hasSum);
        hasSum = TwoSumSolver.hasSumOptimized(in, target);
        Assert.assertFalse(hasSum);
    }

    @Test
    public void testTargetHigherThanTwoValues() {
        int[] in = {1, 3, 5, 7, 11};
        int target = 19;
        boolean hasSum = TwoSumSolver.hasSumOptimized(in, target);
        Assert.assertFalse(hasSum);
    }
}
