package com.nastra.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nastra.algorithms.sorting.Inversions;
import com.nastra.algorithms.sorting.Merge;
import com.nastra.algorithms.sorting.SortUtil;

/**
 * 
 * @author nastra
 */
public class InversionsTest {

    @Test
    public void testOne() {
        Integer[] in = {2, 4, 1, 3, 5};
        int expectedResult = 3;
        int result = Inversions.countInversions(in);

        Assert.assertEquals(result, expectedResult);
        Assert.assertTrue(SortUtil.isSorted(in));
    }

    @Test
    public void testTwo() {
        Integer[] in = {3, 4, 1, 6, 9, 2};
        int expectedResult = 6;
        int result = Inversions.countInversions(in);

        Assert.assertEquals(result, expectedResult);
        Assert.assertTrue(SortUtil.isSorted(in));
    }
    
    @Test
    public void testThree() {
        Integer[] in = {2, 3, 1, 5, 4};
        System.out.println(Inversions.countInversions(in));
    }

    @Test
    public void countInversionsInAReverseSortedArray() {
        Random rand = new Random();
        Integer[] in = new Integer[100002];
        for (int i = 0; i < 100002; i++) {
            in[i] = rand.nextInt();
        }
        Merge.sort(in);
        List<Integer> reversed = Arrays.asList(in);
        Collections.reverse(reversed);
        in = reversed.toArray(in);
        Assert.assertTrue(SortUtil.isSortedInReverse(in));
        int n = in.length;
        int maxNumberOfInversions = (int) Math.ceil((double) (n * (n - 1)) / 2);
        int inversions = Inversions.countInversions(in);
        // Assert.assertEquals(inversions, maxNumberOfInversions);

    }
}