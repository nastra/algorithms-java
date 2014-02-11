package com.nastra.algorithms.search;

import com.nastra.algorithms.Random;

/**
 * This program determines the kth order statistic (the kth smallest number in a list) in O(n) time in the average case and O(n^2) time in the worst
 * case. It achieves this through the Quickselect algorithm.
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class OrderStatistic {

    public static Integer select(int[] a, int k) {
        if (null == a || a.length == 0) {
            return null;
        }

        if (k < 1 || k > a.length) {
            return null;
        }

        return select(a, k, 0, a.length - 1);
    }

    private static Integer select(int[] a, int k, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return a[low];
        }
        int pivotIndex = randomizedPartition(a, low, high);
        int leftSize = pivotIndex - low + 1;

        if (leftSize == k) {
            return a[pivotIndex];
        } else if (k < leftSize) {
            return select(a, k, low, pivotIndex - 1);
        } else {
            return select(a, k - leftSize, pivotIndex + 1, high);
        }
    }

    private static int randomizedPartition(int[] in, int low, int high) {
        int randomIndex = Random.randInt(low, high);
        swap(in, low, randomIndex);
        return partition(in, low, high);
    }

    private static int partition(int[] a, int low, int high) {
        int p = low;
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (a[j] <= a[p]) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, low, i - 1);
        return i - 1;
    }

    private static void swap(int[] in, int i, int j) {
        int tmp = in[i];
        in[i] = in[j];
        in[j] = tmp;
    }
}
