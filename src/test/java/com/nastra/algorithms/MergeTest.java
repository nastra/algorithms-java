package com.nastra.algorithms;

import com.nastra.algorithms.sorting.Merge;
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
    private Merge merge;

    @BeforeMethod
    public void init() {
        random = new Random();
        merge = new Merge();
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
        Assert.assertFalse(merge.isSorted(input));
        Assert.assertTrue(merge.isSorted(sortedInput));
        merge.sort(input);
        Assert.assertEquals(input, sortedInput);
    }
}
