package com.nastra.algorithms.sorting;

/**
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class Merge extends AbstractSort {

    @Override
    public void sort(Comparable[] input) {
        if (null == input || input.length == 0) {
            return;
        }
        Comparable[] aux = new Comparable[input.length];
        sort(input, aux, 0, input.length - 1);
    }

    private void sort(Comparable[] input, Comparable[] aux, int low, int high) {
        if (high <= low) {
            // base case
            return;
        }
        int mid = ((high - low) / 2) + low;
        sort(input, aux, low, mid);
        sort(input, aux, mid + 1, high);
        // prevent merging if both subparts are sorted
        if (greaterThan(input[mid], input[mid + 1])) {
            merge(input, aux, low, mid, high);
        }
    }

    /**
     * Merges the two subparts
     *
     * @param input The input
     * @param aux The auxiliary array
     * @param low Indicates the starting index
     * @param mid Indicates the mid index
     * @param high Indicates the ending index
     */
    private void merge(Comparable[] input, Comparable[] aux, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        // copy items to auxiliary array
        for (int k = low; k <= high; k++) {
            aux[k] = input[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                input[k] = aux[j];
                j++;
            } else if (j > high) {
                input[k] = aux[i];
                i++;
            } else if (greaterThan(aux[i], aux[j])) {
                input[k] = aux[j];
                j++;
            } else {
                input[k] = aux[i];
                i++;
            }
        }
    }
}
