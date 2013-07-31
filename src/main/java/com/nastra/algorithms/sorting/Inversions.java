package com.nastra.algorithms.sorting;

/**
 * This is the solution to the following interview question:
 * <br>'Design an efficient algorithm that takes an array A of n numbers and returns the number of inverted pairs of indices.'
 * <br><br>
 * If a list is already sorted, then the number of inversions is 0. If the list is sorted in reverse order, then the number of inversions is at its
 * maximum. The number of possible inversions can be expressed by n * (n - 1) / 2 where n is the length of the input list. Formally speaking, two
 * elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j. For example, the input [2, 4, 1, 3, 5] has three inversions (2, 1), (4, 1), (4,
 * 3).
 *
 * <br> So in order to solve the problem, we basically can use merge countInversions. The strategy is as following: When there is an element a[j] that
 * is larger than a[i], we know that the rest of the elements residing in the array from i..mid are also inversions. Therefore we simply take (mid + 1
 * - i) and sum it up to the inversions already found so far. The time complexity is O(n log n) for sorting and counting the inversions.
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class Inversions {

    public static int countInversions(Comparable[] input) {
        if (null == input || input.length == 0) {
            return 0;
        }
        Comparable[] aux = new Comparable[input.length];
        return sortAndCount(input, aux, 0, input.length - 1);
    }

    private static int sortAndCount(Comparable[] input, Comparable[] aux, int low, int high) {
        if (high <= low) {
            // base case
            return 0;
        }
        int inversions = 0;
        int mid = ((high - low) / 2) + low;
        inversions += sortAndCount(input, aux, low, mid);
        inversions += sortAndCount(input, aux, mid + 1, high);
        // prevent merging if both subparts are sorted
        if (SortUtil.greaterThan(input[mid], input[mid + 1])) {
            inversions += mergeAndCount(input, aux, low, mid, high);
        }
        return inversions;
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
    private static int mergeAndCount(Comparable[] input, Comparable[] aux, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int inversions = 0;
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
            } else if (SortUtil.greaterThan(aux[i], aux[j])) {
                input[k] = aux[j];
                j++;
                inversions += mid + 1 - i;
            } else {
                input[k] = aux[i];
                i++;
            }
        }
        return inversions;
    }
}
