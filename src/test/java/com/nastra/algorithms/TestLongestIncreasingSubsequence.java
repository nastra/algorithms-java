package com.nastra.algorithms;

import com.nastra.algorithms.search.LongestIncreasingSubsequence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class TestLongestIncreasingSubsequence {

    @Test
    public void simpleTest() {
        int[] s = {3, 2, 6, 4, 5, 1};
        int[] expected = {2, 4, 5};
        int result = LongestIncreasingSubsequence.longestIncreasingSubsequenceLength(s);
        Assert.assertEquals(result, expected.length);
    }

    @Test
    public void testIncreasingArray() {
        int[] s = {1, 2, 3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int result = LongestIncreasingSubsequence.longestIncreasingSubsequenceLength(s);
        Assert.assertEquals(result, expected.length);
    }

    @Test
    public void testDecreasingArray() {
        int[] s = {6, 5, 4, 3, 2, 1};
        int result = LongestIncreasingSubsequence.longestIncreasingSubsequenceLength(s);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testRandomArray() {
        int[] s = {10, 22, 9, 33, 21, 50, 41, 60};
        int[] expected = {10, 22, 33, 50, 60};
        int result = LongestIncreasingSubsequence.longestIncreasingSubsequenceLength(s);
        Assert.assertEquals(result, expected.length);
    }

    @Test
    public void testRandomArrayTwo() {
        int[] s = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        int[] expected = {2, 3, 7, 8, 10, 13};
        int result = LongestIncreasingSubsequence.longestIncreasingSubsequenceLength(s);
        Assert.assertEquals(result, expected.length);
    }
}