package com.nastra.algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MinCoinsTest {

    @Test
    public void testSimple() {
        int sum = 11;
        int[] coins = {1, 3, 5};

        int expectedResult = 3;
        Assert.assertEquals(MinCoins.minCoins(sum, coins), expectedResult);
        Assert.assertEquals(MinCoins.min(sum, coins), expectedResult);

    }

    @Test
    public void testTwo() {
        int sum = 30;
        int[] coins = {1, 5, 10, 20, 50};

        int expectedResult = 2;
        Assert.assertEquals(MinCoins.minCoins(sum, coins), expectedResult);

        Assert.assertEquals(MinCoins.min(sum, coins), expectedResult);
    }

}
