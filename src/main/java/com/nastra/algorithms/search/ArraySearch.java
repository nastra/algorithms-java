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

    /**
     * Performs a binary search on an unknown-length array that is sorted. The running time is still O(log n) as in the classical binary search.
     *
     * @param in The sorted array being searched
     * @param k The key to search for
     * @return The index where in[i] = k or -1 if k could not be found.
     */
    public static int binarySearchUnknownLength(int[] in, int k) {
        if (null == in || in.length == 0) {
            return -1;
        }
        int low = 0;
        int high = 0;
        int p = 1;
        while (true) {
            try {
                if (in[p] == k) { // we were lucky and found k
                    return p;
                } else if (k > in[p]) {
                    low = p;
                    p = p * 2;
                } else {
                    high = p - 1;
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                high = p - 1;
                break;
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            try {
                if (k == in[mid]) {
                    return mid;
                } else if (k > in[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). How do you find an
     * element in the rotated array efficiently? You may assume no duplicate exists in the array.
     *
     * @param in
     * @param k
     * @return The index of k if in[i] == k, or -1 if k could not be found.
     */
    public static int binarySearchRotatedArray(int[] in, int k) {
        if (null == in || in.length == 0) {
            return -1;
        }
        int low = 0;
        int high = in.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (in[mid] == k) {
                return mid;
            } else if (in[low] <= in[mid]) { // the left side is sorted
                if (k >= in[low] && k <= in[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (in[mid] < in[high]) {
                if (k >= in[mid] && k <= in[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
