/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nastra.algorithms.sorting;

import com.nastra.algorithms.Random;

/**
 * 
 * @author nastra
 */
public class Quick {

    public static void sort(Comparable[] in) {
        if (null == in || in.length < 2) {
            return;
        }

        randomizedSort(in, 0, in.length - 1);
        // sort(in, 0, in.length - 1);
    }

    /**
     * This version of the quicksort algorithm uses randomized partitioning
     * 
     * @param in
     * @param low
     * @param high
     */
    private static void randomizedSort(Comparable[] in, int low, int high) {
        if (low >= high) {
            return;
        }

        int p = randomizedPartition(in, low, high);
        sort(in, low, p - 1);
        sort(in, p + 1, high);
    }

    /**
     * This version of sort uses the book-like quicksort implementation.
     * 
     * @param in
     * @param low
     * @param high
     */
    private static void sort(Comparable[] in, int low, int high) {
        if (low >= high) {
            return;
        }

        int p = partition(in, low, high);
        sort(in, low, p - 1);
        sort(in, p + 1, high);
    }

    private static int partition(Comparable[] in, int low, int high) {
        Comparable q = in[low];
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (SortUtil.lessThan(in[j], q)) {
                SortUtil.swap(in, i, j);
                i++;
            }
        }
        SortUtil.swap(in, low, i - 1);
        return i - 1;
    }

    /**
     * 
     * @param in
     * @param low
     * @param high
     * @return
     */
    private static int randomizedPartition(Comparable[] in, int low, int high) {
        int randomIndex = Random.randInt(low, high);
        SortUtil.swap(in, low, randomIndex);
        return partition(in, low, high);
    }
}
