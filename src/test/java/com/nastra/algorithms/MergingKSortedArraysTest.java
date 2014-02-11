package com.nastra.algorithms;

import com.nastra.algorithms.sorting.MergingKSortedArrays;
import com.nastra.algorithms.sorting.SortUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author nastra
 */
public class MergingKSortedArraysTest {

    @Test
    public void testMergingThreeSortedArrays() {
        int[] one = {3, 5, 12};
        int[] two = {4, 8, 9, 13};
        int[] three = {1, 2, 6, 14, 31};
        int[][] input = new int[3][];
        input[0] = one;
        input[1] = two;
        input[2] = three;
        List<Integer> result = MergingKSortedArrays.merge(input);
        Integer[] out = new Integer[result.size()];
        Assert.assertTrue(SortUtil.isSorted(result.toArray(out)));
    }

    @Test
    public void testMergingManySortedArrays() {
        int size = 999;
        int[][] input = new int[size][];
        for (int i = 0; i < size; i++) {
            input[i] = generateSortedArrayWithRandomNumbers();
        }
        List<Integer> result = MergingKSortedArrays.merge(input);
        Integer[] out = new Integer[result.size()];
        Assert.assertTrue(SortUtil.isSorted(result.toArray(out)));
    }

    private int[] generateSortedArrayWithRandomNumbers() {
        Random random = new Random();
        int[] array = new int[random.nextInt(1000)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        Arrays.sort(array);
        return array;
    }
}