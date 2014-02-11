package com.nastra.algorithms;

import com.nastra.algorithms.search.LonelyIntegerSearch;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class LonelyIntegerSearchTest {

    @Test
    public void testNull() {
        int[] s = null;
        Integer result = LonelyIntegerSearch.findNumber(s);
        Assert.assertNull(result);
    }

    @Test
    public void testOne() {
        int[] s = {1};
        Integer result = LonelyIntegerSearch.findNumber(s);
        Assert.assertEquals(result, Integer.valueOf(1));
    }

    @Test
    public void testTwo() {
        int[] s = {2, 2};
        Integer result = LonelyIntegerSearch.findNumber(s);
        Assert.assertEquals(result, Integer.valueOf(0));
    }

    @Test
    public void testThree() {
        int[] s = {1, 1, 2};
        Integer result = LonelyIntegerSearch.findNumber(s);
        Assert.assertEquals(result, Integer.valueOf(2));
    }

    @Test
    public void testSmall() {
        int[] s = {0, 0, 1, 2, 1};
        Integer result = LonelyIntegerSearch.findNumber(s);
        Assert.assertEquals(result, Integer.valueOf(2));

    }
}