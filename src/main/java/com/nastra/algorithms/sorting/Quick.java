/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nastra.algorithms.sorting;

/**
 *
 * @author nastra
 */
public class Quick {

    public static void sort(Comparable[] in) {
        if (null == in || in.length < 2) {
            return;
        }

        sort(in, 0, in.length - 1);
    }

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
}
