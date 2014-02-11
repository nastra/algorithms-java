package com.nastra.algorithms;

import com.nastra.algorithms.search.FindUnsortedSubsequence;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class FindUnsortedSubsequenceTest {

    @Test
    public void simpleTest() {
        int[] s = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        FindUnsortedSubsequence.Result result = FindUnsortedSubsequence.find(s);
        Assert.assertTrue(result.getStart() == 3, "Start was: " + result.getStart());
        Assert.assertTrue(result.getEnd() == 9, "End was: " + result.getEnd());
    }

    @Test
    public void simpleTestTwo() {
        int[] s = {1, 2, 4, 4, 5, 9, 1, 3, 6, 11, 15};
        FindUnsortedSubsequence.Result result = FindUnsortedSubsequence.find(s);
        Assert.assertTrue(result.getStart() == 1, "Start was: " + result.getStart());
        Assert.assertTrue(result.getEnd() == 8, "End was: " + result.getEnd());
    }

    @Test
    public void simpleTestThree() {
        int[] s = {5, 4, 3, 2, 11, 12, 13, 14, 15};
        FindUnsortedSubsequence.Result result = FindUnsortedSubsequence.find(s);
        Assert.assertTrue(result.getStart() == 0, "Start was: " + result.getStart());
        Assert.assertTrue(result.getEnd() == 3, "End was: " + result.getEnd());
    }

    @Test
    public void simpleTestFour() {
        int[] s = {1, 2, 3, 4, 5, 11, 15, 13, 12};
        FindUnsortedSubsequence.Result result = FindUnsortedSubsequence.find(s);
        Assert.assertTrue(result.getStart() == 6, "Start was: " + result.getStart());
        Assert.assertTrue(result.getEnd() == 8, "End was: " + result.getEnd());
    }
}