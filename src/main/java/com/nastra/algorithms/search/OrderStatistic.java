package com.nastra.algorithms.search;

import com.nastra.algorithms.Random;
import com.nastra.datastructures.StdRandom;

/**
 * This program determines the kth order statistic (the kth smallest number in a list) in O(n) time in the average case and O(n^2) time in the worst
 * case. It achieves this through the Quickselect algorithm.
 * 
 * @author nastra - Eduard Tudenhoefner
 */
public class OrderStatistic {

    public static int sel(int[] a, int k, int lo, int hi) {
        while (hi > lo) {
            // int p = randomizedPartition(a, lo, hi);
            int p = rpartition(a, lo, hi);
            // int p = partition3way(a, lo, hi);
            // int p = randomPartition(a, lo, hi);
            if (p == k) {
                return a[k];
            } else if (k < p) {
                hi = p - 1;
            } else {
                lo = p + 1;
            }
        }
        return a[k];
    }

    public static Integer select(int[] a, int k) {
        if (null == a || a.length == 0) {
            return null;
        }

        if (k < 1 || k > a.length) {
            return null;
        }

        return select(a, k, 0, a.length - 1);
    }

    public static Integer select(int[] a, int k, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return a[low];
        }
        int pivotIndex = randomPartition(a, low, high);
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

    public static Integer selectIterative(int[] a, int k) {
        if (null == a || a.length == 0) {
            return null;
        }
        if (k < 1 || k > a.length) {
            return null;
        }

        return selectIter(a, k, 0, a.length - 1);
    }

    public static Integer selectIter(int[] a, int k, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return a[low];
        }
        while (low <= high) {
            int pivotIndex = randomizedPartition(a, low, high);
            int leftSize = pivotIndex - low + 1;
            if (leftSize == k) {
                return a[pivotIndex];
            } else if (k < leftSize) {
                high = pivotIndex - 1;
            } else {
                low = pivotIndex + 1;
                k = k - leftSize;
            }
        }
        return null;
    }

    public static int randomPartition(int[] list, int leftIndex, int rightIndex) {
        int pivotIndex = medianOf3(list, leftIndex, rightIndex);
        int pivotValue = list[pivotIndex];
        int storeIndex = leftIndex;

        swap(list, pivotIndex, rightIndex);

        for (int i = leftIndex; i < rightIndex; i++) {
            if (list[i] <= pivotValue) {
                swap(list, storeIndex, i);
                storeIndex++;
            }
        }

        swap(list, rightIndex, storeIndex);

        return storeIndex;
    }

    private static int rpartition(int[] a, int lo, int hi) {
        int randomIndex = StdRandom.uniform(lo, hi + 1);
        swap(a, lo, randomIndex);
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            // find item on lo to swap
            while (a[++i] < v)
                if (i == hi)
                    break;

            // find item on hi to swap
            while (v < a[--j])
                if (j == lo)
                    break; // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j)
                break;

            swap(a, i, j);
        }

        // put partitioning item v at a[j]
        swap(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    public static int medianOf3(int[] list, int leftIndex, int rightIndex) {
        int centerIndex = (leftIndex + rightIndex) / 2;

        if (list[leftIndex] > list[rightIndex]) {
            swap(list, leftIndex, centerIndex);
        }

        if (list[leftIndex] > list[rightIndex]) {
            swap(list, leftIndex, rightIndex);
        }

        if (list[centerIndex] > list[rightIndex]) {
            swap(list, centerIndex, rightIndex);
        }

        swap(list, centerIndex, rightIndex - 1);

        return rightIndex - 1;
    }

    private static int part(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {

            // find item on lo to swap
            while (a[++i] < v)
                if (i == hi)
                    break;

            // find item on hi to swap
            while (v < a[--j])
                if (j == lo)
                    break; // redundant since a[lo] acts as sentinel

            // check if pointers cross
            if (i >= j)
                break;

            swap(a, i, j);
        }

        // put partitioning item v at a[j]
        swap(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    private static int partition3way(int[] a, int lo, int hi) {
        int lt = lo, gt = hi;
        int v = a[lo];
        int i = lo;
        while (i <= gt) {
            if (a[i] < v)
                swap(a, lt++, i++);
            else if (a[i] > v)
                swap(a, i, gt--);
            else
                i++;
        }
        return lt;
    }
}
