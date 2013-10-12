package com.nastra.algorithms.search;

/**
 *
 * @author nastra - Eduard Tudenhoefner
 */
public class ArraySearch {

    /**
     * This algorithm runs in time O(log n) because it uses binary search. This is the solution to the following interview question: "Design an
     * efficient algorithm that takes a sorted array and a key k and finds the index of the first occurring element larger than k. If all elements are
     * less than or equal to k, return -1."
     *
     * @param in The sorted array to search
     * @param k The key k
     * @return The index of the first occurrence larger than k. In case every element is less than or equal to k, we return -1;
     */
    public static int firstOccurrenceLargerThan(int[] in, int k) {
        if (null == in || in.length == 0) {
            return -1;
        }
        int result = -1;
        int low = 0;
        int high = in.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (k >= in[mid]) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }

    /**
     * Solution to the interview question: "Design an efficient algorithm that takes a sorted array of distinct integers and returns an index i, such
     * that A[i] = i or indicate that no such index exists."
     *
     * @param in
     * @return The element that has the property in[i] = i. In case such an element does not exist, we return -1
     */
    public static int elementEqualToIndex(int[] in) {
        if (null == in || in.length == 0) {
            return -1;
        }
        int low = 0;
        int high = in.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (in[mid] == mid) {
                return mid;
            } else if (in[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
