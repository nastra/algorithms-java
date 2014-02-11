package com.nastra.algorithms;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class RandomTest {

    @Test
    public void testSimple() {
        int min = 5;
        int max = 6;
        verify(min, max);
    }

    @Test
    public void testSmallRange() {
        int min = 0;
        int max = 10;
        verify(min, max);
    }

    @Test
    public void testBigRange() {
        int min = 37;
        int max = 10123902;
        verify(min, max);
    }

    @Test
    public void testRepeatedly() {
        int min = 0;
        int max = 1000;
        for (int i = 0; i < 5000; i++) {
            verify(min, max);
        }
    }

    @Test
    public void testNegative() {
        int min = -5;
        int max = -1;
        verify(min, max);
    }

    private void verify(int min, int max) {
        int result = Random.randInt(min, max);
        Assert.assertTrue(min <= result && result <= max);

    }
}