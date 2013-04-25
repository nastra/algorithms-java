package com.nastra.algorithms;

import java.util.Arrays;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nastra
 */
public class MergeTest {

    private Random random;
    private Merge merge;

    @Before
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
        Assert.assertArrayEquals(input, sortedInput);
    }
}
