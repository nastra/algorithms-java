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
        int k = 1;
        Integer result = OrderStatistic.select(a, k);
        Assert.assertTrue(result.equals(4));
    }

    @Test
    public void testTwoValues() {
        int[] a = {4, 9};
        int k = 1;
        Integer result = OrderStatistic.select(a, k);
        Assert.assertTrue(result.equals(4));
    }

    @Test
    public void testKOutOfBounds() {
        int[] a = {4, 9, 12};
        int k = 0;
        Integer result = OrderStatistic.select(a, k);
        Assert.assertNull(result);
        k = 4;
        result = OrderStatistic.select(a, k);
        Assert.assertNull(result);
    }

    @Test
    public void testSmallArray() {
        int[] a = {4, 9, 3, 6, 8, 1, 7};
        int k = 4;
        Integer result = OrderStatistic.select(a, k);
        Assert.assertTrue(result.equals(6));
    }

    @Test
    public void testSmallArrayTwo() {
    }

    @Test
    public void testLargeRandomArray() {
        int[] sortedArray = generateArrayWithRandomNumbers();
        int[] a = sortedArray.clone();
        Arrays.sort(sortedArray);

        for (int i = 0; i < 10000; i++) {
            int randomIndex = Random.randInt(0, sortedArray.length - 1);
            Integer element = sortedArray[randomIndex];
            Integer result = OrderStatistic.select(a, randomIndex + 1);
            Assert.assertEquals(element, result);
        }
    }

    private int[] generateArrayWithRandomNumbers() {
        java.util.Random random = new java.util.Random();
        int[] array = new int[random.nextInt(1000)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        // Arrays.sort(array);
        return array;
    }
}