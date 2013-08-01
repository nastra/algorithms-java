package com.nastra.algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nastra
 */
public class LevenshteinDistanceTest {

    @Test
    public void testOne() {
        String a = "cat";
        String b = "dog";
        int expectedDistance = 3;
        int dist = LevenshteinDistance.computeDistance(a.toCharArray(), b.toCharArray());

        Assert.assertEquals(dist, expectedDistance);
    }

    @Test
    public void testTwo() {
        String a = "meilenstein";
        String b = "levenshtein";
        int expectedDistance = 3;
        int dist = LevenshteinDistance.computeDistance(a.toCharArray(), b.toCharArray());

        Assert.assertEquals(dist, expectedDistance);
    }

    @Test
    public void testThree() {
        String a = "Tier";
        String b = "Tor";
        int expectedDistance = 2;
        int dist = LevenshteinDistance.computeDistance(a.toCharArray(), b.toCharArray());

        Assert.assertEquals(dist, expectedDistance);
    }

    @Test
    public void testFour() {
        String a = "";
        String b = "Tor";
        int expectedDistance = 3;
        int dist = LevenshteinDistance.computeDistance(a.toCharArray(), b.toCharArray());

        Assert.assertEquals(dist, expectedDistance);
    }
}