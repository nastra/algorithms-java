package com.nastra.algorithms;

import com.nastra.algorithms.sorting.MergingKSortedArrays;
import com.nastra.algorithms.sorting.SortUtil;
import java.util.List;
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
}