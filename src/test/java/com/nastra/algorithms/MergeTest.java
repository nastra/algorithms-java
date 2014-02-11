package com.nastra.algorithms;

import com.nastra.algorithms.sorting.Merge;
import com.nastra.algorithms.sorting.SortUtil;
import java.util.Arrays;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class MergeTest {

    private Random random;

    @BeforeMethod
    public void init() {
        random = new Random();
    }

    @Test
    public void testSortingNumbers() {
        Integer[] input = new Integer[100000];
        Integer[] sortedInput = new Integer[100000];
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt();
        }
        System.arraycopy(input, 0, sortedInput, 0, input.length);
        Arrays.sort(sortedInput);
        Assert.assertFalse(SortUtil.isSorted(input));
        Assert.assertTrue(SortUtil.isSorted(sortedInput));
        Merge.sort(input);
        Assert.assertEquals(input, sortedInput);
    }
}
