package com.nastra.algorithms;

import com.nastra.algorithms.search.OrderStatistic;
import java.util.Arrays;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class OrderStatisticTest {

    @Test
    public void testNull() {
        int k = 3;
        Integer result = OrderStatistic.select(null, k);
        Assert.assertNull(result);
    }

    @Test
    public void testOneValue() {
        int[] a = {4};
        check(a, 1, 4);
    }

    @Test
    public void testTwoValues() {
        int[] a = {4, 9};
        check(a, 1, 4);
        check(a, 2, 9);
    }

    @Test
    public void testKOutOfBounds() {
        int[] a = {4, 9, 12};
        check(a, 0, null);
        check(a, 4, null);
    }

    @Test
    public void testSmallArray() {
        int[] a = {4, 9, 3, 6, 8, 1, 7};
        check(a, 4, 6);
        check(a, 7, 9);

        // int[] b = {4, 7, 2, 1, 3};
        // check(b, 2, 4, 2, 2);
        // check(b, 3, 4, 2, 2);
        // check(b, 2, 4, 3, 7);

        int[] c = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 1; i <= 10; i++) {
            check(c, i, c.length, 1, i);
        }
        check(c, 1, 10, 1, 1);
        check(c, 2, 10, 2, 3);
        check(c, 3, 10, 3, 5);
        check(c, 5, 10, 1, 5);
        check(c, 5, 10, 3, 7);
        check(c, 5, 10, 6, 10);

        check(c, 4, 7, 2, 5);

        int[] d = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3};
        check(d, 1, 10, 1, 1);
        check(d, 2, 5, 2, 1);
    }

    @Test
    public void testLargeRandomArray() {
        int[] sortedArray = generateArrayWithRandomNumbers(-1, Integer.MAX_VALUE, null);
        int[] a = sortedArray.clone();
        Arrays.sort(sortedArray);

        for (int i = 0; i < 10000; i++) {
            int k = Random.randInt(0, sortedArray.length - 1);
            Integer element = sortedArray[k];
            check(a, k + 1, element);
        }
    }

    @Test
    public void testLargeRandomArrayUpTo1000() {
        int[] sortedArray = generateArrayWithRandomNumbers(1, 1000, null);
        int[] a = sortedArray.clone();
        Arrays.sort(sortedArray);

        for (int i = 0; i < 10000; i++) {
            int k = Random.randInt(0, sortedArray.length - 1);
            Integer expected = sortedArray[k];
            check(a, k + 1, expected);
        }
    }

    @Test
    public void testLargeRandom() {
        int[] sortedArray = generateArrayWithRandomNumbers(1, 1000, 10000);
        int[] a = sortedArray.clone();
        Arrays.sort(sortedArray);

        for (int i = 0; i < 10000; i++) {
            int k = Random.randInt(0, sortedArray.length - 1);
            Integer expected = sortedArray[k];
            check(a, k + 1, expected);
        }
    }

    private int[] generateArrayWithRandomNumbers(int min, int max, Integer size) {
        java.util.Random random = new java.util.Random();
        int[] array;
        if (null == size) {
            array = new int[random.nextInt(10000 + 1)];
        } else {
            array = new int[size];
        }
        for (int i = 0; i < array.length; i++) {
            if (min == -1) {
                array[i] = random.nextInt(max);
            } else {
                array[i] = Random.randInt(min, max);

            }
        }
        return array;
    }

    private void check(int[] a, int k, Integer expectedResult) {
        Integer result = OrderStatistic.select(a, k);
        Assert.assertEquals(expectedResult, result);
        result = OrderStatistic.selectIterative(a, k);
        Assert.assertEquals(expectedResult, result);
    }

    private void check(int[] a, int lo, int high, int k, Integer expectedResult) {
        lo = lo - 1;
        high = high - 1;
        k = k - 1;
        k = k + lo;
        Integer result = OrderStatistic.sel(a, k, lo, high);
        Assert.assertEquals(expectedResult, result);
    }
}